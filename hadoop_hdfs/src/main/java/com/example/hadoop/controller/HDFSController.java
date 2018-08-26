package com.example.hadoop.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.hadoop.service.HDFSService;

@RestController
public class HDFSController {
  @Autowired
  private HDFSService service;

  @GetMapping("/fileLoadDown")
  public String fileLoadDown() throws Exception {
    return service.fileLoadDown();
  }
  
  @GetMapping("/fileUpLoad")
  public String fileUpLoad() throws Exception {
    return service.fileUpLoad();
  }
  
  @GetMapping("/mkdir/{dir}")
  public String mkdir(@PathVariable("dir")String path) throws Exception {
    service.mkdir(path);
    return "Success";
  }
  
  @GetMapping("/rm/{path}")
  public String rm(@PathVariable("path")String path) throws Exception {
    String[] str = StringUtils.split(path, "-");
    StringBuffer sb = new StringBuffer("/");
    for(String value:str) {
      sb.append(value+"/");
    }
    service.rm(sb.toString());
    return "Success";
  }
}
