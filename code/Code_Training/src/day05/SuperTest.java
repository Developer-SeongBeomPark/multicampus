package day05;

class School{
	int year = 0;
	public School() {
		this.year = 0;
	}
}

class MiddleSchool extends School{
	int year = 0;
	public MiddleSchool() {
		this.year = 3;
	}
	public void prn() {
		System.out.println("year : " + year);
		System.out.println("this.year : " + this.year);
		System.out.println("super.year : " + super.year);
	}
}

public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleSchool middleSchool = new MiddleSchool();
		middleSchool.prn();
	}

}
