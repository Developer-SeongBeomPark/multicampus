package exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    BookDTO dto_1 = new BookDTO(21424,"Java Basic","김하나","Jaen.kr", 15000 ,"Java 기본 문법");
    BookDTO dto_2 = new BookDTO(33455,"JDBC Pro","김철수","Jaen.kr", 23000 ,"");
    BookDTO dto_3 = new BookDTO(55355,"Servlet/JSP","박자바","Jaen.kr", 41000 ,"Model2 기반");
    BookDTO dto_4 = new BookDTO(35332,"Android App","홍길동","Jaen.kr", 25000 ,"Lightweight Framework");
    BookDTO dto_5 = new BookDTO(35355,"OOAD 분석,설계","소나무","Jaen.kr", 30000 ,"");
    
    System.out.println("************************* 도서 목록 **************************");
    System.out.println(dto_1.toString());
    System.out.println(dto_2.toString());
    System.out.println(dto_3.toString());
    System.out.println(dto_4.toString());
    System.out.println(dto_5.toString());
  }

}
