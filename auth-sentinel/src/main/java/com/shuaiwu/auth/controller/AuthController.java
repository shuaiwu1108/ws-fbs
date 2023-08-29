package com.shuaiwu.auth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @RequestMapping("/getUser")
  //@SentinelResource(value = "getUser", blockHandler = "flowBlockHandler2")
  public String getUser() throws InterruptedException {
//    TimeUnit.SECONDS.sleep(5);
    return "sentinel server";
  }

  public static String flowBlockHandler2(BlockException ex){
    return "getUser 流控";
  }

  @RequestMapping("/add")
  public String add(){
    return "生成订单";
  }

  @RequestMapping("/get")
  public String get(){
    return "查询订单";
  }

  //链路流控需要关闭收敛 web-context-unify: false
  //链路流控不走全局exception，需要自定义blockhandler

  //流控效果，预热、排队等待
  //预热，激增流量
  //排队等待，脉冲流量
}
