package day10;

import java.io.FileInputStream;

public class Ex10_09 {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    FileInputStream fis = new FileInputStream("c:/users/nambi/OneDrive/바탕 화면/TIL/file/data1.txt");
    int ch;

    while ((ch = fis.read()) != -1)
        System.out.print((char) ch);

    fis.close();
    
    //출력 결과 : File Read Sampleìëë¤
    //1바이트씩 파일 정보를 불러오지만 한글은 2바이트라서 깨짐.
  }

}
