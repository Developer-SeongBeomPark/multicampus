package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class FileDirDemo1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    System.out.print("디렉토리를 입력해 주세요: "); 
     
    String directory=""; 
    try { 
        directory = in.readLine(); //키보드로부터 입력, Lock 
    } catch (Exception e) { 
      System.out.println("Error: " + e.toString()); 
    }     
     
    //File, Directory 관련 처리 
    File f1 = new File(directory); 

    //디렉토리인지 검사 
    if (f1.isDirectory()) { 
      System.out.println("검색 디렉토리 " + directory); 
      System.out.println("============================="); 
      String s[] = f1.list(); //디렉토리안에 있는 파일/디렉토리 목록 

      for (int i=0; i < s.length; i++) { 
          //디렉토리와 파일 조합 
          File f = new File(directory + "/" + s[i]); 
       
          if (f.isDirectory()) { //디렉토리이면 
              System.out.println(s[i] + " : 디렉토리"); 
          } else { //파일이면 
              System.out.println(s[i] + " : 파일"); 
          } 
      } 
  } else { 
    System.out.println("지정한 " + directory + " 는 디렉토리가 아님"); 
  } 
  }

}
