package day12;

import day12.OutClass.InClass;

class OutClass {
  
  private int num = 10;
  private static int sNum = 20;
  private InClass inClass;
  
  public OutClass(){
      inClass = new InClass(); // 내부 클래스 생성
  }
  
  class InClass{
      
      int inNum = 100;
      //static int sInNum = 200;  //에러 남
      
      void inTest(){
          System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
          System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
      }
      
      //static void sTest(){  //에러 남
          
      //}
      }
  
    static class InStaticClass{
      int inNum = 100;
      static int sInNum = 200;
      void inTest() {
        System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
        System.out.println("InStaticClass SinNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");
        System.out.println(sNum + " : 외부클래스의 스태틱변수 사용");
      }
      
  }
  
  public void usingClass(){
      inClass.inTest(); //내부 클래스 변수를 사용하여 메서드 호출하기
  }

}


public class InnerTest2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
  //외부 클래스 생성하지 않고 바로 정적 내부 클래스 생성
    OutClass.InStaticClass sInClass = new OutClass.InStaticClass();  
    System.out.println("정적 내부 클래스 일반 메서드 호출");
    sInClass.inTest();
    System.out.println("=======================================");
    
    System.out.println("정적 내부 클래스의 스태틱 메소드 호출");
    OutClass.InStaticClass.sTest();
  }

}
