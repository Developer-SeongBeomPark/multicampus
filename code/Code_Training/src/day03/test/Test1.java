package day03.test;

public class Test1 {

	public static void main(String[] args) {
		int[] score_arr = {30,40,50,60,70};
		
		double avg = 0;
		
		for(int value : score_arr) {
			avg += value;
		}
		
		avg /= score_arr.length;
		
		System.out.println(avg);

	}

}
