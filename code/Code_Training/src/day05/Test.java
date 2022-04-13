package day05;

class Test {
	String name;
	String phone;
	static int ID;

	public void setName(String s) {
		name = s;
	    }
	public String getPhone() {
		return phone;
		}
	public static int getID() {
		return ID;
		}
}

class Professor extends Test {

	public void setName(String s) {} //오버라이딩
	
	/*
	public String getPhone() {  
		return phone;
	}*/ // 부모 클래스와 동일한 method이기 때문에 주석처리 한다.
	
	public String getPhone(){ return ""; } // 부모 클래스의 메소드와 동일한 반환형을 명시하고 return문을 기입한다.
	
	//public int getID() {return ID;} // static은 오바리이딩 불가능
}
