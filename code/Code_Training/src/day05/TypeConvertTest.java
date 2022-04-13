package day05;

class TypeConvert{ 
    String url = "http://www.kma.go.kr"; 

    public void setUrl(String url){ this.url = url; } 
    public String getUrl(){ return this.url; }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TypeConvert에서 오버라이딩된 메소드 입니다";
	} 
    
} 

public class TypeConvertTest { 

    public static void main(String[] args) { 
        TypeConvert tc = new TypeConvert(); 
        Object obj = tc; //Object 클래스의 메소드만 호출가능 
        //System.out.println(obj.getUrl()); 
        System.out.println(tc.getUrl()); 
         
        System.out.println(obj.hashCode()); 
        System.out.println(tc.hashCode()); 
         
        TypeConvert tc2 = (TypeConvert)obj; 
        System.out.println("tc2: " + tc2.getUrl()); 
        System.out.println("tc2: " + tc2.hashCode()); 
        
        System.out.println(obj.toString());
    } 

} 