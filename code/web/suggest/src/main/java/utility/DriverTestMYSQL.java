package utility;

import java.sql.Connection;

public class DriverTestMYSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
	    
	    try {
	      con = DBOpen.getConnection();
	      System.out.println("데이터베이스 접속이 성공했습니다.");    
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      
	      DBClose.close(con);
	      
	    }
	}

}
