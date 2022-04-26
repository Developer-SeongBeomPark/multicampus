package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import mysql.utility.DBClose;
import mysql.utility.DBOpen;

public class DriverTestMySQL {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Connection con = null;
    try {
      con = DBOpen.getConnection();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con);
    }
  }

}
