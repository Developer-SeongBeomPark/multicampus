package properties;

import java.util.HashMap;
import java.util.Map;

public class ClassTest2 {

	public static void main(String[] args) {
		String className = args[0]; // Map 저장할때 사용한 키명(클래스명) 
        Map map = new HashMap();    // 객체를 만들어 저장할 장소 
        Class object = null; 
        Action instance = null; 
         
        try{ 
            object = Class.forName("properties.Spring"); // JVM으로 소스 로딩 
            instance = (Action)object.newInstance(); // 객체 생성 
            map.put("Spring", instance);             // 키, 값 
             
            object = Class.forName("properties.Summer"); // JVM으로 소스 로딩 
            instance = (Action)object.newInstance(); // 객체 생성 
            map.put("Summer", instance);             // 키, 값 
             
            object = Class.forName("properties.Fall"); // JVM으로 소스 로딩 
            instance = (Action)object.newInstance(); // 객체 생성 
            map.put("Fall", instance);               // 키, 값 
             
            object = Class.forName("properties.Winter"); // JVM으로 소스 로딩 
            instance = (Action)object.newInstance(); // 객체 생성 
            map.put("Winter", instance);             // 키, 값 

            instance = (Action)map.get(className);// 키와 일치하는 객체 추출 
            instance.execute();  // 객체 실행 
             
        }catch(Exception e){ 
            System.out.println(e); 
        } 
	}

}
