package day12;

class Outter2{
  
  Runnable getRunnable(int i){

      int num = 100;
      
      return new Runnable() {
              
      @Override
      public void run() {
          //num = 200;   //에러 남
          //i = 10;      //에러 남
          System.out.println(i);
          System.out.println(num);
          }
      };//Runnable을 구현한 익명의 내부 클래스
  }//메소드
  
  Runnable runner = new Runnable() {
      
      @Override
      public void run() {
          System.out.println("Runnable 이 구현된 익명 클래스 변수");
          
      }
  };//익명의 인스턴스 내부 클래스 구현
}

public class AnonymousInnerTest {

  public static void main(String[] args) {
      Outter2 out = new Outter2();
  
      Runnable runnerble = out.getRunnable(10);
      runnerble.run();
      
      out.runner.run();
  }
}