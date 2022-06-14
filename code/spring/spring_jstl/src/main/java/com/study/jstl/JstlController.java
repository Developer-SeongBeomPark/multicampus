package com.study.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JstlController {
  
  @RequestMapping
  public String home(Model model) {
     
    
    return "jstl/useFunctions";
  }
}
