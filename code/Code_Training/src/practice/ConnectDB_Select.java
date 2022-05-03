package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB_Select {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "";
    String user_name = "";
    String password = "";
    String driver = "";
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append("");
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user_name, password);
      
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        
      }
      
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        try {
          pstmt.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        try {
          con.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }
    
  }

}
