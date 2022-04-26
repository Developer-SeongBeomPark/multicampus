package day11;

import java.util.Vector;

public class VectorAddEx {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector v = new Vector(); // 디폴트 용량 10의 벡터 생성
    v.add("Hello");
    v.add(new Integer(4));
    v.add(new Double(3.14));
    v.add(new Integer(5));
     
    int sum = 0;
    for(int i=0; i<v.size(); i++) {
    Object obj = v.get(i);
    if(obj instanceof Integer) { // Integer 객체의 경우에만 덧셈 수행
    int x = (int)obj; 
    sum += x;
    }
    }
    System.out.println("모든 정수의 합은 : " + sum);
  }

}
