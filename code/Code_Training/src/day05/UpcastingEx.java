package day05;

class Person{
	String name;
	String id;
	
	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person{
	String grage;
	String department;
	
	public Student(String name) {
		super(name);
	}
}

public class UpcastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p;
		Student s = new Student("이재문");
		p = s;
		
		System.out.println(p.name);
		// p.grade = "A";
		// p.department = "Com"; 컴파일 오류
		}

}
