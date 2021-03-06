package day11;

import java.util.Vector;

public class VectorEx {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector v = new Vector();
    v.add("Hello");
    v.add(4);
    v.add(3.14);
    System.out.println(v.size());
    System.out.println(v.capacity());
    
    for(int i=0; i<v.size(); i++) {
      Object obj = v.get(i); // 해당 인덱스의 요소 얻어오기
      if(obj instanceof String) { // String 객체의 경우
        String str = (String)obj;
        System.out.println(str);
      }
      else if(obj instanceof Integer) { // Integer 객체의 경우
        Integer x = (Integer)obj;
        int n = x.intValue();
        System.out.println(n);
      }
      else if(obj instanceof Double) { // Double 객체의 경우
        Double y = (Double)obj;
        double d = y.doubleValue();
        System.out.println(d);
        }
      }
  }

}
