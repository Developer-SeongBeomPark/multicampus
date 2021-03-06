package day12;

public class TestStringConcat {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    // 일반적인 방법
    String s1 = "Hello";
    String s2 = "World";
    StringConCatImpl concat1 = new StringConCatImpl();
    concat1.makeString(s1, s2);
    
    // 람다식으로 구현
    StringConcat concat2 = (s,v)-> System.out.println(s + "," + v);
    concat2.makeString(s1, s2);
    
    
  }

}
