package day05.Pb;

import day05.pa.A3;

public class B3 extends A3 {
	void set() {
		//i = 1; i는 default 멤버(지역변수)이기 때문에 컴파일 오류가 발생한다.
		pro = 2;
		//pri = 3; pri는 private 멤버이기 때문에 접근이 불가하다.
		pub = 4;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B3 b = new B3();
		b.set();
	}

}
