package day10;

class D1 implements B{
  String str = "";
  public void display(String s) {
    str = s;
    System.out.println("☆☆☆☆☆☆☆☆☆ " + s);
  }
}

class D2 implements B{
  String str = "";
  @Override
  public void display(String s) {
    // TODO Auto-generated method stub
    str = s;
    System.out.println("★★★★★★★★★ " + s); 
  }
  
}


public class IR2 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    B b = new D1();
    b.display("석모도 - 보문사 - 벤뎅이 회무침");
    
    b = new D2();
    b.display("대부도 - 방아머리 - 바지락 칼국수");
  }

}
