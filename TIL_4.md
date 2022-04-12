### Day 4 (4/7 Thu)
* equals 메소드<br>
 Object : 두 비교값의 주소값을 비교<br>
  String : 두 비교값의 문자열을 비교<br><br>

* 생성자 
 ```
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
 ```
 인자를 갖는 생성자를 보유한 class에는 기본 생성자를 필수적으로 작성해줘야한다.
 기본 생성자만 갖고있는 class의 객체를 만들 때에는 class에 기본 생성자를 작성하지 않아도 객체 생성 시 알아서 기본 생성자를 만들어 주지만 인자를 갖는 생성자를 보유하고 있는 경우에는 기본 생성자를 꼭 만들어줘야 에러가 발생하지 않는다.<br><br>

* static<br>
 static이 선언되면 메모리의 stack, heap, code영역이 아닌 data영역에 해당 값이 저장된다.<br><br>