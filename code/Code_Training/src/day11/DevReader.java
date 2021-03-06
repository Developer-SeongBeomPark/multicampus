package day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DevReader {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String fileName = "C:/aistudy/java/dev_output.txt";
    
    try {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      
      String str = ""; 
      String line = ""; 

      while (true) {  
        line = br.readLine();    // 한 라인씩 읽음 
         
        if (line == null){       // 파일을 마지막까지 읽은 경우 
          break;                 // while문 종료   
        } 
        System.out.println(line); // 문자열 추가, \n: 라인 변경 
      } 

      br.close();                // 메모리 해제 
      fr.close(); 
      
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
