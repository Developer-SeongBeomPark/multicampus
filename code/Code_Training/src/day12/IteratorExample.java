package day12;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList a = new ArrayList();
    a.add("Hello");
    a.add(3);
    a.add(3.14);
    a.add(2, 3.4);
    
    Iterator i = a.iterator();
    
    while(i.hasNext()) {
      Object obj = i.next();
      if(obj instanceof String) {
        String str = (String)obj;
        System.out.println(str);
      }
      else if(obj instanceof Integer) {
        Integer x = (Integer)obj;
        System.out.println(x);
      }
      else if(obj instanceof Double) {
        Double d = (Double)obj;
        System.out.println(d);
      }
    }
  }

}
