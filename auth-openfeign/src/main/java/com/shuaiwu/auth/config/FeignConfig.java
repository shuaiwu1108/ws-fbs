package com.shuaiwu.auth.config;

import com.shuaiwu.auth.interceptor.feign.CustomFeignInterceptor;
import feign.Contract;
import feign.Logger.Level;
import feign.Request.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

  @Bean
  public Level feignLoggerLevel(){
    return Level.FULL;
  }

  /**
   * feign超时时间配置
   * @return
   */
  @Bean
  public Options options(){
    return new Options(5000, 10000);
  }

  /**
   * 自定义feign拦截器
   * @return
   */
//  @Bean
//  public CustomFeignInterceptor customFeignInterceptor(){
//    return new CustomFeignInterceptor();
//  }

  /**
   * 修改契约配置，支持Feign原生注解
   * @return
   */
//  @Bean
//  public Contract feignContract(){
//    return new Contract.Default();
//  }
}
