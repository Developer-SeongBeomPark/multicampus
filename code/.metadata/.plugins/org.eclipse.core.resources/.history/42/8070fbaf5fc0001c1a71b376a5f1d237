package day12;

interface GenericInterface<T>{
  void setValue(T x);
  String getValueType();
}

class GenericClass<T> implements GenericInterface<T> {
  private T value;
  public void setValue(T x) {
    value = x;
  }
  
  public String getValueType() {
    return value.getClass().toString();
  }
}


public class GenericInterfaceExample {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GenericClass<Integer> gInteger = new GenericClass<Integer>();
    gInteger.setValue(10);
    System.out.println(gInteger.getValueType());
    
    GenericClass<String> gString = new GenericClass<String>();
    gString.setValue("Text");
    System.out.println(gString.getValueType());
  }

}
