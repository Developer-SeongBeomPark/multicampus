package day10;

interface MobilePhone{
  boolean sendCall();
  boolean receiveCall();
  boolean sendSMS();
  boolean receiveSMS();
}

interface MP3{
  void play();
  void stop();
}

class PDA{
  public int calculate(int x, int y) {
    return x + y;
  }
}


public class SmartPhone extends PDA implements MobilePhone, MP3{
  
  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("음악 재생");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    System.out.println("재생 중지");
  }

  @Override
  public boolean sendCall() {
    // TODO Auto-generated method stub
    System.out.println("전화 걸기");
    return true;
  }

  @Override
  public boolean receiveCall() {
    // TODO Auto-generated method stub
    System.out.println("전화 받기");
    return true;
  }

  @Override
  public boolean sendSMS() {
    // TODO Auto-generated method stub
    System.out.println("SMS 보내기");
    return true;
  }

  @Override
  public boolean receiveSMS() {
    // TODO Auto-generated method stub
    System.out.println("SMS 받기");
    return true;
  }
  
  public void scheduler() {
    System.out.println("일정관리");
    }
  
  public void applicationManager() {
    System.out.println("어플리케이션 설치/삭제");
    }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SmartPhone p = new SmartPhone();
    p.sendCall();
    p.play();
    p.calculate(3, 5);
    p.scheduler();
  }

}
