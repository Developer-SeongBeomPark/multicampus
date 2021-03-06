package day09;

class Score{
  private String name;
  private int kuk;
  private int eng;
  private int math;
  
  public Score() {}
  
  public Score(String name, int kuk, int eng, int math){
    this.name = name;
    this.kuk = kuk;
    this.eng = eng;
    this.math = math;
  }
  
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
    System.out.println("=====================");
    System.out.println("이름 : " + name);
    System.out.println("국어점수 : " + kuk);
    System.out.println("영어점수 : " + eng);
    System.out.println("수학점수 : " + math);
    System.out.println("총점수 : " + total());
    System.out.println("평균점수 : " + avg());
  }
}

class Grade extends Score{
    public Grade(){
      
    }
    
    public Grade(String name, int kuk, int eng, int math) {
      super(name,kuk,eng,math);
    }
    
    public String calcGrade() {
      String grade = null;
      int score = (int)avg()/10;
      switch(score) {
      case 10:
      case 9:
        grade = "A등급 입니다.";
        break;
      case 8:
        grade = "B등급 입니다.";
        break;
      case 7:
        grade = "C등급 입니다.";
        break;
      case 6:
        grade = "D등급 입니다.";
        break;
      default:
        grade = "F등급 입니다.";
        break;
      }
      return grade;
    }

    @Override
    public void printScore() {
      // TODO Auto-generated method stub
      super.printScore();
      System.out.println("평점 : " + calcGrade());
    }
    
    
}


public class ScoreCalc {
  public static void main(String[] args) {
     Grade g = new Grade("박성범",100,97,92);
     g.printScore();
    

  }

}