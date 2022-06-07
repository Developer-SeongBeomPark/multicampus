package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.bean.Member;

@Controller
public class HelloController {
  
  @RequestMapping("/test4/{id}/{name}")
  public String test4(@PathVariable String id, @PathVariable String name, Model model) {
    model.addAttribute("id", id);
    model.addAttribute("name", name);
    
    return "test4";
  }
  
  @RequestMapping("/test3")
  public String test3(Member member, Model model) {
    
    //model.addAttribute("member", member);
    
    return "test3";
  }
  
  @RequestMapping("/test2")
  public String test2(String id, String name, Model model) {
    model.addAttribute("id", id);
    model.addAttribute("name", name);
    
    return "test2";
  }
  
  @RequestMapping("/test1") //get방식으로 먼저 찾고 없으면 post방식으로 찾음
  public String test1(HttpServletRequest request, Model model) {
    
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    
    model.addAttribute("id", id);// request.setAttribute("id",id)와 동일한 코드
    model.addAttribute("name", name);
    
    return "test1";
  }
  
  @GetMapping("/") // = @RequestMapping("/")
  @ResponseBody
  public String hello() {
    
    return "Hello world!";
  }
  
  @RequestMapping("/index")
  public String test() {
    return "index";
  }
}
