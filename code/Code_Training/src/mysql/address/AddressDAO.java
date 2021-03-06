package mysql.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.DTD;

import mysql.utility.DBClose;
import mysql.utility.DBOpen;

public class AddressDAO {
  
  /*
   * db에서 한건의 레코드를 가져온다(DQL)
   * @param addressnum pk값
   * @return 한 건의 레코드
   */
  public AddressDTO read(int addressnum) {
    AddressDTO dto = null;
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append(" from address ");
    sql.append(" where addressnum = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, addressnum);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new AddressDTO();
        dto.setAddressnum(rs.getInt("addressnum"));
        dto.setName(rs.getString("name"));
        dto.setHandphone(rs.getString("handphone"));
        dto.setAddress(rs.getString("address"));
        
        /*
         * or
         * dto = new AddressDTO(rs.getInt("addressnum"), rs.getString("name"), rs.getString("handphone"), rs.getString("address"));
         */
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    
    return dto;
  }
  
  
  
  /*
   * db에서 여러건의 레코드를 가져온다.
   * @return 여러건의 레코드
   */
  
  public List<AddressDTO> list(){
    List<AddressDTO> data_list = new ArrayList<>();
    Connection con = DBOpen.getConnection();
    
    PreparedStatement pstmt = null;
    
    ResultSet rs = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append(" from address ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        AddressDTO dto = new AddressDTO();
        dto.setAddressnum(rs.getInt("addressnum"));
        dto.setName(rs.getString("name"));
        dto.setHandphone(rs.getString("handphone"));
        dto.setAddress(rs.getString("address"));
        
        data_list.add(dto);
        
      }   
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    
    return data_list;
  }
  
  
  /*
   * db에 한건의 레코드 저장(DML)
   * @param dto 저장할 데이터
   * @return 성공/실패
   */
  
  public boolean create(AddressDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into address values(null, ? , ?, ?) ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getHandphone());
      pstmt.setString(3, dto.getAddress());
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
  
  
  /**
   * db 한 건의 레코드 수정(DML)
   * @param dto 수정할 데이터
   * @return 성공/실패
   */
  public boolean update(AddressDTO dto) {
    boolean flag = false;
    
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" update address ");
    sql.append(" set handphone = ?, address = ? ");
    sql.append(" where addressnum = ? ");
    
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getHandphone());
      pstmt.setString(2, dto.getAddress());
      pstmt.setInt(3, dto.getAddressnum());
      
      int cnt = pstmt.executeUpdate();
      if (cnt > 0) flag = true;
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    
    
    
    return flag;
    
  }
  
  public boolean delete(int addressnum) {
    boolean flag = false;
    Connection con = DBOpen.getConnection();
    PreparedStatement pstmt = null;
    
    StringBuffer sql = new StringBuffer();
    sql.append(" delete from address ");
    sql.append(" where addressnum = ? ");
    
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

}
