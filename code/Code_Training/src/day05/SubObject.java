package day05;

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
