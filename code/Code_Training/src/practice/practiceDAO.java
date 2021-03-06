package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class practiceDAO {
  
  public List<practiceDTO> readAll() {
    List<practiceDTO> list = new ArrayList<>();
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * from memo ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        practiceDTO dto = new practiceDTO();
        dto.setMemono(rs.getInt("memono"));
        dto.setWname(rs.getString("wname"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setDate(rs.getDate("wdate"));
        
        list.add(dto);
      }
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt, rs);
    }
    return list;
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
    sql.append(" select wname, title, content, wdate ");
    sql.append(" from memo ");
    sql.append(" where memono = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new practiceDTO();
        dto.setMemono(num);
        dto.setWname(rs.getString("wname"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setDate(rs.getDate("wdate"));
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
