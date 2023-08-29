package com.shuaiwu.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Value("${server.port}")
  private String port;

  @RequestMapping("/add")
  public String add(){
    System.out.println("用户增加成功");
    return "Hello world!" + port;
  }

  @RequestMapping("get")
  public String get(){
    int a = 1/0;
    return "hello workd! get";
  }
}
