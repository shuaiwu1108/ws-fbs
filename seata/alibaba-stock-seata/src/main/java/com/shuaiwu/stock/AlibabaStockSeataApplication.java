package com.shuaiwu.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuaiwu.stock.mapper")
public class AlibabaStockSeataApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlibabaStockSeataApplication.class, args);
  }
}
