package com.example.validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcController {

  public CalcController() {
    System.out.println(">>> CalcController created");
  }
  
  @GetMapping("/calc")
  public String calc() {
    
    return "/calc/form";
  }
}
