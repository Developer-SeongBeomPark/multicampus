package day12;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    TravelCustomer Lee = new TravelCustomer("이순신",40,100);
    TravelCustomer Kim = new TravelCustomer("김유신", 20, 100);
    TravelCustomer Hong = new TravelCustomer("홍길동", 13, 50);
    
    List<TravelCustomer> list = new ArrayList<>();
    
    list.add(Lee);
    list.add(Kim);
    list.add(Hong);
    
    System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
    list.stream().map(c->c.getName()).forEach(s->System.out.println(s));
    
    int total = list.stream().mapToInt(c->c.getPrice()).sum();
    System.out.println("총 여행 비용 : " + total);
    
    System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
    list.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).sorted().forEach(t->System.out.println(t));
    
    
    
  }

}
