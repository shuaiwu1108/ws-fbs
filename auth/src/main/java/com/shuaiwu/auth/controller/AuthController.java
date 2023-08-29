package com.shuaiwu.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/login")
  public String login(){
    System.out.println("用户登录");
    String res  = restTemplate.getForObject("http://127.0.0.1:8011/user/add", String.class);
    return "用户登录" + res;
  }
}
