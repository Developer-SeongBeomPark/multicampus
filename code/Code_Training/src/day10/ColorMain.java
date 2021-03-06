package day10;

interface Green{
  String greenColor();
}

class GreenImpl implements Green{
  public String greenColor() {
    return "초록색입니다.";
  }
}

interface Red{
  String redColor();
}

class RedImpl implements Red{
  public String redColor() {
    return "빨간색입니다.";
  }
}

class ColorImpl implements Green, Red{
  public String greenColor() {
    return "초록";
  }
  public String redColor() {
    return "빨강";
  }
}

public class ColorMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Green gi = new GreenImpl();
    System.out.println(gi.greenColor());
    
    Red ri = new RedImpl();
    System.out.println(ri.redColor());
  
    ColorImpl ci = new ColorImpl();
    System.out.println(ci.greenColor());
    System.out.println(ci.redColor());  
  }

}
