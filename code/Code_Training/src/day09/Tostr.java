package day09;

public class Tostr {
  int a;
  String b;
  
  public Tostr(int a, String b)
  {
   this.a = a;
   this.b = b;  
  }
  public String toString()//오버라이딩
  {
   String str= "a = "+ a + "\nb = " + b;//한 문장이 만들어짐
   return str;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Tostr ts = new Tostr(10,"aaaa");
    //ts를 출력하고 싶다
      
    System.out.println("a = " + ts.a);
    System.out.println("b = " + ts.b);
    
    System.out.println(ts);
  }

}
