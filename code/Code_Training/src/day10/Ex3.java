package day10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3 {

  public static void prn(ResultSet r) throws SQLException {
    while(r.next()) {
      
    }
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url = "";
    String user = "";
    String password = "";
    String driver = "";
    
    Connection con = null;
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      Statement st = con.createStatement();
      ResultSet r = st.executeQuery("");
      prn(r);
      
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      try {
        con.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
