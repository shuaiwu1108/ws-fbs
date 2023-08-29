package com.shuaiwu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.shuaiwu.order.mapper")
public class OrderSeataApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderSeataApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder){
    return builder.build();
  }
}
