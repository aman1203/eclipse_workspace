package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.RibbonService;
@Controller
public class RibbonController {
  @Autowired
  private RibbonService ribbonService;
  @GetMapping("/ribbon")
  public @ResponseBody String ribbon() {
    return ribbonService.ribbonTetst();
  }
}
