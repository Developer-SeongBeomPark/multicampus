package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
  public boolean create(BookDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.open();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into book values(?, ?, ?, ? ,? ,? , sysdate()) ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      
      pstmt.setInt(1, dto.getIsbn());
      pstmt.setString(2, dto.getTitle());
      pstmt.setString(3, dto.getAuthor());
      pstmt.setString(4, dto.getPublisher());
      pstmt.setInt(5, dto.getPrice());
      pstmt.setString(6, dto.getDes());
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt);
    }
    
    return flag;
  }
  
  public static boolean update(int price, int isbn) {
    boolean flag = false;
    
    Connection con = DBOpen.open();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" update book ");
    sql.append(" set price = ? ");
    sql.append(" where isbn = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, price);
      pstmt.setInt(2, isbn);
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt);
    }
   
    return flag;
  }
  
  
  public static boolean delete(int isbn) {
    boolean flag = false;
    
    Connection con = DBOpen.open();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" delete ");
    sql.append(" from book ");
    sql.append(" where isbn = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, isbn);
      
      int cnt = pstmt.executeUpdate();
      if(cnt > 0) flag = true;
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt);
    }
    
    return flag;
  }
  
  public static BookDTO read(int isbn) {
    BookDTO dto = null;
    
    Connection con = DBOpen.open();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append(" from book ");
    sql.append(" where isbn = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, isbn);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new BookDTO();
        dto.setIsbn(isbn);
        dto.setTitle(rs.getString("title"));
        dto.setAuthor(rs.getString("author"));
        dto.setPublisher(rs.getString("publisher"));
        dto.setPrice(rs.getInt("price"));
        dto.setDes(rs.getString("des"));
        dto.setDate(rs.getDate("publish_date"));
      }
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(con, pstmt, rs);
    }
    
    return dto;
  }
  
  public static List<BookDTO> list(){
    List<BookDTO> list = new ArrayList<>();
    
    Connection con = DBOpen.open();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * from book ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        BookDTO dto = new BookDTO();
        dto.setIsbn(rs.getInt("isbn"));
        dto.setTitle(rs.getString("title"));
        dto.setAuthor(rs.getString("author"));
        dto.setPublisher(rs.getString("publisher"));
        dto.setPrice(rs.getInt("price"));
        dto.setDes(rs.getString("des"));
        dto.setDate(rs.getDate("publish_date"));
        
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
}
