package day01;

public class Main {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = b1 && b2;
		
		System.out.println(b3);
		
		boolean b4 = (10 > 2) ? true : false;
		int a = (10 > 2) ? 10 : 2; // ? 앞의 비교 연산이 true면 10을 결과값으로 갖고 false면 2를 결과값으로 갖는다.
		System.out.println(a);

	}

}
