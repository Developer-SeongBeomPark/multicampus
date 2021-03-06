package day09;

abstract class Calculator{
  public abstract int add(int a, int b);
  public abstract int subtract(int a, int b);
  public abstract double average(int[] a);
  
}

class GoodCalc extends Calculator{

  @Override
  public int add(int a, int b) {
    // TODO Auto-generated method stub
    return a+b;
  }

  @Override
  public int subtract(int a, int b) {
    // TODO Auto-generated method stub
    return a-b;
  }

  @Override
  public double average(int[] a) {
    // TODO Auto-generated method stub
    int sum = 0;
    for(int value : a) {
      sum += value;
    }
    return (double)sum / a.length;
  }
  
}

public class CalcMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int a = 10, b = 4;
    int[] avg_arr = {1,2,3,4,5,6,7,8,9,10};
    
    GoodCalc calc = new GoodCalc();
    System.out.println(calc.add(a, b));
    System.out.println(calc.subtract(a, b));
    System.out.println(calc.average(avg_arr));
  }

}
