package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.utility.DBClose;
import mysql.utility.DBOpen;

public class TeamDAO {
  
  public List<TeamDTO> read() {
    List<TeamDTO> list = new ArrayList<>();
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select no, name, phone, email, skills, address ");
    sql.append(" 	from team ");
    sql.append("  order by name desc ");
    
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        TeamDTO dto = new TeamDTO(rs.getInt("no"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("skills"), rs.getString("address"));
        list.add(dto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    
    return list;
  }
  
  public TeamDTO readOne(int no) {
    TeamDTO dto = null;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append(" from team ");
    sql.append(" where no = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, no);
      
      rs = pstmt.executeQuery();
      if(rs.next()) {
        dto = new TeamDTO(rs.getInt("no"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("skills"), rs.getString("address"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    
    return dto;
  }
  
  public boolean create(TeamDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into team(name, phone, email, skills, address) values (?, ?, ?, ?, ?) ");
    
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getPhone());
      pstmt.setString(3, dto.getEmail());
      pstmt.setString(4, dto.getSkills());
      pstmt.setString(5, dto.getAddress());
      
      
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
  
  public int update(TeamDTO dto) {
    int cnt = 0;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" update team ");
    sql.append(" set phone = ?, email = ?, skills = ?, address = ? ");
    sql.append(" where no = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getPhone());
      pstmt.setString(2, dto.getEmail());
      pstmt.setString(3, dto.getSkills());
      pstmt.setString(4, dto.getAddress());
      pstmt.setInt(5, dto.getNo());
      
      cnt = pstmt.executeUpdate();
      if(cnt > 0) cnt = 1;
      else cnt = 0;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    return cnt;
  }
  
  public int delete(int no) {
    int cnt = 0;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" delete from team  ");
    sql.append(" 	where no = ?  ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, no);
      
      cnt = pstmt.executeUpdate();
      if(cnt > 0) cnt = 1;
      else cnt = 0;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    return cnt;
  }
}
