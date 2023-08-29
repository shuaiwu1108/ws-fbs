package com.shuaiwu.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    Entry entry = null;
    try {
      entry = SphU.entry("hello");
      String str = "hello world";
      log.info("=========" + str + "==========");
      return str;
    } catch (BlockException e) {
      log.info("block!");
      return "被流控了！";
    } catch (Exception e) {
      Tracer.traceEntry(e, entry);
    } finally {
      if (entry != null) {
        entry.exit();
      }
    }
    return null;
  }

  /**
   * 改善sentinel配置，使用SentinelResource注解
   * value 定义资源
   * blockHandler 设置熔断处理类，默认放在同一类
   * blockHandlerClass 熔断处理类，需要设定为static方法
   * fallback 配置异常处理
   * 如果两者同时匹配，则blockHandler优先级更高
   * @return
   */
  @RequestMapping("/getUser")
  @SentinelResource(value = "getUser", blockHandler = "blockHandlerForGetUser", fallback = "fallBackForGetUser")
  public String getUser(){
    int a = 1/0;
    return "shuaiwu";
  }

  @RequestMapping("/degrade")
  @SentinelResource(value = "degrade", entryType = EntryType.IN, blockHandler = "blockHandlerForDegrade")
  public String degrade(){
    int a = 1/0;
    return "degrade 返回";
  }

  /**
   * 一定要public
   * 返回值、参数和源方法保持一致
   * @param id
   * @param ex
   * @return
   */
  public static String blockHandlerForGetUser(BlockException ex){
    log.error("", ex);
    return "getUser 流控！";
  }

  public static String fallBackForGetUser(Throwable ex){
    ex.printStackTrace();
    return "getUser 异常";
  }

  public static String blockHandlerForDegrade(BlockException ex){
    return "degrade 降级";
  }

  /**
   * 流控规则
   */
  @PostConstruct
  private static void initFlowRules(){
    List<FlowRule> rules = new ArrayList<>();
    FlowRule rule = new FlowRule();
    rule.setResource("hello");//为资源进行流控
    rule.setGrade(1);//
    rule.setCount(1);
    rules.add(rule);

    FlowRule rule2 = new FlowRule();
    rule.setResource("getUser");//为资源进行流控
    rule.setGrade(1);//
    rule.setCount(1);
    rules.add(rule2);

    FlowRuleManager.loadRules(rules);
  }

  /**
   * 降级规则
   */
  @PostConstruct
  private static void initDegradeRule(){
    List<DegradeRule> degradeRules = new ArrayList<>();
    DegradeRule degradeRule = new DegradeRule();
    degradeRule.setResource("degrade");
    //异常数
    degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
    //请求2个异常，进行降级
    degradeRule.setCount(2);
    degradeRule.setMinRequestAmount(2);//最小请求2次
    degradeRule.setStatIntervalMs(60 * 1000 * 60);//统计时长
    degradeRule.setTimeWindow(10);//熔断持续时间
    degradeRules.add(degradeRule);
    DegradeRuleManager.loadRules(degradeRules);
  }
}
