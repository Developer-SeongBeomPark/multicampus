package practice;

import java.util.Iterator;
import java.util.List;

public class practiceTest {
  public static void main(String[] args) {
    practiceDAO dao = new practiceDAO();
    
    //readOne(dao);
    readAll(dao);
  }

  private static void readAll(practiceDAO dao) {
    // TODO Auto-generated method stub
    List<practiceDTO> list = dao.readAll();
    
    Iterator<practiceDTO> iter = list.iterator();
    while(iter.hasNext()) {
      practiceDTO dto = iter.next();
      p(dto);
      p("----------------");
    }
  }

  private static void readOne(practiceDAO dao) {
    // TODO Auto-generated method stub
    int num = 3;
    practiceDTO dto = dao.readOne(num);
    p(dto);
  }

  private static void p(practiceDTO dto) {
    // TODO Auto-generated method stub
    p("번호 : " + dto.getMemono());
    p("이름 : " + dto.getWname());
    p("제목 : " + dto.getTitle());
    p("내용 : " + dto.getContent());
    p("날짜 : " + dto.getDate());
  }

  private static void p(String string) {
    // TODO Auto-generated method stub
    System.out.println(string);
  }
    
  
}
