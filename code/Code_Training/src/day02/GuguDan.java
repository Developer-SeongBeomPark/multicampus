package day02;

public class GuguDan {

	public static void main(String[] args) {
		//1, 4, 7   
        for (int i = 9; i >= 1; i -= 3) { 
            System.out.println("   " + i + "단\t\t   " + (i-1) + "단\t\t   " + (i-2) + "단"); 
      
            System.out.println("------------------------------------------"); 
            //1,2,3,4,5,6,7,8,9 
            for (int j = 9; j >= 1; j--) { 
                System.out.print(i + " * " + j + " = " + i*j + "\t"); 
                 
                System.out.print((i-1) + " * " + j + " = " + (i-1)*j + "\t"); 
                  
                System.out.print((i-2) + " * " + j + " = " + (i-2)*j); 
                    
                //줄 바꾸기 목적으로 사용됩니다. 
                System.out.println(""); 
            } 
            System.out.println(""); 
        } 
	}

}
