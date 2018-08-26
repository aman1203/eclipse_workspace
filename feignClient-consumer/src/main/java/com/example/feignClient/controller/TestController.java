package com.example.feignClient.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.feignClient.service.TestService;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Application;

/**
 * 测试控制器
 * 
 * @author Administrator
 */
@RestController
public class TestController {
  @Autowired
  private TestService service;

  @GetMapping("/test")
  public String getClient() {
    return service.test();
  }
  @GetMapping("/test1")
  public String getClient1() {
    return service.test1();
  }
}
