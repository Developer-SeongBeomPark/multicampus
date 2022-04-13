### Day 5 (4/8 Fri)
##### 업캐스팅

---

객체 형변환 : 업캐스팅, 다운캐스팅

 ```
 class SuperObject{
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println(name);
	}
}

public class SubObject extends SuperObject {

	protected String name;
	public  void draw() {
		name = "Sub";
		super.name = "Super";
		super.draw();
		System.out.println(name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperObject a = new SubObject();
		a.paint();
		
		SubObject b = new SubObject();
		SuperObject s = b;
		
		s.paint();
			
		
	}

}
 ```
 업캐스팅 시, 부모 클래스에 대한 접근만 가능하다.<br>
 하지만 오버라이딩 된 메소드가 있는 경우 자식 클래스 메소드를 사용한다.