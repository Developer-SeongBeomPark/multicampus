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