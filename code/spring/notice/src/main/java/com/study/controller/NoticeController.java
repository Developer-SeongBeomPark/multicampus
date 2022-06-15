package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
  
  @GetMapping()
  public String home() {
    return "/home";
  }
  
  
}
