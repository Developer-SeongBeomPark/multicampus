package mysql.address;

import java.util.Iterator;
import java.util.List;

public class AddressTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    AddressDAO dao = new AddressDAO();
    
    //create(dao);
    //list(dao);
    //read(dao);
    //update(dao);
    delete(dao);
  }

  private static void delete(AddressDAO dao) {
    // TODO Auto-generated method stub
    AddressDTO dto = new AddressDTO();
    dto.setAddressnum(5);
    
    if(dao.delete(dto.getAddressnum())) {
      p("delete 완료");
    }
    else {
      p("delete 실패");
    }
  }

  private static void update(AddressDAO dao) {
    // TODO Auto-generated method stub
    AddressDTO dto = dao.read(5);
    dto.setHandphone("010-5555-5555");
    dto.setAddress("터키");
    
    if(dao.update(dto)) {
      p("Update 완료");
    }
    else {
      p("Update 실패");
    }
  }

  private static void read(AddressDAO dao) {
    // TODO Auto-generated method stub
    int addressnum = 6;
    AddressDTO dto = dao.read(addressnum);
    p(dto);
  }

  private static void list(AddressDAO dao) {
    // TODO Auto-generated method stub
    List<AddressDTO> arr = dao.list();
    //System.out.println("레코드 갯수 : " + arr.size());
//    for(int i = 0; i < arr.size(); i++) {
//      AddressDTO dto = arr.get(i);
//      p(dto);
//      p("-----------------");
//    }
    Iterator<AddressDTO> iter = arr.iterator();
    while(iter.hasNext()) {
      AddressDTO dto = iter.next();
      p(dto);
      p("--------------");
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
     AddressDTO dto = new AddressDTO();
     dto.setName("개발자1");
     dto.setHandphone("222-123-1234");
     dto.setAddress("러시아");
     
     /*
      * or
      * AddressDTO dto = new AddressDTO(null, "개발자1", "222-123-1234", "러시아");
      */
     
     boolean flag = dao.create(dto);
     if(flag) p("insert 성공");
     else p("insert 실패");
     
  }
  
  

}
