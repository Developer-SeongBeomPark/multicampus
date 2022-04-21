### Day12

---

[Boxing UnBoxing](#boxing-unboxing)

[Generics](#generics)

[가변인자](#가변인자)

[람다식](#람다식)

[스트림 클래스](#스트림-클래스)

##### Boxing UnBoxing

---

- 기본타입과 참조타입 클래스에서 발생합니다. 

- 박싱: 기본타입 -> 참조타입  

- 언박싱: 참조타입 -> 기본타입  

- 주로 기본타입과 랩퍼클래스에서 이루어 집니다. 

  ```
  import java.util.*; 
  public class BoxingUnBoxingMain2 { 
  public static void main(String[] args) { 
  Vector v=new Vector(5,5); 
  v.add(new Integer(3));//java2 
  v.add(1);//boxing //Java5 
  v.add(5);    v.add(4); 
  v.add(8);    v.add(3); 
  Integer gg=3;//boxing 
  int ff=new Integer(4);//unboxing 
  int aa=(Integer)v.get(2);//unboxing  Java5 
  System.out.println("unboxing예  : "+aa); 
  prints(v); 
  } 
  public static void prints(Vector vi){ 
  int num=vi.size(); 
  int sum=0; 
  for(int j=0;j<num;j++){ 
    //sum+=((Integer)vi.get(j)).intValue();//java2 
    sum+=(Integer)vi.get(j);//unboxing //java5 
        }//for 
     System.out.println("합   : "+sum); 
  }//prints 
  } 
  ```

  



##### Generics

---

```
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 

public class Generic2 { 

    public static void main(String[] args) { 
        //선언되는 list는 Integer 클래스 타입만 저장할 수 있습니다. 
        ArrayList<Integer> list = new ArrayList<Integer>(10); 
        list.add(new Integer(10)); 
         
        //ERROR 강제 발생 부분, Integer 타입만 가능,  
        //Design Time에서 발견됩니다. 
        list.add("List Test");  

        Iterator i = list.iterator();  
        Integer su = (Integer)i.next(); 
        System.out.println("su=" + su); 
         
        su = (Integer)i.next(); 
        System.out.println("su=" + su); 
    } 
} 
```



- MultipleTypeParameter Generics

```
class Price<N, V> { 
    private N[] names; 
    private V[] values; 
    private int index; 
    Price(int size) { 
        names = (N[])new Object[size]; 
        values = (V[])new Object[size]; 
        index = 0; 
    } 
    public void insert(N n, V v) { 
        names[index] = n; 
        values[index] = v; 
        ++index; 
    } 
    public void print() { 
        for (int i = 0; i < index; i++) 
        	System.out.println(names[i] + " : " + values[i]); 
    } 
} 
 
public class MultipleTypeParam { 
    public static void main(String[] args) { 
    Price<String, Integer> p1 = new Price<String, Integer>(10); 
    Price<String, Double> p2 = new Price<String, Double>(10); 
    p1.insert("Apple", 1200); 
    p1.insert("Banana", 2000); 
    p1.insert("Grape", 4500); 
    p2.insert("USD", 943.0); 
    p2.insert("JPY", 822.86); 
    p2.insert("EUR", 1273.05); 
    System.out.println("*** Fruit Price ***"); 
    p1.print(); 
    System.out.println("*** Exchange Rate ***"); 
    p2.print(); 
    } 
} 
```



- Generic Interface

```
interface GenericInterface<T> { 
public void setValue(T x); 
public String getValueType(); 
} 

class GenericClass<T> implements GenericInterface<T> { 
    private T value; 
    public void setValue(T x) { 
        value = x; 
    } 
    public String getValueType(){ 
        return value.getClass().toString(); 
        } 
    } 

    public class GenericInterfaceExample { 
        public static void main(String[] args) { 
            GenericClass<Integer> gInteger = new GenericClass<Integer>(); 
            GenericClass<String> gString = new GenericClass<String>(); 
            gInteger.setValue(10); 
            gString.setValue("Text"); 
            System.out.println(gInteger.getValueType()); 
            System.out.println(gString.getValueType()); 
    } 
} 
```







##### 가변인자

---

T ... args : 데이터가 n개인 args 배열을 받겠다.

```
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
```







##### 람다식

---

- 프로그래밍 중 클래스 없이 함수를 구현하고 호출하는 방법이다.
- 자바에서 제공하는 함수형 프로그래밍 방식을 람다식(Lambda expression)이라 한다.
- (매개변수) -> {실행문;} 으로 표현 한다.

ex) 

```
int add(int x, int y) {
     return x + y         =>  (int x, int y) -> {return x+y;}
}
```



###### 문법

(1) 매개변수 자료형과 괄호 생략
\- 람다식에서는 매개변수 자료형을 생략할 수 있다.
\- 매개변수가 하나인경우는 괄호도 생략할 수 있다.
 str -> {System.out.println(str);}
\- 매개변수가 두개인 경우는 괄호를 생략할 수 없다.

(2) 중괄호 생략
\- 중괄호 안의 구현 부분이 한 문장인 경우 중괄호를 생략할 수 있다.
 str -> System.out.println(str);
\- 중괄호 안의 구현부분이 한 문장이라도 return문이 있으면 중괄호를 생략할 없다.

(3) return 생략
\- 중괄호 안의 구현 부분이 return문만 있다면 중괄호와 return을 모두 생략하고
 식만 쓴다.
(x, y) -> x + y;  -> {return x + y;}
str -> str.length(); ->{return str.length();}



##### 스트림 클래스

---

- 배열의 요소를 특정 기준에 따라 정렬(sorting)하거나, 요소 중 특정 값을 제외하고 출력하는(filter)기능처럼 여러 자료의 처리에 대한 기능을 구현해 놓은 클래스가 스트림이다.



(1) 중간 연산 - filter(), map()
\- filter()는 조건을 넣고 그 조건에 맞는 참인 경우만 추출하는 경우에 사용한다.
\- 문자열 배열에서 문자열의 길이가 5이상인 경우만 출력하는 코드이다.

 sList.stream().filter(s -> s.length() >5).forEach(s -> System.out.println(s));

  스트림생성    중간 연산       최종 연산

\- map()은 클래스가 가진 자료 중 이름만 출력하는 경우에 사용한다.
\- 고객 클래스에서 고객이름만 가져와서 출력한다.
\- map()은 요소들을 순회하면서 다른 형식으로 변환하기도 한다.

 customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));

​    스트림생성      중간 연산        최종 연산


(2) 최종 연산 - forEach(), count(), sum(), reduce()
\- 최종 연산은 스트림의 자료를 소모하면서 연산을 수행하기 때문에 최종 연산이 수행
 되고 나면 해당 스트림은 더 이상 사용할 수 없다.
\- 최종 연산은 결과를 만드는 데 주로 사용한다.



```
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
 
public class ArrayListStreamTest {
 
    public static void main(String[] args) {
 
        List<String> sList = new ArrayList<String>();
        sList.add("Tomas");
        sList.add("Edward");
        sList.add("Jack");
        
        Stream<String> stream = sList.stream();
        stream.forEach(s->System.out.print(s + " "));
        System.out.println();
        
        sList.stream().sorted().forEach(s->System.out.print(s+ " ")); //스트림 새로 생성하여 정렬하여 출력한다.
        
    }
}
```



###### 특징

(1) 자료의 대상과 관계없이 동일한 연산을 수행한다.
(2) 한 번 생성하고 사용한 스트림은 재사용할 수 없다.
(3) 스트림의 연산은 기존 자료를 변경하지 않는다.
(4) 스트림의 연산은 중간 연산과 최종 연산이 있다.
 \- 스트림 중간 연산은 여러 개가 적용될 수 있고, 최종 연산은 맨 마지막에 한 번 적용된다.
 \- 자료를 정렬하거나 검색하는 중간 연산이 호출되어도 최종 연산이 호출되지 않으면 정렬이나 검색한 결과를 가져올 수 없다. 이를 지연 연산(lazy evaluation) 이라 한다.



```
//TravelCustomer.java
public class TravelCustomer {
 
    private String name;   //이름
    private int age;       //나이
    private int price;     //가격
    
    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public int getPrice() {
        return price;
    }
    
    public String toString() {
        return "name: " + name + "age: " + age + "price: " + price; 
    }
}
```



```
//TravelTest.java
import java.util.ArrayList;
import java.util.List;
 
public class TravelTest {
 
    public static void main(String[] args) {
        
        TravelCustomer customerLee = new TravelCustomer("이순신", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
        TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);
        
        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerHong);
        
        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
        
        int total = customerList.stream().mapToInt(c->c.getPrice()).sum();
        System.out.println("총 여행 비용은 :" + total + "입니다");
        
        System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
        customerList.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
    }
}
```

