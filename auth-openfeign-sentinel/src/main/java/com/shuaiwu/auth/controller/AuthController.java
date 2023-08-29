package com.shuaiwu.auth.controller;

import com.shuaiwu.auth.feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserFeignService userFeignService;

  @RequestMapping("/login")
  public String login(){
    System.out.println("用户登录");
    String res = userFeignService.add();
    return "用户登录" + res;
  }

  @RequestMapping("/get")
  public String get(){
    return "hello feign " + userFeignService.get();
  }
}
