package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClose {
  public static void close() {};
  
  public static void close(Connection con) {
    try {
      if(con != null) con.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
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
  
  public static void close(PreparedStatement pstmt, Connection con) {
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
