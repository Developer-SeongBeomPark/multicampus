package day03;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		String s = "Hello Wold! 3+3.0=6";
		Scanner sc = new Scanner(s);
		
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		sc.close();
	}

}
