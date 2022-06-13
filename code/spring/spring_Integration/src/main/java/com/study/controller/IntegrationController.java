package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.DTO;
import com.study.model.DTO;
import com.study.model.IntegrationService;
import com.study.model.DTO;
import com.study.utility.Utility;

@Controller
public class IntegrationController {

  @Autowired
  @Qualifier("com.study.model.IntegrationServiceImpl")
  private IntegrationService dao;

  @GetMapping("/")
  public String main(Locale locale, Model model) {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);
    return "/home";
  }

  // ======================= bbs ==================================

  @GetMapping("/bbs/list")
  public String b_list(HttpServletRequest request) {
    // 검색 관련------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if (col.equals("total")) {
      word = "";
    }

    // 페이징 관련--------
    int nowPage = 1;
    if (request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 7;

    int sno = ((nowPage - 1) * recordPerPage);
    int eno = recordPerPage;

    // 1. model 사용
    Map map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("eno", eno);
    List<DTO> list = dao.list(map);
    int total = dao.total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

    // 2. request 저장(view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("nowPage", nowPage);

    return "/b/list";
  }

  @GetMapping("/bbs/create")
  public String b_create() {
    return "/b/create";
  }

  @PostMapping("/bbs/create")
  public String b_create(DTO dto) {
    int cnt = dao.create(dto);
    if (cnt != 1) {
      return "/error";
    }
    return "redirect:list";
  }

  @GetMapping("/bbs/read/{bbsno}")
  public String b_read(@PathVariable int bbsno, Model model) {
    dao.upViewcnt(bbsno);
    model.addAttribute("dto", dao.read(bbsno));
    return "/b/read";
  }

  @GetMapping("/bbs/update/{bbsno}")
  public String b_update(@PathVariable int bbsno, Model model) {
    model.addAttribute("dto", dao.read(bbsno));
    return "/b/update";
  }

  @PostMapping("/bbs/update")
  public String b_update(DTO dto) {
    Map map = new HashMap();
    map.put("bbsno", dto.getBbsno());
    map.put("passwd", dto.getPasswd());
    int pflag = dao.passCheck(map);
    int flag = 0;
    if (pflag == 1) {
      flag = dao.update(dto);
    }
    if (pflag != 1)
      return "passwdError";
    else if (flag != 1)
      return "error";
    else {
      return "redirect:list";
    }
  }

  @GetMapping("/bbs/delete/{bbsno}")
  public String b_delete(@PathVariable int bbsno, Model model) {
    model.addAttribute("bbsno", bbsno);
    return "/b/delete";
  }

  @PostMapping("/bbs/delete")
  public String b_delete(@RequestParam Map<String, String> map) {
    int bbsno = Integer.parseInt(map.get("bbsno"));
    int pflag = dao.passCheck(map);
    int flag = 0;
    if (pflag == 1)
      flag = dao.delete(bbsno);

    if (pflag != 1)
      return "passwdError";
    else if (flag != 1)
      return "error";
    else
      return "redirect:list";
  }

  @GetMapping("/bbs/reply/{bbsno}")
  public String b_reply(@PathVariable int bbsno, Model model) {
    model.addAttribute("dto", dao.readReply(bbsno));
    return "/b/reply";
  }

  @PostMapping("/bbs/reply")
  public String b_reply(DTO dto) {
    Map map = new HashMap();
    map.put("grpno", dto.getGrpno());
    map.put("ansnum", dto.getAnsnum());
    dao.upAnsnum(map);
    if (dao.createReply(dto) == 1) {
      return "redirect:list";
    } else {
      return "error";
    }
  }

//======================= addr ==================================
  
  @RequestMapping("/addr/list")
  public String a_list(HttpServletRequest request) {
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
    List<DTO> list = dao.a_list(map);
    int total = dao.a_total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    
    //2. request 저장(view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("nowPage", nowPage);
    
    return "/a/list";
  }
  
  
  
  @RequestMapping("/addr/read/{addressnum}")
  public String a_read(@PathVariable int addressnum, Model model) {
    
    DTO dto = dao.a_read(addressnum);
    dto.setAddressnum(addressnum);
    
    model.addAttribute("dto", dto);
    return "/a/read";
  }
  
 
  
  @GetMapping("/addr/create")
  public String a_create() {
    
    return "/a/create";
  }
  
  @PostMapping("/addr/create")
  public String a_create(DTO dto) {
    
    int flag = dao.a_create(dto);
    
    if(flag != 1) {
      return "error";
    }
    else {
      return "redirect:list";
    }
  }
  
  
  
  @GetMapping("/addr/update/{addressnum}")
  public String a_update(@PathVariable int addressnum, Model model) {
    
    DTO dto = dao.a_read(addressnum);
    dto.setAddressnum(addressnum);
    
    model.addAttribute("dto", dto);
    
    return "/a/update";
  }
  
  @PostMapping("/addr/update")
  public String a_update(DTO dto) {
    
    int flag = dao.a_update(dto);
    if(flag != 1) {
      return "error";
    }else {
      return "redirect:list";
    }
  }
  
  
  
  @GetMapping("/addr/delete/{addressnum}")
  public String a_delete(@PathVariable int addressnum, Model model) {
    
    model.addAttribute("addressnum", addressnum);
    return "/a/delete";
  }
  
  @PostMapping("/addr/delete")
  public String a_delete(HttpServletRequest request) {
    
    int flag = dao.a_delete(Integer.parseInt(request.getParameter("addressnum")));
    if(flag != 1) return "error";
    else return "redirect:list";
  }
  
  
  
//======================= memo ==================================

  @GetMapping("/memo/list")
  public String m_list(HttpServletRequest request) {
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
    List<DTO> list = dao.m_list(map);
    int total = dao.m_total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    
    //2. request 저장(view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("nowPage", nowPage);
    
    return "/m/list";
  }
  
  @GetMapping("/memo/create")
  public String m_create() {
    return "/m/create";
  }
  
  @PostMapping("/memo/create")
  public String m_create(DTO dto) {
    int flag = dao.m_create(dto);
    if(flag != 1) return "error";
    else return "redirect:list";
  }
  
  @GetMapping("/memo/read/{memono}")
  public String m_read(@PathVariable int memono, Model model) {
    dao.m_upViewcnt(memono);
    DTO dto = dao.m_read(memono);
    dto.setMemono(memono);
    model.addAttribute("dto", dto);
    return "/m/read";
  }
  
  @GetMapping("/memo/update/{memono}")
  public String m_update(@PathVariable int memono, Model model) {
    DTO dto = dao.m_read(memono);
    dto.setMemono(memono);
    model.addAttribute("dto", dto);
    return "/m/update";
  }
  
  @PostMapping("/memo/update")
  public String m_update(DTO dto) {
    Map map = new HashMap();
    map.put("memono", dto.getMemono());
    map.put("passwd", dto.getPasswd());
    
    int pflag = dao.m_passCheck(map);
    int flag = -1;
    if(pflag == 1){
      flag = dao.m_update(dto);
    }
    if(pflag != 1) return "passwdError";
    else if(flag != 1) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/memo/delete/{memono}")
  public String m_delete(@PathVariable int memono, Model model) {
    model.addAttribute("memono", memono);
    
    return "/m/delete";
  }
  
  @PostMapping("/memo/delete")
  public String m_delete(@RequestParam Map map) {
    int pflag = dao.m_passCheck(map);
    int flag = -1;
    if(pflag == 1){
      flag = dao.m_delete(map);
    }
    if(pflag != 1) return "passwdError";
    else if(flag != 1) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/memo/reply/{memono}")
  public String m_reply(@PathVariable int memono, Model model) {
    DTO dto = dao.m_readReply(memono);
    model.addAttribute("dto", dto);
    return "/m/reply";
  }
  
  @PostMapping("/memo/reply")
  public String m_reply(DTO dto) {
    Map map = new HashMap();
    map.put("grpno", dto.getGrpno());
    map.put("ansnum", dto.getAnsnum());
    
    dao.m_upAnsnum(map);
    int flag = dao.m_createReply(dto);
    
    if(flag != 1) return "error";
    else return "redirect:list";
    
  }


}
