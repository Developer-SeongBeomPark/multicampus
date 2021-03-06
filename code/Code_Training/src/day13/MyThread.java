package day13;

public class MyThread extends Thread {
  private int num;
  private String name;
  
  public MyThread() {}
  public MyThread(String name, int num) {
    this.num = num;
    this.name = name;
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    for(int i = 0; i < num; i++) {
      System.out.println(name + " : " + i);
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MyThread t1 = new MyThread("first", 1000);
    MyThread t2 = new MyThread("second", 1000);
    MyThread t3 = new MyThread("third", 1000);
    
    t1.start();
    t2.start();
    t3.start();
  }

}
