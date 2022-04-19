### Day 11(4/19 Tue)

---

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









