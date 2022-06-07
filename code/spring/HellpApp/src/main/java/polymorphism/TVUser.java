package polymorphism;

public class TVUser {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TV tv = new SamsungTV();
    tv.powerOn();
    tv.powerOff();
    tv.volumeUp();
    tv.volumeDown();
    
    tv = new LgTV();
    tv.powerOn();
    tv.powerOff();
    tv.volumeUp();
    tv.volumeDown();
  }

}
