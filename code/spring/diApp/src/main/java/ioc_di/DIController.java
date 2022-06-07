package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DIController {
  @Autowired
  @Qualifier("SamsungTV")
  private TV tv;
  
  @Autowired
  @Qualifier("LgTV")
  private TV tv2;
  
  @RequestMapping("/")
  public @ResponseBody String root() {
    tv.powerOn();
    tv.powerOff();
    tv.volumeUp();
    tv.volumeDown();
    
    tv2.powerOn();
    tv2.powerOff();
    tv2.volumeUp();
    tv2.volumeDown();
    
    return "Annotation DI 사용하기";
  }
}
