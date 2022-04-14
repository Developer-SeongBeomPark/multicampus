### DAY 9(4/14 Thu)

---

[Abstract Class](#abstract-class)

[Final](#final)

[StringBuffer](#stringbuffer)

[WrapperClass와 AutoBoxing, UnBoxing](#wrapperclass와-autoboxing,-unboxing)

[자동호출 toString 메소드](#자동호출-tostring-메소드)

##### Abstract Class

---

메소드의 기능이 구현되지 않고 원형만 선언되어 있는 클래스

```
abstract class DObject {
        public DObject next;

       public DObject() { next = null;}
       abstract public void draw() ;
}
```

 

추상클래스를 사용하는 이유 ? : 





##### Final

---

1. final 클래스
   - final 클래스는 상속될 수 없다.
2. final 메소드
   - 자식 클래스가 오버라이딩 할 수 없다
3. public static final 자료형 변수명
   - 고정된 같은 값이 반복해서 쓰이는 경우 사용한다





##### StringBuffer

---

- 문자열을 가공할 때 유용하게 사용하는 클래스

String을 이용하여 문자열을 가공하면 해시코드가 바뀌기 때문에 메모리를 불필요하게 더 사용하게 된다. 하지만 StringBuffer를 사용하면 같은 해시코드의 메모리를 수정하기 때문에 더 유용하다.



##### WrapperClass와 AutoBoxing, UnBoxing

---

- WrapperClass

  기본 자료형이 존재하지만 따로 클래스로 만든 클래스(ex. Integer, Long etc...)

- AutoBoxing, UnBoxing

  ```
  public class WrapperClassEx {
  
    public static void main(String[] args) {
      // TODO Auto-generated method stub
      Integer i = new Integer(10);
      char c = '4';
      Double d = new Double(3.141592);
      System.out.println(Character.toLowerCase(c));
      
      if(Character.isDigit(c)) {
        System.out.println(Character.getNumericValue(c));
      }
      
      System.out.println(Integer.parseInt("-123")); // 문자열 “-123”을 정수로 변환하여 출력
      System.out.println(Integer.parseInt("10", 16)); // 16진수로 표현된 문자열 “10”을 정수로 변환하여 출력
      System.out.println(Integer.toBinaryString(28)); // 28의 2진수 표현을 나타내는 문자열 출력
      System.out.println(Integer.bitCount(28)); // 28의 2진수에서 1의 개수출력
      System.out.println(Integer.toHexString(28)); // 28의 16진수 표현을 나타내는 문자열 출력
      System.out.println(i.doubleValue()); // i값(=10)을 double로 변환하여 출력
      System.out.println(d.toString()); // d값(=3.1234566)을 문자열로 변환하여 출력
      System.out.println(Double.parseDouble("44.13e-6")); // 문자열 “44.13e-16"을 double로 변환하여 출력
      
    }
  ```

  



##### 자동호출 toString 메소드

---

```
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
```

