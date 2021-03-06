package day03.test;

public class Test2 {

	public static void main(String[] args) {
		double[] arr = {13.5, 86.3, 47.2, 55.5, 62.3, 9.8, 20.5, 0};
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		
		for(double value : arr) {
			if(value > max) {
				max = value;
			}
			if(value < min) {
				min = value;
			}
		}
		
		System.out.println("max값 : "+ max);
		System.out.println("min값 : "+ min);
	}

}
