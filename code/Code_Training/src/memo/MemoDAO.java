package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.utility.DBClose;
import mysql.utility.DBOpen;

public class MemoDAO {
  
  public boolean create(MemoDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into memo(wname, title, content, passwd, wdate) values (?, ?, ?, ?, sysdate())  ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getWname());
      pstmt.setString(2, dto.getTitle());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getPasswd());
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    return flag;
  }
  
  
  
  
  
  
  public MemoDTO read(int memono) {
    MemoDTO dto = null;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append(" 	from memo ");
    sql.append("     where memono = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, memono);
      
      rs = pstmt.executeQuery();
      if(rs.next()) {
        dto = new MemoDTO();
        dto.setMemono(rs.getInt("memono"));
        dto.setWname(rs.getString("wname"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setWdate(rs.getDate("wdate"));
      }
      
      return dto;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    
    
    
    return dto;
  }

  
  
  
  
  
  
  public boolean update(MemoDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" update memo ");
    sql.append(" set title = ?, content = ? ");
    sql.append(" where memono = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setInt(3, dto.getMemono());
      
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    return flag;
  }
  
  
  
  
  
  
  public boolean delete(int memono) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" delete ");
    sql.append(" from memo ");
    sql.append(" where memono = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, memono);
      
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    return flag;
  }
  
  
  
  
  
  
  
  public List<MemoDTO> list(){
    List<MemoDTO> list = new ArrayList<>();
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append("  select wname, title, content, wdate ");
    sql.append("  from memo ");
    sql.append("  order by wdate desc ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        MemoDTO dto = new MemoDTO();
        dto.setWname(rs.getString("wname"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setWdate(rs.getDate("wdate"));
        
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
}
