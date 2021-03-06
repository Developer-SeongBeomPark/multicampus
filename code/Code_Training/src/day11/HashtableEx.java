package day11;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableEx {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Hashtable ht = new Hashtable();
    ht.put("21", "홍길동");
    ht.put("54", "황기태");
    ht.put("76", "이소룡");
    ht.put("123", "해리슨포드");
    
    System.out.println(ht.size());
    
    Enumeration e = ht.keys();
    while(e.hasMoreElements()) {
      String key = (String)e.nextElement();
      String value = (String)ht.get(key);
      System.out.println(key + " = " + value);
    }
  }

}
