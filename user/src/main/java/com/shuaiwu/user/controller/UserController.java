package com.shuaiwu.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/add")
  public String add(){
    System.out.println("用户增加成功");
    return "Hello world!";
  }
}
