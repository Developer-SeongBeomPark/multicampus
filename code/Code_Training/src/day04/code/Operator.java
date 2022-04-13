package day04.code;

import java.util.Scanner;

class operator{
	private int x, y;
	private String op;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		op = sc.nextLine();
	}
	
	public int output(int x, int y) {
		int value = 0;
		if(op.equals("+")) {
			value = x + y;
		}
		else if(op.equals("-")) {
			value = x - y;
		}
		else if(op.equals("*")) {
			value = x * y;
		}
		else if(op.equals("/")) {
			value = x / y;
		}
		else {
			System.out.println("입력 정보 오류");
			System.exit(0);
		}
		return value;
	}
	
	public void print() {
		
	}
}


public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
