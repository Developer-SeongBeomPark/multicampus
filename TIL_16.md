### DAY 16(4/26 Thu)

---

[Java와 DB 연동](#java와-db-연동)

[실습](#실습)



##### Java와 DB 연동

---

###### DAO

CRUD에 해당하는 내용들을 다 저장한다.

MYSQL과 소통하는 역할을 한다.



###### DTO

데이터를 저장하고 있는 바구니 역할.



##### 실습

---



1. DBOpen.java

   ```
   import java.sql.Connection;
   import java.sql.DriverManager;
   
   
   public class DBOpen {
     private static Connection con;
     public static Connection getConnection() {
       try {
         Class.forName(Constant.DRIVER); //driver에 마우스 커서 대고 F3누르면 해당 변수로 이동. ALT+ ← 누르면 뒤로가기.
         con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWD);
         } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       return con;
     }
     
   }
   ```

2. Constant.java

   ```
   public class Constant {
   
     public static final String URL = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
     public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
     public static final String USER = "javauser";
     public static final String PASSWD = "1234";
   
   }
   ```

3. DBClose.java

   ```
   import java.sql.Connection;
   import java.sql.PreparedStatement;
   import java.sql.ResultSet;
   
   public class DBClose {
     public static void close() {};
     
     public static void close(Connection con) {
       try {
         if(con != null) con.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
     }
     
     public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
       try {
         if(rs != null) rs.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       
       try {
         if(pstmt != null) pstmt.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       
       try {
         if(con != null) con.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
     }
     
     public static void close(PreparedStatement pstmt, Connection con) {
       try {
         if(pstmt != null) pstmt.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       
       try {
         if(con != null) con.close();
       } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
     }
   }
   ```

4. AddressDTO.java

   ```
   public class AddressDTO {
     private int addressnum;    
     private String name;       
     private String handphone;  
     private String address;
     
     
     
     public AddressDTO() {
       
     }
   
     public AddressDTO(int addressnum, String name, String handphone, String address) {
       super();
       this.addressnum = addressnum;
       this.name = name;
       this.handphone = handphone;
       this.address = address;
     }
   
     @Override
     public String toString() {
       return "AddressDTO [addressnum=" + addressnum + ", name=" + name + ", handphone=" + handphone + ", address="
           + address + "]";
     }
   
     public int getAddressnum() {
       return addressnum;
     }
   
     public void setAddressnum(int addressnum) {
       this.addressnum = addressnum;
     }
   
     public String getName() {
       return name;
     }
   
     public void setName(String name) {
       this.name = name;
     }
   
     public String getHandphone() {
       return handphone;
     }
   
     public void setHandphone(String handphone) {
       this.handphone = handphone;
     }
   
     public String getAddress() {
       return address;
     }
   
     public void setAddress(String address) {
       this.address = address;
     }
     
     
     
   
   }
   ```

5. AddressDAO.java

   ```
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
   ```

6. AddressTest.java

   ```
   import java.util.ArrayList;
   import java.util.List;
   
   public class AddressTest {
   
     public static void main(String[] args) {
       // TODO Auto-generated method stub
       AddressDAO dao = new AddressDAO();
       
       create(dao);
       list(dao);
     }
   
     private static void list(AddressDAO dao) {
       // TODO Auto-generated method stub
       List<AddressDTO> arr = dao.list();
       //System.out.println("레코드 갯수 : " + arr.size());
       for(int i = 0; i < arr.size(); i++) {
         AddressDTO dto = arr.get(i);
         p(dto);
         p("-----------------");
       }
     }
   
     private static void p(AddressDTO dto) {
       // TODO Auto-generated method stub
       p("반호 : " + dto.getAddressnum());
       p("이름 : " + dto.getName());
       p("전화번호 : " + dto.getHandphone());
       p("주소 : " + dto.getAddress());
     }
   
     private static void p(String string) {
       // TODO Auto-generated method stub
       System.out.println(string);
     }
   
     private static void create(AddressDAO dao) {
       // TODO Auto-generated method stub
       
     }
   
   }
   ```

   



