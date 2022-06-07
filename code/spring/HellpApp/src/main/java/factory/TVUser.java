package factory;

public class TVUser {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TV tv = BeanFacto if(beanName.equals("samsung")) {
      return new SamsungTV();
    }else if(beanName.equals("lg")) {
      return new LgTV();
    }
    return null;ry.getBean(args[0]);
    tv.powerOn();
    tv.powerOff();
    tv.volumeUp();
    tv.volumeDown();
    
 
  }

}
