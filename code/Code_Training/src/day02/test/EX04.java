package day02.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EX04 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		
		x = x / 10;
		
		switch(x) {
			case 9:
				System.out.println("등급은 A입니다.");
				break;
			case 8:
				System.out.println("등급은 B입니다.");
				break;
			case 7:
				System.out.println("등급은 C입니다.");
				break;
			case 6:
				System.out.println("등급은 D입니다.");
				break;
			default:
				System.out.println("노력하세요");
		}
		
		
	}

}
