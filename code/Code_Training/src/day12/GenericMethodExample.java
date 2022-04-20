package day12;

public class GenericMethodExample {
  public static <T> void printArgInfo(T arg) {
    System.out.println(arg.getClass().toString());
    System.out.println(arg.toString());
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Integer i = new Integer(10);
    char c = 'A';
    float f = 3.14f;
    printArgInfo(i);
    printArgInfo(c);
    printArgInfo(f);
  }

}
