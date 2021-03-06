package day09;

class Rects {
  int width;
  int height;
  
  public Rects(int width, int height) {
    this.width = width; 
    this.height = height;
  }
  
  public boolean equals(Rects p) {
    if (width*height == p.width*p.height) // 사각형 면적 비교
      return true;
  else 
    return false;
    }
  }

public class EqualsEx {
  public static void main(String[] args) {
    Rects a = new Rects(2,3);
    Rects b = new Rects(3,2);
    Rects c = new Rects(3,4);
    if(a.equals(b))  System.out.println("a is equal to b");
    if(a.equals(c))  System.out.println("a is equal to c");
    if(b.equals(c))  System.out.println("b is equal to c");
  }
}
