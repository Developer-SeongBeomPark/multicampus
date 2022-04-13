package day05;

class A1{
	public A1() {}
	
	public A1(int x) {
		System.out.println("생성자 A");
	}
}

class B1 extends A1{
	public B1() {
		System.out.println("생성자 B");
	}
}

public class ConstructorEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B1 b = new B1();
	}

}
