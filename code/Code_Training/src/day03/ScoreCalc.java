package day03;

class Score{
	private String name;
	private int kuk;
	private int eng;
	private int math;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKuk() {
		return kuk;
	}

	public void setKuk(int kuk) {
		this.kuk = kuk;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

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