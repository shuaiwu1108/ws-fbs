package com.shuaiwu.stock.controller;

import com.shuaiwu.stock.entity.StockTest;
import com.shuaiwu.stock.service.IStockTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuaiwu
 * @since 2023-08-28
 */
@RestController
@RequestMapping("/stock/stockTest")
public class StockTestController {

  @Autowired
  private IStockTestService iStockTestService;

  @RequestMapping("list")
  public Object list(){
    return iStockTestService.list();
  }

  @RequestMapping("subStock")
  public String subStock(int productId){
    iStockTestService.lambdaUpdate()
        .setSql("count = count - 1")
        .eq(StockTest::getProductId, productId)
        .update();
    return "产品: " + productId + ", 库存-1";
  }
}
