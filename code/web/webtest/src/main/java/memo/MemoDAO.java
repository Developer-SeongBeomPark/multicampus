package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.DBOpen;

public class MemoDAO {
	public List<MemoDTO> list(){
		List<MemoDTO> list = new ArrayList<>();
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  select memono, wname, title, wdate, grpno, indent, ansnum ");
		sql.append("  from memo ");
		
		if(true) {
			sql.append("  where wname like concat('%',?,'%')   -- wname, title, content, title_content, 전체출력 ");
			}
		
		sql.append("  order by grpno desc, ansnum ");
		sql.append(" limit 0, 5  ");
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	public boolean create(MemoDTO dto) {
		boolean flag = false;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into memo (wname, title, content, wdate, grpno, passwd) ");
		sql.append(" values (?,?,?,sysdate(),");
		sql.append(" (select ifnull(max(grpno),0) + 1 from memo m), ?) ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			
		int cnt = pstmt.executeUpdate();
		if(cnt > 0) flag = true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}
		
		
		return flag;
	}
}
