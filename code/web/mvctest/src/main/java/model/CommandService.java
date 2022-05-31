package model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class CommandService{ 

    /** 
     * 기본 생성자 
     */ 
    public CommandService() { 
        super(); 
    } 

    public StringBuffer getHello(){ 
        StringBuffer sb = new StringBuffer(); 
        sb.append("<li> 안녕하세요..MVC 입니다.<br>"); 
        sb.append("<li> Template Page<br>"); 
        sb.append("<li> URI Command Pattern<br>"); 
        sb.append("<li> Properties 파일을 이용한 처리입니다.<br>"); 
         
        return sb; 

    } 

    public String getDate(){ 
        Date dt = new Date(); 
        String str = dt.toLocaleString();  
         
        return str; 
    }
    
    public StringBuffer getMyinfo() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("<li> 이름 : 홍길동<br>"); 
        sb.append("<li> 전화번호 : 010-0000-0000<br>"); 
        sb.append("<li> 주소 : 경기도<br>"); 
        sb.append("<li> 이메일 : test@gmail.com<br>"); 
    
    	return sb;
    }

	public List<Map> getTeam() {
		// TODO Auto-generated method stub
		List<Map> list = new ArrayList<Map>();
		Map map = new HashMap();
		map.put("name", "홍길동");
		map.put("skills", "java,jsp,spring");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "가길동");
		map.put("skills", "java,jsp,spring");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "나길동");
		map.put("skills", "java,jsp,spring");
		list.add(map);
		
		return list;
	}

} 