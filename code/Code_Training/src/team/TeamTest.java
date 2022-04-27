package team;

import java.util.Iterator;
import java.util.List;

public class TeamTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TeamDAO dao = new TeamDAO();
    
    //read(dao);
    //readOne(dao);
    //create(dao);
    //update(dao);
    delete(dao);
  }
  
  private static void delete(TeamDAO dao) {
    // TODO Auto-generated method stub
    int num = 1;
    int value = dao.delete(num);
    if(value == 1) p("delete 성공");
    else p("delete 실패");
  }

  // 010-7777-7777', email = 'user7777@gmail.com', skills = 'java,jsp', address = '서울시 강남구'
  

  private static void update(TeamDAO dao) {
    // TODO Auto-generated method stub
    TeamDTO dto = dao.readOne(1);
    dto.setPhone("010-7777-7777");
    dto.setEmail("user7777@gmail.com");
    dto.setSkills("java,jsp");
    dto.setAddress("서울시 강남구");
    
    int value = dao.update(dto);
    if(value == 1) p("update 성공");
    else p("update 실패");
  }

  private static void create(TeamDAO dao) {
    // TODO Auto-generated method stub
    TeamDTO dto = new TeamDTO();
    dto.setName("박길동");
    dto.setPhone("010-1223-1312");
    dto.setEmail("user43211@gmail.com");
    dto.setSkills("none");
    dto.setAddress("서울시 중랑구");
    
    if(dao.create(dto))
      p("insert 성공");
    else p("insert 실패");
  }

  private static void readOne(TeamDAO dao) {
    // TODO Auto-generated method stub
    int no = 3;
    TeamDTO dto = dao.readOne(no);
    p(dto);
  }

  private static void read(TeamDAO dao) {
    // TODO Auto-generated method stub
    List<TeamDTO> list =  dao.read();
    
    Iterator<TeamDTO> iter = list.iterator();
    while(iter.hasNext()) {
      TeamDTO dto = iter.next();
      p(dto);
      p("-------------");
    }
  }
  
  private static void p(String string) {
    System.out.println(string);
  }
  
  private static void p(TeamDTO dto) {
    p("name = " + dto.getName());
    p("phone = " + dto.getPhone());
    p("emali = " + dto.getEmail());
    p("skills = " + dto.getSkills());
    p("address = " + dto.getAddress());
  }

}
