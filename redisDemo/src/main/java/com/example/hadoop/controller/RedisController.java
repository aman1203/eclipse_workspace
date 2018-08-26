package com.example.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.hadoop.inteface.impl.DemoServiceImpl;
@RestController
public class RedisController {
  @Autowired
  private DemoServiceImpl service;
  
  @GetMapping("/getData{start-end}")
  @Cacheable
  public String getData(@PathVariable("start") String start,@PathVariable("end") String end) throws Exception{
    int startId = Integer.parseInt(start);
    int endId = Integer.parseInt(end);
    String result = service.getData(startId, endId);
    return result;
  }
}
