package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practiceDAO {
  
  public void readAll() {
    
  }
  
  public void update() {
    
  }
  
  public void delete() {
    
  }


  public practiceDTO readOne(int num) {
    // TODO Auto-generated method stub
    practiceDTO dto = null;
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append("");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new practiceDTO();
        dto.setMemono(rs.getInt("memono"));
        dto.setWname(rs.getString("wname"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setDate(rs.getDate("date"));
      }
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt, rs);
    }
    return dto;
  }
}
