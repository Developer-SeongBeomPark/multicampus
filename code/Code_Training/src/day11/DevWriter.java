package day11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DevWriter {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String fileName = "C:/aistudy/java/dev.txt";
    
    try {
      FileWriter fw = new FileWriter(fileName, false);
      PrintWriter pw = new PrintWriter(fw);
      
      pw.println("왕눈이,90,95,60,75");
      pw.println("아로미,100,90,65,90");
      pw.println("가길동,90,100,80,85");
      pw.println("나길동,65,80,85,95");
      pw.println("홍길동,90,95,75,100");
      pw.flush();
      pw.close();
      fw.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
