package day09;

abstract class Sum{
  public abstract String str();
  public abstract String toString();
}

class Sum_s1 extends Sum{

  
  
  @Override
  public String str() {
    // TODO Auto-generated method stub
    return "gg";
  }
  
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "class Sum_s1 extends Sum";
  }
}

class Sum_s2 extends Sum{

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "class Sum_s2 extends Sum";
  }
  
  @Override
  public String str() {
    // TODO Auto-generated method stub
    return "gh";
  }
  
}

public class SumMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Sum_s1 s1 = new Sum_s1();
    System.out.println(s1);
    
    Sum_s2 s2 = new Sum_s2();
    System.out.println(s2);
  }

}
