package day04;

public class DefaultConstructor {
	int x;
	public void setX(int x) {this.x = x;}
	public int getX() {return x;}
	
	public DefaultConstructor(int x) {
		this.x = x;
	}
     
    public static void main(String[] args) { 
    	DefaultConstructor d2 = new DefaultConstructor();
    }
}
