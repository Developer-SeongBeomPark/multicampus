package day12;

class SimpleGeneric<T>{
  private T[] values;
  private int index;
  
  SimpleGeneric(){}
  SimpleGeneric(int len){
    values = (T[])new Object[len];
    index = 0;
  }
  
  public void add(T ... args) {
    for(T e : args) {
      values[index++] = e;
    }
  }
  
  public void print() {
    for(T e : values) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}



public class GenericClassExample {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SimpleGeneric<Integer> gInteger = new SimpleGeneric<Integer>(10);
    SimpleGeneric<Double> gDouble = new SimpleGeneric<Double>(10);
    
    gInteger.add(1,2);
    gInteger.add(1,2,3,4,5,6,7);
    gInteger.add(0);
    gInteger.print();
    
    gDouble.add(10., 20., 30.);
    gDouble.print();
  }

}
