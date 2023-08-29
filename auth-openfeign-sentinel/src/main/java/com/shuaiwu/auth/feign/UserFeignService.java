package com.shuaiwu.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service", path = "/user", fallback = UserFiegnServiceFallBack.class)
public interface UserFeignService {

  @RequestMapping("/add")
  String add();

  @RequestMapping("get")
  String get();
}
