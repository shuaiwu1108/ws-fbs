package com.shuaiwu.auth.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

  public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      BlockException e) throws Exception {
    log.info(String.valueOf(e.getRule()));
    String r = "";
    if (e instanceof FlowException){
      r = "接口限流";
    }else if(e instanceof DegradeException){
      r = "服务降级";
    }else if(e instanceof ParamFlowException){
      r = "热点参数限流";
    }else if(e instanceof SystemBlockException){
      r = "触发系统保护规则";
    }else if(e instanceof AuthorityException){
      r = "授权规则不通过";
    }

    httpServletResponse.setStatus(500);
    httpServletResponse.setCharacterEncoding("utf-8");
    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
    new ObjectMapper().writeValue(httpServletResponse.getWriter(), r);
  }
}
