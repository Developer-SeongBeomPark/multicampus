package exam;

import java.util.Iterator;
import java.util.List;

public class BookTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
//    BookDTO dto_1 = new BookDTO(21424,"Java Basic","김하나","Jaen.kr", 15000 ,"Java 기본 문법");
//    BookDTO dto_2 = new BookDTO(33455,"JDBC Pro","김철수","Jaen.kr", 23000 ,"");
//    BookDTO dto_3 = new BookDTO(55355,"Servlet/JSP","박자바","Jaen.kr", 41000 ,"Model2 기반");
//    BookDTO dto_4 = new BookDTO(35332,"Android App","홍길동","Jaen.kr", 25000 ,"Lightweight Framework");
//    BookDTO dto_5 = new BookDTO(35355,"OOAD 분석,설계","소나무","Jaen.kr", 30000 ,"");
//    
//    System.out.println("************************* 도서 목록 **************************");
//    System.out.println(dto_1.toString());
//    System.out.println(dto_2.toString());
//    System.out.println(dto_3.toString());
//    System.out.println(dto_4.toString());
//    System.out.println(dto_5.toString());
    
    
      BookDAO dao = new BookDAO();
      
      //create(dao);
      //update(dao);
      //delete(dao);
      //read(dao);
      list(dao);
  }

  private static void list(BookDAO dao) {
    // TODO Auto-generated method stub
    List<BookDTO> list = dao.list();
    
    Iterator<BookDTO> iter = list.iterator();
    
    while(iter.hasNext()) {
      BookDTO dto = iter.next();
      p(dto);
      if(iter.hasNext()) p("------------------------------");
    }
  }

  private static void read(BookDAO dao) {
    // TODO Auto-generated method stub
    int isbn = 21424;
    BookDTO dto = dao.read(isbn);
    p(dto);
  }

  private static void delete(BookDAO dao) {
    // TODO Auto-generated method stub
    int isbn = 12345;
    if(dao.delete(isbn)) {
      p("delete 성공");
    }else {
      p("delete 실패");
    }
  }

  private static void update(BookDAO dao) {
    // TODO Auto-generated method stub
    if(dao.update(15000, 12345)) {
      p("update 성공");
    }else {
      p("update 실패");
    }
  }

  private static void create(BookDAO dao) {
    // TODO Auto-generated method stub
    BookDTO dto = new BookDTO(12345,"insert_Ex","김길동","gildo ng.kr", 34000 ,null);
    
    if(dao.create(dto)) {
      p("create 성공");
    }else {
      p("create 실패");
    }
  }

  private static void p(String string) {
    // TODO Auto-generated method stub
    System.out.println(string);
  }
  
  private static void p(BookDTO dto) {
    p("Isbn\t\t: " + dto.getIsbn());
    p("Title\t\t: " + dto.getTitle());
    p("Author\t\t: " + dto.getAuthor());
    p("Publisher\t: " + dto.getPublisher());
    p("Price\t\t: " + dto.getPrice());
    p("Desc\t\t: " + dto.getDes());
    p("Date\t\t: " + dto.getDate());
  }
}
