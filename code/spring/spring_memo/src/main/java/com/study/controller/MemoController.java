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
import org.springframework.web.bind.annotation.RequestParam;

import com.study.memo.UploadMemo;
import com.study.model.MemoDTO;
import com.study.model.MemoService;
import com.study.utility.Utility;

@Controller
public class MemoController {
  @Autowired
  @Qualifier("com.study.model.MemoServiceImpl")
  private MemoService dao;
  
  @GetMapping("/")
  public String home() {
    return "/home";
  }
  
  @GetMapping("/memo/list")
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
    List<MemoDTO> list = dao.list(map);
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
  
  @GetMapping("/memo/create")
  public String create() {
    return "/create";
  }
  
  @PostMapping("/memo/create")
  public String create(MemoDTO dto) {
    String upDir = UploadMemo.getUploadDir();
    if(dto.getFilenameMF().getSize() > 0) {
      dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
      dto.setFilesize((int)dto.getFilenameMF().getSize());
    }
        
    int flag = dao.create(dto);
    if(flag != 1) return "error";
    else return "redirect:list";
  }
  
  @GetMapping("/memo/read/{memono}")
  public String read(@PathVariable int memono, Model model) {
    dao.upViewcnt(memono);
    MemoDTO dto = dao.read(memono);
    dto.setMemono(memono);
    model.addAttribute("dto", dto);
    return "/read";
  }
  
  @GetMapping("/memo/update/{memono}")
  public String update(@PathVariable int memono, Model model) {
    MemoDTO dto = dao.read(memono);
    dto.setMemono(memono);
    model.addAttribute("dto", dto);
    return "/update";
  }
  
  @PostMapping("/memo/update")
  public String update(MemoDTO dto) {
    Map map = new HashMap();
    map.put("memono", dto.getMemono());
    map.put("passwd", dto.getPasswd());
    
    int pflag = dao.passCheck(map);
    int flag = -1;
    if(pflag == 1){
      flag = dao.update(dto);
    }
    if(pflag != 1) return "passwdError";
    else if(flag != 1) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/memo/delete/{memono}")
  public String delete(@PathVariable int memono, Model model) {
    model.addAttribute("memono", memono);
    
    return "/delete";
  }
  
  @PostMapping("/memo/delete")
  public String delete(@RequestParam Map map) {
    int pflag = dao.passCheck(map);
    int flag = -1;
    if(pflag == 1){
      flag = dao.delete(map);
    }
    if(pflag != 1) return "passwdError";
    else if(flag != 1) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/memo/reply/{memono}")
  public String reply(@PathVariable int memono, Model model) {
    MemoDTO dto = dao.readReply(memono);
    model.addAttribute("dto", dto);
    return "/reply";
  }
  
  @PostMapping("/memo/reply")
  public String reply(MemoDTO dto) {
    Map map = new HashMap();
    map.put("grpno", dto.getGrpno());
    map.put("ansnum", dto.getAnsnum());
    
    dao.upAnsnum(map);
    int flag = dao.createReply(dto);
    
    if(flag != 1) return "error";
    else return "redirect:list";
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
