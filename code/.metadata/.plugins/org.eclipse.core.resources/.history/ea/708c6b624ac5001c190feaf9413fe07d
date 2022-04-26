package day03.test;

import java.util.Calendar;
import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine(), address = sc.nextLine(), birth = sc.nextLine();
		int age = find_age(birth);
		
		sc.close();
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("나이 : " + age);
	}
	
	public static int find_age(String year) {
		String str = year.substring(0,2);
		year = "19" + str;
		int value = Integer.parseInt(year);
		
		Calendar calendar = Calendar.getInstance(); 
		int currYear= calendar.get(Calendar.YEAR); 
		
		return currYear - value;
	}

}
