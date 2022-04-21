### Day 11(4/19 Tue)

---

[직렬화](#직렬화)

[Collections Framework](#collections-framework)



##### 직렬화

---

* 인스턴스가 파일에 저장될때 저장을 위해 거치는과정을가리켜 직렬화(serialization)이라하고, 그 반대의 과정을 가리켜 역직렬화(deserialization) 이라한다 

* 직렬화의 대상이 되는 인스턴스의 클래스는 java.io.Seiralizable 인터페이스를 구현해야한다.

  ```
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
  import java.io.Serializable;
   
  class Circle implements Serializable {
    int xPos;
    int yPos;
    double rad;
   
    Circle(int x, int y, double r) {
      xPos = x;
      yPos = y;
      rad = r;
    }
   
    public void showCircleInfo() {
      System.out.printf("[%d, %d] \n", xPos, yPos);
      System.out.println("rad: " + rad);
    }
  }
   
  public class CircleTest {
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
   
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
   
      out.writeObject(new Circle(1, 1, 2.4));
      out.writeObject(new Circle(2, 2, 4.8));
      out.writeObject(new String("String implements Serializable"));
      out.close();
   
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
   
      Circle c1 = (Circle) in.readObject();
      Circle c2 = (Circle) in.readObject();
      String str = (String) in.readObject();
      in.close();
   
      c1.showCircleInfo();
      c2.showCircleInfo();
      System.out.println(str);
   
    }
   
  }
  ```

- transient : 직렬화의 대상에서 제외됨.

##### Collections Framework

---

1. Set

   * 순서가 없고, 중복 안됨
   * HashSet, TreeSet

2. List

   * 순서가 있고 중복이 가능하다.
   * ArrayList, LinkedList, Vector

   ```
   import java.util.ArrayList;
   import java.util.Iterator;
   import java.util.List;
    
   public class ListTest {
    
     public static void main(String[] args) {
       ArrayList list = new ArrayList();
       list.add("lee");
       list.clear();
       list.add("cho");
       list.add("kim");
       list.add("chung");
       list.add("min");
       list.add("chung");
       
       System.out.println(list);
       System.out.println("ArrayList 사이즈:"+list.size());
       System.out.println(list.contains("chung"));
       
       list.remove("kim");
       System.out.println(list);
       list.remove(3);
       System.out.println(list);
       
       System.out.println("ArrayList 사이즈:"+list.size());
       System.out.println("min 위치값: "+list.indexOf("min"));
    
       System.out.println("for문으로 출력");
       print(list);//업캐스팅
       List sublist = list.subList(0, 2);
       System.out.println("-------------------");
       print(sublist);//캐스팅 없다.
       
       System.out.println("Iterator를 이용해서 출력");
       print(list.iterator());
       
       System.out.println("배열을 이용해서 출력");
       print(list.toArray());
       
       
     }
    
     private static void print(Object[] array) {
       for(int i=0; i<array.length; i++) {
         System.out.println(array[i]);
       }
       
     }
    
     private static void print(Iterator iterator) {
        while(iterator.hasNext()) {
          System.out.println(iterator.next());
        }
       
     }
    
     private static void print(List list) {
      for(int i=0; i<list.size(); i++) {
        System.out.println(list.get(i));
      }
       
     }
    
   }
   ```

   

3. Vector

4. Map

   * key와 value가 한쌍
   * HashMap, Hashtable
   * 중복된 키 값을 허용하지 않는다. 만약 사용하게되면 기존의 값이 삭제된다

5.  Properties

   * String을 key와 value로 갖는 Map의 일종

   