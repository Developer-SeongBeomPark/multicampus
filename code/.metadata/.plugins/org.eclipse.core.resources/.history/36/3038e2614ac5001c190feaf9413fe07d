package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String user = "javauser";
    String passwd = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection con = null; //DB 연결 객체
    
    Statement stmt = null; //SQL 전송 객체
    
    ResultSet rs = null; //DQL의 결과를 받는 객체
    
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url,  user, passwd);
      stmt = con.createStatement();
      
      StringBuffer sql = new StringBuffer();
      sql.append(" select * ");
      sql.append(" from address ");
      sql.append(" order by name desc ");
      
      rs = stmt.executeQuery(sql.toString());
      
      while(rs.next()) {
        int addressnum = rs.getInt(1);
        String name = rs.getString(2);
        String phone = rs.getString(3);
        String address = rs.getString(4);
        
        System.out.println("번호: " + addressnum); 
        System.out.println("성명: " + name); 
        System.out.println("전화번호: " + phone); 
        System.out.println("주소: " + address);
        System.out.println("------------------");
      }
      
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        if(stmt != null) stmt.close();
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
