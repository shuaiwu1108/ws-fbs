package com.shuaiwu.auth.feign;

import org.springframework.stereotype.Component;

@Component
public class UserFiegnServiceFallBack implements UserFeignService{

  public String add() {
    return "降级了";
  }

  public String get() {
    return "降级了";
  }
}
