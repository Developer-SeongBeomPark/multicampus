package day13;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      InetAddress ad = InetAddress.getLocalHost();
      System.out.println(ad.getHostName());
      System.out.println(ad.getHostAddress());
      
      ad = InetAddress.getByName("java.sun.com");
      System.out.println(ad);
      
      InetAddress SW[] = InetAddress.getAllByName("naver.com"); 
      for (int i=0; i<SW.length;i++){
        System.out.println(SW[i]); 
      } 
      
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
