package day10;

import java.io.FileInputStream;
 
public class Ex10_10 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("c:/users/nambi/OneDrive/바탕 화면/TIL/file/data1.txt");
        int ch;
        byte[] bt = new byte[1024];
 
        int i = 0;
        while ((ch = fis.read()) != -1) {
            bt[i] = (byte) ch;
            i++;
        }
 
        System.out.print(new String(bt));
        fis.close();
    }
}
