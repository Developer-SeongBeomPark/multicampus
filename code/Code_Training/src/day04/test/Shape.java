package day04.test;

import java.text.DecimalFormat;

class Circle{
	private double r;
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double area() {
		return r * r * Math.PI;
	}
	
	public double round() {
		return 2 * r * Math.PI;
	}
	
	public void print() {
		DecimalFormat df = new DecimalFormat("####.##");
		System.out.println("=========원==========");
		System.out.println("반지름 : " + r);
		System.out.println("넓이 : " + df.format(area()));
		System.out.println("둘레 : " + df.format(round()));
		
	}
}

class Triangle{
	private double x;
	private double y;
	private double z;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double area() {
		double sum = x + y + z;
		return Math.sqrt(sum*(sum-x)*(sum-y)*(sum-z));
	}
	
	public double round() {
		return (x + y + z) / 2;
	}
	
	public void print() {
		DecimalFormat df = new DecimalFormat("####.##");
		System.out.println("=========삼각형==========");
		System.out.println("변1 : " + x);
		System.out.println("변2 : " + y);
		System.out.println("변3 : " + z);
		System.out.println("넓이 : " + df.format(area()));
		System.out.println("둘레 : " + df.format(round()));
		
	}
}

class Rectangle{
	private double x;
	private double y;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	public double area() {
		return x * y;
	}
	
	public double round() {
		return 2 * (x + y);
	}
	
	public void print() {
		DecimalFormat df = new DecimalFormat("####.##");
		System.out.println("=========직사각형==========");
		System.out.println("가로 : " + x);
		System.out.println("세로 : " + y);
		System.out.println("넓이 : " + df.format(area()));
		System.out.println("둘레 : " + df.format(round()));
		
	}
}


public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle ci = new Circle();
		ci.setR(10.);
		ci.print();
		
		Triangle tri = new Triangle();
		tri.setX(9.45612);
		tri.setY(4.84);
		tri.print();
		
		Rectangle rec = new Rectangle();
		rec.setX(4.223);
		rec.setY(5.123);
		rec.print();
	}

}
