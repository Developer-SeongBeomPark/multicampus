package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertPrepDB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String user = "javauser";
    String passwd = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection con = null; //DB 연결 객체
    
    PreparedStatement pstmt = null; //SQL 전송 객체
    
    
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into address values(null, ?, ? , ?) ");
    
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, passwd);
     
      pstmt = con.prepareStatement(sql.toString());
      
      pstmt.setString(1, "개발자3");
      pstmt.setString(2, "555-123-1234");
      pstmt.setString(3, "미국");
      
      int cnt = pstmt.executeUpdate();
      System.out.println("새로운 레코드" + cnt + "개가 추가되었습니다.");
    
      
      
      
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(pstmt != null) pstmt.close();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        if(con != null) con.close();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
