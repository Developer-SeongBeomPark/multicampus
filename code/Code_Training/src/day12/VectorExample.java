package day12;

import java.util.Collections;
import java.util.Vector;

public class VectorExample {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<Integer> v = new Vector<Integer>(3);
    System.out.println(v.capacity());
    
    v.add(2);
    v.add(123);
    v.add(41);
    v.add(1);
    
    System.out.println(v.capacity());
    Collections.sort(v);
    
    for(int i = 0; i < v.size(); i++) {
      Integer n = v.get(i);
      System.out.println(n);
    }
  }

}
