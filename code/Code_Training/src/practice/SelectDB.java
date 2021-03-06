package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String user_name = "javauser";
    String password = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * from address ");
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user_name, password);
      
      pstmt = con.prepareStatement(sql.toString());
      
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        System.out.println(rs.getInt("addressnum"));
        System.out.println(rs.getString("name"));
        System.out.println(rs.getString("handphone"));
        System.out.println(rs.getString("address"));
        System.out.println("----------------");
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
