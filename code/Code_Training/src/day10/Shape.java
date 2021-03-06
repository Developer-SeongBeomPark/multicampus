package day10;

import java.text.DecimalFormat;

interface Ishape{
  double constant = Math.PI;
  double area();
  double round();
  void print();
}



class Circle implements Ishape{
	private double r;
	
	public Circle() {}
	
	public Circle(double r) {
	  this.r = r;
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double area() {
		return r * r * constant;
	}
	
	public double round() {
		return 2 * r * constant;
	}
	
	public void print() {
		DecimalFormat df = new DecimalFormat("####.##");
		System.out.println("=========원==========");
		System.out.println("반지름 : " + r);
		System.out.println("넓이 : " + df.format(area()));
		System.out.println("둘레 : " + df.format(round()));
		
	}
}

class Triangle implements Ishape{
	private double x;
	private double y;
	private double z;
	
	public Triangle() {}
  
  public Triangle(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
	
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

class Rectangle implements Ishape{
	private double x;
	private double y;
	
	public Rectangle() {}
  
  public Rectangle(double x, double y) {
    this.x = x;
    this.y = y;
  }
	
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
		Ishape ci = new Circle(10.);
		ci.print();
		
		Ishape tri = new Triangle(9.45612, 4.84, 5.2415);
		tri.print();
		
		Ishape rec = new Rectangle(4.223, 5.123);
		rec.print();
		
	}

}
