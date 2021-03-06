package day13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("***** 개발자_1 서버 프로그램 작동됨 *****");
    ServerSocket server = null;
    try {
      server = new ServerSocket(2022);
      while(true) {
        System.out.println("클라이언트 접속을 대기중입니다.");
        Socket client = server.accept();
        
        //클라이언트 ip
        InetAddress ia = client.getInetAddress();
        String ip = ia.getHostAddress();
        int port = client.getLocalPort();
        System.out.println("클라이언트 접속:" + " Local Port: "+ port + " IP: " + ip); 
        //한글을 출력할 수 있습니다. 
        
        //Client로 출력할 객체 생성 
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); 
      //버퍼에 문자열을 기록함 
        writer.write("개발자_1 서버에 접속 하신것을 환영 합니다."); 
     
        //실제로 Client로 전송함   
        writer.flush(); 
        
        client.close();
      }
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        server.close();
        System.out.println("서버 작동을 종료합니다");
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    //아무키나 누를 때까지 대기합니다. 
    try{ 
        InputStream is = System.in; 
        is.read(); 
    }catch(Exception e){ 
         
    } 
    System.out.println("서버 프로그램 실행을 종료합니다."); 
  }

}
