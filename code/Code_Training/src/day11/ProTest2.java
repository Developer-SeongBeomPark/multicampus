package day11;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

public class ProTest2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String myinfoPath = "myinfo.properties";
    FileInputStream fis = null;
    
    Properties pro = new Properties();
    
    try {
      fis = new FileInputStream(myinfoPath);
      
      pro.load(fis);
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    Iterator iter = pro.keySet().iterator();
    while(iter.hasNext()) {
      String key = (String)iter.next();
      String value = (String)pro.getProperty(key);
      System.out.println(key + " = " + value);
    }
  
    
    System.out.println(pro.getProperty("name"));
    System.out.println(pro.getProperty("phone"));
    System.out.println(pro.getProperty("address"));
  
  }

}
