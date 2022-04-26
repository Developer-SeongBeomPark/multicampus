package address;

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
