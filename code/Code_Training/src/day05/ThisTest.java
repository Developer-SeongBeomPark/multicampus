package day05;

class This{
	String area = "";
	
	public void prn() {
		System.out.println("이 메소드를 호출한 객체의 HashCode : " + this);
		System.out.println(this.area);
	}
}

public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		This obj1 = new This();
		obj1.area = "인천시";
		obj1.prn();
		System.out.println("obj1.hashCode() : " + obj1.hashCode());
	}

}
