package com.shuaiwu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.shuaiwu.order.mapper")
@EnableFeignClients
public class AlibabaOrderSeataApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlibabaOrderSeataApplication.class, args);
  }
}
