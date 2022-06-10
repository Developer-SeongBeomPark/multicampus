package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.model.AddrDAO;
import com.study.model.AddrDTO;
import com.study.model.AddrService;
import com.study.utility.Utility;

@Controller
public class AddrController {
  @Autowired
  @Qualifier("com.study.model.AddrServiceImpl")
  private AddrService dao;
  
  @RequestMapping("/")
  public String home() {
    return "/home";
  }
  
  //========== list =========================
  
  @RequestMapping("/addr/list")
  public String list(HttpServletRequest request) {
    // 검색 관련------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));
    
    if(col.equals("total")){
      word = "";
    }
    
    // 페이징 관련--------
    int nowPage = 1;
    if(request.getParameter("nowPage") != null){
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 5;
    
    int sno = ((nowPage - 1) * recordPerPage);
    int eno = recordPerPage;
    
    //1. model 사용
    Map map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("eno", eno);
    List<AddrDTO> list = dao.list(map);
    int total = dao.total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    
    //2. request 저장(view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("nowPage", nowPage);
    
    return "/list";
  }
  
  //========== read =========================
  
  @RequestMapping("/addr/read/{addressnum}")
  public String read(@PathVariable int addressnum, Model model) {
    
    AddrDTO dto = dao.read(addressnum);
    dto.setAddressnum(addressnum);
    
    model.addAttribute("dto", dto);
    return "/read";
  }
  
  //========== create =========================
  
  @GetMapping("/addr/create")
  public String create() {
    
    return "/create";
  }
  
  @PostMapping("/addr/create")
  public String create(AddrDTO dto) {
    
    int flag = dao.create(dto);
    
    if(flag != 1) {
      return "error";
    }
    else {
      return "redirect:list";
    }
  }
  
  //========== update =========================
  
  @GetMapping("/addr/update/{addressnum}")
  public String update(@PathVariable int addressnum, Model model) {
    
    AddrDTO dto = dao.read(addressnum);
    dto.setAddressnum(addressnum);
    
    model.addAttribute("dto", dto);
    
    return "/update";
  }
  
  @PostMapping("/addr/update")
  public String update(AddrDTO dto) {
    
    int flag = dao.update(dto);
    if(flag != 1) {
      return "error";
    }else {
      return "redirect:list";
    }
  }
  
  //========== delete =========================
  
  @GetMapping("/addr/delete/{addressnum}")
  public String delete(@PathVariable int addressnum, Model model) {
    
    model.addAttribute("addressnum", addressnum);
    return "/delete";
  }
  
  @PostMapping("/addr/delete")
  public String delete(HttpServletRequest request) {
    
    int flag = dao.delete(Integer.parseInt(request.getParameter("addressnum")));
    if(flag != 1) return "error";
    else return "redirect:list";
  }
  
}
