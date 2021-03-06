package day09;

class Pay{
  private String name;       //성명, 문자열 저장
  private int bonbong;    //본봉, 숫자

  Pay(){}
  
  Pay(String name, int bonbong){
    this.name = name;
    this.bonbong = bonbong;
  }
  
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
     return name;
  }
 
  public void setBonbong(int bonbong){
     this.bonbong = bonbong;
  }
 
  public int getBonbong(){
     return bonbong;
  }
 
  public int taxCalc(){
     return (int)(bonbong * 0.045 + 0.5);
  }
  public int silsuCalc(){
    return bonbong - taxCalc();
  }   
  public void printPay(){
  System.out.println("--------------------");
      System.out.println("---12월 급여 내역---");
      System.out.println("--------------------");
      System.out.println("성명: " + name);
      System.out.println("본봉: " + bonbong);
      System.out.println("세금: " + taxCalc());
      System.out.println("실수령액: " + silsuCalc());
  }
}

class Extra extends Pay{
  private int year, child;
  
  public Extra() {}
  public Extra(String name, int bonbong, int year, int child) {
    super(name,bonbong);
    this.year = year;
    this.child = child;
    
    
  }
  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }
  public int getChild() {
    return child;
  }
  public void setChild(int child) {
    this.child = child;
  }
  
  public int calcExtra() {
    int pay = 0;
        
    if (year == 1) { 
      pay = pay + 200000; 
    }else if(year == 2) { 
      pay = pay + 400000; 
    }else if(year == 3) { 
      pay = pay + 600000; 
    }else if(year == 4) { 
      pay = pay + 800000; 
    }else{ 
      pay = pay + 1500000; 
    } 
   
  //자녀수당을 계산합니다. 
    if ( year >=1){ 
      if (child > 1){ 
          pay = pay + (child * 200000); 
      } 
    } 
  return pay;
  }
  @Override
  public int silsuCalc() {
    return getBonbong() + calcExtra() - taxCalc();
  }
  @Override
  public void printPay() {
    System.out.println("--------------------");
    System.out.println("---12월 급여 내역---");
    System.out.println("--------------------");
    System.out.println("성명: " + getName());
    System.out.println("본봉: " + getBonbong());
    System.out.println("세금: " + taxCalc());
    System.out.println("수당: " + calcExtra());
    System.out.println("실수령액: " + silsuCalc());
  }
  
  
}

public class PayCalc {

  public static void main(String[] args) {
    Pay p1 = new Pay();  
    Pay p2 = new Pay(); 
    Pay p3 = new Pay();
        
    p1.setBonbong(2000000);
    p1.setName("왕눈이");
    p1.printPay();
     
    p2.setBonbong(2500000);
    p2.setName("아로미");
    p2.printPay();
     
    p3.setBonbong(1500000);
    p3.setName("투투");
    p3.printPay();
    
    
    Extra p4 = new Extra();
    p4.setName("박성범");
    p4.setBonbong(50000000);
    p4.setYear(6);
    p4.setChild(1);
    p4.printPay();
    
    Extra p5 = new Extra("김계란", 10000, 5, 2);
    p5.printPay();
    
  }

}
