package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDBOne {

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
      con = DriverManager.getConnection(url, user, passwd);
      stmt = con.createStatement();
      
      StringBuffer sql = new StringBuffer();
      sql.append(" select * ");
      sql.append(" from address ");
      sql.append(" where addressnum = 4 ");
      
      rs = stmt.executeQuery(sql.toString()); // ResultSet은 String 타입을 받음.
      if(rs.next()) { // rs.next()를 사용하는 이유 : 행열 한칸 내리는 작업. 한칸 내렸을 때 데이터가 있으면 true를 반환. 없으면 false를 반환.
        int addressnum = rs.getInt(1); // sql 테이블은 인덱스 1부터 시작
        String name = rs.getString(2);
        String handphone = rs.getString("handphone");// rs.getString(3) 이랑 똑같음.
        String address = rs.getString(4);
        
        System.out.println("번호: " + addressnum); 
        System.out.println("성명: " + name); 
        System.out.println("전화번호: " + handphone); 
        System.out.println("주소: " + address); 
        
      }
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(con != null) con.close();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        if(stmt != null) stmt.close();
      } catch (SQLException e) {
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
