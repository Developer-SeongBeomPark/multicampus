package day02.test;

public class EX01 {

	public static void main(String[] args) {
		int year = 5;         //근무(경력) 년수 
        int child = 0;        //자녀수 
        int pay = 1500000;    //초봉 기본급 
         
        switch(year){ 
        	case 0 :
        		System.out.println("신입사원입니다.");  
        		break;
        	case 1 :
        		pay = pay + 200000; 
        		System.out.println("경력 1년 입니다."); 
        		break;
        	case 2 :
        		pay = pay + 400000;
        		break;
        	case 3 :
        		pay = pay + 600000; 
        	case 4 :
        		pay = pay + 800000; 
        	case 5 :
        		pay = pay + 1500000; 
        } 
         
        //자녀수당을 계산합니다. 
        if ( year >=1){ 
            if (child > 1){ 
                pay = pay + (child * 200000); 
            } 
        } 
         
        System.out.println("기본급: " + pay); 
        System.out.println("연  봉: " + (pay * 13)); 
        System.out.println("월급여: " + ((pay * 13)/12)); 

	}

}
