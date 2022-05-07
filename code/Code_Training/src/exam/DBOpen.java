package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOpen {
  static Connection con = null;
  public static Connection open() {
    try {
      Class.forName(Constant.DRIVER);
      con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
    } catch (SQLException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return con;
  }
}
