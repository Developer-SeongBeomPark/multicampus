package com.study.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.member.MemberDTO;
import com.study.member.MemberService;

@Controller
public class MailController {

  @Autowired
  @Qualifier("com.study.member.MemberServiceImpl")
  private MemberService service;
  
  @Autowired
  private JavaMailSender mailSender;
  
  @GetMapping("/mailid/{mname}/{email}")
  @ResponseBody
  public String getId(@PathVariable("mname") String mname, @PathVariable("email") String email) {
    String text = "";
    Map map = new HashMap();
    map.put("mname", mname);
    map.put("email", email);
    int cnt = service.validationCheck(map);
    if (cnt == 1) {
      MemberDTO dto = service.readbyemail(email);
      String id = dto.getId();
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(email);
      message.setSubject("아이디 찾기 메일입니다.");
      message.setText("회원님의 아이디는 " + id + " 입니다." );
      message.setFrom("tjdqja1570@gmail.com");
      message.setReplyTo("tjdqja1570@gmail.com");
      System.out.println("message"+message);
      mailSender.send(message);
      
      text = "이메일을 확인하세요.";
      
      
    } else {
      text = "아이디가 존재하지 않습니다.";
    }
    return text;
  }
}
