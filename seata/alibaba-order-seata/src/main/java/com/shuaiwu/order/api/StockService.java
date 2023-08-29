package com.shuaiwu.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "alibaba-stock-seata", path = "/stock/stockTest")
public interface StockService {

  @RequestMapping("subStock")
  public String subStock(@RequestParam(value = "productId") int productId);
}
