package com.example.feignClient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 定义调用接口
 * 
 * @author Administrator
 */
@Service
@FeignClient(value ="client",fallbackFactory=TestFallbackFactoryService.class)
public interface TestService {
  @RequestMapping(value="/eurekaclient/getClient",method=RequestMethod.GET)
  public abstract String test();
  @RequestMapping(value="/eurekaclient/getClient1",method=RequestMethod.GET)
  public abstract String test1();
}
