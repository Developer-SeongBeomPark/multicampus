package day03.test;

public class Test3 {

	public static void main(String[] args) {
		double[] arr = {13.5, -86.3, 47.2, -55.5, 62.3, -9.8, 20.5, 0};
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(arr[i]);
			System.out.print(arr[i] + " ");
		}
	}

}
