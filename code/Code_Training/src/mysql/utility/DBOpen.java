package mysql.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBOpen {
  private static Connection con;
  public static Connection getConnection() {
    try {
      Class.forName(Constant.DRIVER); //driver에 마우스 커서 대고 F3누르면 해당 변수로 이동. ALT+ ← 누르면 뒤로가기.
      con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWD);
      } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return con;
  }
  
}
