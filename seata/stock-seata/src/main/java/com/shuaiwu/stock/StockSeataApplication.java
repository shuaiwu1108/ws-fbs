package com.shuaiwu.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuaiwu.stock.mapper")
public class StockSeataApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockSeataApplication.class, args);
  }
}
