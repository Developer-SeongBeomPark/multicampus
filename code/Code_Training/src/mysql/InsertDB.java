package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String user = "javauser";
    String passwd = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection con = null; //DB 연결 객체
    
    Statement stmt = null; //SQL 전송 객체
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url,  user, passwd);
      
      stmt = con.createStatement();
      
      StringBuffer sql = new StringBuffer();
      sql.append(" insert into address values(null, '개발자1', '000-123-1234', '대한민국') ");
      
      int cnt = stmt.executeUpdate(sql.toString()); // commit 갯수 찍히는거 처럼 레코드 개수가 찍힘.
      
      System.out.println("새로운 레코드" + cnt + "개가 추가되었습니다.");
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(stmt != null) stmt.close();
        if(con != null) con.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
    
    
  }

}
