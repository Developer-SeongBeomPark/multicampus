package day04;

public class StringTest { 
    
    public void changeString(String src){ 
        src = "JSP"; 
    } 

    public static void main(String[] args) { 
        //System.out.println("ABCD".toLowerCase()); 
        //System.out.println("ABCD".hashCode()); 
         
        String step = "JAVA"; 
        StringTest st = new StringTest(); 
        System.out.println(step); 
        st.changeString(step); //JSP로 변경하기 위해 할당 
        System.out.println(step); 
    } 
} 