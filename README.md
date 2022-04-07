# multicampus

## TIL

### Day 1 (4/4 Mon)
```
String str = "data";
int a = 10;
```
* 기본 자료형의 경우, 해당 변수에 a = 10과 같은 값이 들어가 있고 참조형 변수의 경우, heap에 "data"가 저장되어있고 str이라는 객체가 이를 가르키게 된다. 변수 str에는 hashcode 값이 직접적으로 들어가 있다.


### Day 2 (4/5 Tue)
* 다차원 배열은 1차원 배열의 합이다.
ex)
```
String[] arr = new String[2][3];
```
Stack에 arr이 저장되고 Heap에 크기가 2인 배열 a와 크기가 3인 배열 b와 c가 생성된다.<br>
배열 a[0]은 배열 b[0]을 가리키게 되고 a[1]은 c[0]을 가리키게 된다.<br>
따라서 n차원 배열은 n값이 커짐에 따라 사용되는 메모리가 더 많아진다.


### Day 3 (4/6 Wed)
```
class Score{
	String name;
	int kuk;
	int eng;
	int math;
	
	public int total() {
		return kuk + eng + math;
	}
	
	public double avg() {
		return total() / 3.;
	}
	
	public void printScore() {
		System.out.println("국어점수 : " + kuk);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총점수 : " + total());
		System.out.println("평균점수 : " + avg());
	}
}


public class ScoreCalc {

	public static void main(String[] args) {
		Score score = new Score();
		score.name = "park";
		score.kuk = 100;
		score.eng = 95;
		score.math = 94;
		
		score.printScore();

	}

}
```

하나의 파일 안에 2개 이상의 class가 존재할 때, public static void main()이 존재하는 클래스에만! public이 사용되어야 한다.


### Day 4 (4/7 Thu)
* equals 메소드<br>
 Object : 두 비교값의 주소값을 비교<br>
 String : 두 비교값의 문자열을 비교
