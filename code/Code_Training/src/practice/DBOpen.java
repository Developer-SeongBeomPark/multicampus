package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBOpen {
  private static Connection con = null;
  
  public static Connection getConnection() {
    try {
      Class.forName(Constant.driver);
      con = DriverManager.getConnection(Constant.url, Constant.user, Constant.password);
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return con;
  }
}
