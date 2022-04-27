package mysql.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.utility.DBClose;
import mysql.utility.DBOpen;

public class AddressDAO {
  
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

}
