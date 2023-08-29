package com.shuaiwu.order.controller;

import com.shuaiwu.order.api.StockService;
import com.shuaiwu.order.entity.OrderTest;
import com.shuaiwu.order.service.IOrderTestService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuaiwu
 * @since 2023-08-28
 */

@Slf4j
@RestController
@RequestMapping("/order/orderTest")
public class OrderTestController {

  @Autowired
  private IOrderTestService iOrderTestService;

  @Autowired
  private StockService stockService;

  @RequestMapping("/list")
  public Object list(){
    return iOrderTestService.list();
  }

  @GlobalTransactional
  @RequestMapping("/add")
  public Object add(){
    OrderTest orderTest = new OrderTest();
    orderTest.setProductId(1);
    orderTest.setTotalAmount(100);
    orderTest.setStatus(1);
    iOrderTestService.save(orderTest);

    String msg = stockService.subStock(orderTest.getProductId());
    log.info(msg);

//    int a = 1/0;
    return orderTest;
  }
}
