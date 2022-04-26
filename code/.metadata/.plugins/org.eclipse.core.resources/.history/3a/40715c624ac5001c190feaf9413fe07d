package day13;

class Car{
  protected String carName;
  Car(){}
  Car(String carName){
    this.carName = carName;
  }
  }

class Truck extends Car implements Runnable{
  Truck(){}
  Truck(String carName){
    super(carName);
  }
  @Override
  public void run() {
    // TODO Auto-generated method stub
    for (int i = 0; i < 3; i++) {
      try {
          Thread.sleep(10);
          System.out.println(carName + "~~ 달립니다.");

      } catch (Exception e) {
      }
    }
  
  }
}


public class Ex14_09 {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Thread truck1 = new Thread(new Truck("$트럭1"));
    truck1.start();

    Thread truck2 = new Thread(new Truck("@트럭1"));
    truck2.start();

    Thread truck3 = new Thread(new Truck("*트럭1"));
    truck3.start();
  }

}

