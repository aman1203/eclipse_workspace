package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.service.RibbonService;

@Service
public class RobbinServiceImpl implements RibbonService {
  @Autowired
  private RestTemplate restTemplate;
  public String ribbonTetst() {
    return restTemplate.getForEntity("http://client/eurekaclient/getClient", String.class).getBody();
  }
}
