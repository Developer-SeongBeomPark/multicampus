package day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DevProcess {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String fileName = "C:/aistudy/java/dev.txt";
    String fileNameOutput = "C:/aistudy/java/dev_output.txt";
  
    
    try {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      
      FileWriter fw = new FileWriter(fileNameOutput, false);
      PrintWriter pw = new PrintWriter(fw);
      
      String line = ""; 
      
      pw.println("        2019년 신입사원 평가 점수 "); 
      pw.println(""); 
      pw.println("평가일: " + new Date().toLocaleString()); 
      pw.println("--------------------------------------------"); 
      pw.println("성  명  JAVA  JSP  SPRING  PROJECT  TOT  AVG"); 
      pw.println("--------------------------------------------"); 
      
      while(true){ 
        line = br.readLine(); // 한라인씩 읽어옴. 
         
        if (line == null){ 
          break; 
        } 
        String[] str = line.split(","); 
        String name = str[0]; 
        int java = Integer.parseInt(str[1]); 
        int jsp = Integer.parseInt(str[2]); 
        int spring = Integer.parseInt(str[3]); 
        int project = Integer.parseInt(str[4]); 
         
        int tot = java + jsp + spring + project; 
        int avg = tot / 4;  
        pw.println(name + "   " + java + "   " + jsp + "    " + spring + "     " + project + "      "+ tot + "   " + avg); 
        pw.println("--------------------------------------------"); 
      }
      
      pw.println("         SOLDESK IT Academy 2019        "); 
      
      br.close(); 
      fr.close(); 
       
      pw.flush(); 
      pw.close(); 
      fw.close(); 
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
