package memo;

import java.util.Iterator;
import java.util.List;

public class MemoTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MemoDAO dao = new MemoDAO();
    
    //create(dao);
    //read(dao);
    //update(dao);
    //delete(dao);
    list(dao);
  }

  
  
  
  private static void list(MemoDAO dao) {
    // TODO Auto-generated method stub
    List<MemoDTO> list = dao.list();
    
    Iterator<MemoDTO> iter = list.iterator();
    while(iter.hasNext()) {
      p(iter.next());
      p("--------------");
    }
  }




  private static void delete(MemoDAO dao) {
    // TODO Auto-generated method stub
    int num = 1;
    
    boolean flag = dao.delete(num);
    if(flag) p("delete 성공");
    else p("delete 실패");
  }




  private static void read(MemoDAO dao) {
    // TODO Auto-generated method stub
    int num = 2;
    
    MemoDTO dto = dao.read(num);
    
    p(dto);
    
  }




  private static void update(MemoDAO dao) {
    // TODO Auto-generated method stub
    MemoDTO dto = dao.read(1);
    dto.setWname("이길동");
    dto.setTitle("mysql 수업");
    dto.setContent("DAO,DTO");
    
    boolean flag = dao.update(dto);
    if(flag) p("update 성공");
    else p("update 실패");
  }

  
  
  
  private static void create(MemoDAO dao) {
    // TODO Auto-generated method stub
    MemoDTO dto = new MemoDTO();
    dto.setWname("이길동");
    dto.setTitle("mysql 수업");
    dto.setContent("DAO,DTO");
    dto.setPasswd("1234");
    
    boolean flag = dao.create(dto);
    if(flag) p("create 성공");
    else p("create 실패");
  }

  private static void p(String string) {
    // TODO Auto-generated method stub
    System.out.println(string);
  }
  
  private static void p(MemoDTO dto) {
    // TODO Auto-generated method stub
    p("작성자 이름 : " + dto.getWname());
    p("제목 : " + dto.getTitle());
    p("내용 : " + dto.getContent());
    p("날짜 : " + dto.getWdate());
  }
  
}
