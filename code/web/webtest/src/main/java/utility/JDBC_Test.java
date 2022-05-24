package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) cnt FROM information_schema.tables WHERE table_schema = 'webtest'");
	
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("현재 webtest db에 생성된 테이블 갯수 :" + rs.getInt("cnt"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}
		
	}

}
