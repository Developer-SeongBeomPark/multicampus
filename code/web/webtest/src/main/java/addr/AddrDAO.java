package addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utility.DBClose;
import utility.DBOpen;

public class AddrDAO {
	
	public boolean delete(int addressnum) {
		boolean flag = false;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  DELETE FROM address WHERE addressnum = ?  ");
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, addressnum);
			
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
	
	public boolean update(AddrDTO dto) {
		boolean flag = false;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE address   ");
		sql.append(" SET handphone=? , address=?, zipcode = ?, address2 = ?,  name = ? ");
		sql.append(" WHERE addressnum = ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getHandphone());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getZipcode());
			pstmt.setString(4, dto.getAddress2());
			pstmt.setString(5, dto.getName());
			pstmt.setInt(6, dto.getAddressnum());
			
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
	
	public AddrDTO read(int addressnum) {
	    AddrDTO dto = null;
	    Connection con = DBOpen.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	 
	    StringBuffer sql = new StringBuffer();
	    sql.append(" SELECT name, handphone, zipcode, address, address2 ");
	    sql.append(" FROM address   ");
	    sql.append(" WHERE addressnum = ?  ");
	 
	    try {
	      pstmt = con.prepareStatement(sql.toString());
	      pstmt.setInt(1, addressnum);
	 
	      rs = pstmt.executeQuery();
	 
	      if (rs.next()) {
	        dto = new AddrDTO();
	        dto.setName(rs.getString("name"));
			dto.setHandphone(rs.getString("handphone"));
			dto.setZipcode(rs.getString("zipcode"));
			dto.setAddress(rs.getString("address"));
			dto.setAddress2(rs.getString("address2"));
	      }
	 
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBClose.close(rs, pstmt, con);
	    }
	 
	    return dto;
	  }
	
	public int total(Map map) {
		int total = 0;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String col = (String)map.get("col"); //검색칼럼: name, handphone, address
		String word = (String)map.get("word");
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) ");
		sql.append(" from address ");
		
		if(word.trim().length() > 0) {
			sql.append(" where " + col + " like concat('%',?,'%') ");
		}
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			
			if(word.trim().length() > 0) {
				pstmt.setString(1,word);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}
		
		
		
		return total;
	}
	
	public List<AddrDTO> list(Map map){
		List<AddrDTO> list = new ArrayList<>();
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String col = (String)map.get("col"); //검색칼럼: name, handphone, address
		String word = (String)map.get("word"); //사용자가 입력한 단어
		int sno = (int)map.get("sno"); // 레코드 시작위치
		int eno = (int)map.get("eno"); // 가져올 건수
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT addressnum, name, handphone, zipcode, address, address2  ");
		sql.append(" FROM address ");
		
		
		if(word.trim().length() > 0) {
			sql.append(" where " + col + " like concat('%',?,'%') ");
		}
		sql.append(" order by addressnum desc ");
		sql.append(" limit ?,? ");
		
		int i = 0;
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			
			if(word.trim().length() > 0) {
				pstmt.setString(++i,word);
			}
			
			pstmt.setInt(++i, sno);
			pstmt.setInt(++i, eno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddrDTO dto = new AddrDTO();
				dto.setAddressnum(rs.getInt("addressnum"));
				dto.setName(rs.getString("name"));
				dto.setHandphone(rs.getString("handphone"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
		 
		        list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean create(AddrDTO dto) {
		boolean flag = false;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO address(name, handphone, address, zipcode, address2)   ");
		sql.append(" VALUES(?, ?, ?, ?, ?)  ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHandphone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getZipcode());
			pstmt.setString(5, dto.getAddress2());
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}
		
		
		return flag;
	}
}
