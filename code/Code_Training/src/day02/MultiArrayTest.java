package day02;

public class MultiArrayTest {

	public static void main(String[] args) {
		//1차원 배열 
        int[ ] arr1 = new int[3]; 
         
        //2차원 배열 
        int[ ][ ] arr2; 
        arr2 = new int[2][3]; 
         
        //1차원 배열은 컬럼의수를 리턴합니다. 
        System.out.println("arr1배열의 열의 수 : " + arr1.length + "\n"); 
         
        //2차원 배열은 행의수를 리턴합니다. 
        System.out.println("arr2배열의 행의 수 : " + arr2.length + "\n"); 
         
        //각행의 열의수를 리턴합니다. 
        System.out.println("arr2배열의 1행의 열의 수 : " + arr2[0].length + "\n"); 
        System.out.println("arr2배열의 2행의 열의 수 : " + arr2[1].length + "\n"); 
 
	}

}
