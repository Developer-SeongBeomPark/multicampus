package com.study.contents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.study.review.ReviewService;
import com.study.shop.UploadCon;
import com.study.utility.Utility;

@Controller
public class ContentsController {
  private static final Logger log = LoggerFactory.getLogger(ContentsController.class);

  @Autowired
  @Qualifier("com.study.contents.ContentsServiceImpl")
  private ContentsService service;
  
  @Autowired
  @Qualifier("com.study.model.ReviewServiceImpl")
  private ReviewService rservice;
  
  
  @GetMapping("/admin/contents/delete/{contentsno}")
  public String delete(@PathVariable("contentsno") int contentsno) {
    
    int cnt = service.delete(contentsno);
    
    if(cnt == 1) {
      return "redirect:/admin/contents/list";
    }
    else {
      return "error";
    }
    
  }
  
  
  
  
  @GetMapping("/admin/contents/read/{contentsno}")
  public String read(@PathVariable("contentsno") int contentsno, Model model) {
   
    ContentsDTO dto = service.read(contentsno);
    model.addAttribute("dto", dto);
    
    return "/contents/read";
  }
  
  
  
  @PostMapping("/contents/updateFile")
  public String updateFile(MultipartFile filenameMF, String oldfile, int contentsno) throws IOException {
    String basePath = UploadCon.getUploadDir();
    
    if (oldfile != null && !oldfile.equals("default.jpg")) { // ???????????? ??????
      Utility.deleteFile(basePath, oldfile);
    }

    // pstorage??? ?????? ?????? ??????
    Map map = new HashMap();
    map.put("contentsno", contentsno);
    map.put("fname", Utility.saveFileSpring(filenameMF, basePath));

    // ????????? ????????? ??????
    int cnt = service.updateFile(map);

    if (cnt == 1) {
      return "redirect:/admin/contents/list";
    } else {
      return "./error";
    }
  }

  @GetMapping("/admin/contents/updateFile/{contentsno}/{oldfile}")
  public String updateFileForm(@PathVariable("contentsno") int contentsno, @PathVariable("oldfile") String oldfile,
      Model model) {
    model.addAttribute("contentsno", contentsno);
    model.addAttribute("oldfile", oldfile);

    return "/contents/updateFile";
  }

  @RequestMapping("/admin/contents/list")
  public String list(HttpServletRequest request) {
//    String id = (String)session.getAttribute("id");
//    
//    if (id == null || id.equals("H")) {
//      return "redirect:/member/login";
//    }
    
    // ????????????------------------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if (col.equals("total")) {
      word = "";
    }

    // ???????????????-----------------------
    int nowPage = 1;// ?????? ???????????? ?????????
    if (request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 5;// ??????????????? ????????? ???????????????

    // (oracle) DB?????? ????????? ??????-----------------
    // int sno = ((nowPage - 1) * recordPerPage) + 1;
    // int eno = nowPage * recordPerPage;

    // (mysql) DB?????? ????????? ??????-----------------
    int sno = (nowPage - 1) * recordPerPage;
    int eno = recordPerPage;

    Map map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("eno", eno);

    int total = service.total(map);

    List<ContentsDTO> list = service.list(map);

    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

    // request??? Model?????? ?????? ?????????
    request.setAttribute("list", list);
    request.setAttribute("nowPage", nowPage);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("rservice", rservice);

    return "/admin/contents/list";

  }

  @PostMapping("/admin/contents/update")
  public String update(ContentsDTO dto) {
    int cnt = service.update(dto);

    if (cnt == 1) {
      return "redirect:./list";
    } else {
      return "error";
    }
  }

  @GetMapping("/admin/contents/update/{contentsno}")
  public String update(@PathVariable("contentsno") int contentsno, Model model) {

    ContentsDTO dto = service.read(contentsno);

    model.addAttribute("dto", dto);

    return "/admin/contents/update";

  }

  @PostMapping("/contents/create")
  public String create(ContentsDTO dto, HttpServletRequest request) throws IOException {
    String upDir = UploadCon.getUploadDir();

    String fname = Utility.saveFileSpring(dto.getFilenameMF(), upDir);
    int size = (int) dto.getFilenameMF().getSize();

    if (size > 0) {
      dto.setFilename(fname);
    } else {
      dto.setFilename("default.jpg");
    }

    if (service.create(dto) > 0) {
      return "redirect:/admin/contents/list";
    } else {
      return "error";
    }
  }

  @GetMapping("/admin/contents/create")
  public String create() {
    return "/contents/create";
  }

  @GetMapping(value = "/contents/getCategory", produces = "application/json;charset=UTF-8")
  @ResponseBody
  public List<Map> getCategory(HttpServletRequest request) {
    List<Map> list = service.getCategory();

    return list;
  }

  @GetMapping("/contents/mainlist/{cateno}")
  public String mainlist(@PathVariable("cateno") int cateno, HttpServletRequest request, Model model) {
    // ????????????------------------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if (col.equals("total")) {
      word = "";
    }

    // ???????????????-----------------------
    int nowPage = 1;// ?????? ???????????? ?????????
    if (request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 8;// ??????????????? ????????? ???????????????


    // (MySQL) DB?????? ????????? ??????-----------------
    int sno = (nowPage - 1) * recordPerPage;
    int eno = recordPerPage;

    Map map = new HashMap();
    map.put("col", "cateno");
    map.put("word", cateno);

    int total = service.total(map);

    map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("eno", eno);
    map.put("cateno", cateno);

    List<ContentsDTO> list = service.mainlist(map);

    String paging = Utility.paging2(total, nowPage, recordPerPage, col, word, cateno);

    // request??? Model?????? ?????? ?????????
    request.setAttribute("list", list);
    request.setAttribute("nowPage", nowPage);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
    request.setAttribute("cateno", cateno);

    return "/contents/mainlist";

  }
  
  
  @GetMapping("/contents/detail/{contentsno}")
  public String detail(@PathVariable int contentsno, HttpServletRequest request ,Model model, HttpSession session) {
      
     model.addAttribute("dto",service.detail(contentsno));
     String nowPage = request.getParameter("nowPage");
     String id = (String)session.getAttribute("id");
     
     
     /* ?????? ?????? ?????? */
     int nPage = 1;
     if (request.getParameter("nPage") != null) {
       nPage = Integer.parseInt(request.getParameter("nPage"));
     }
     int recordPerPage = 3;

     // mysql
     int sno = (nPage - 1) * recordPerPage;
     int eno = recordPerPage;

     Map map = new HashMap();
     map.put("sno", sno);
     map.put("eno", eno);
     map.put("nPage", nPage);

     model.addAllAttributes(map);
     request.setAttribute("nowPage", nowPage);
     model.addAttribute("id", id);

     /* ?????? ?????? ??? */
     
      return "/contents/detail";
  }

}