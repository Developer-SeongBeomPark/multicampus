package practice;

import mysql.address.AddressDTO;

public class practiceTest {
  public static void main(String[] args) {
    practiceDAO dao = new practiceDAO();
    
    readOne(dao);
  }

  private static void readOne(practiceDAO dao) {
    // TODO Auto-generated method stub
    int num = 6;
    practiceDTO dto = dao.readOne(num);
    p(dto);
  }

  private static void p(practiceDTO dto) {
    // TODO Auto-generated method stub
    p("반호 : " + dto.getMemono());
    p("이름 : " + dto.getWname());
    //p("전화번호 : " + dto.getHandphone());
    //p("주소 : " + dto.getAddress());
  }

  private static void p(String string) {
    // TODO Auto-generated method stub
    System.out.println(string);
  }
    
  
}
