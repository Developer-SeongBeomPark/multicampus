package day02;

public class ArrayWhile2 {

	public static void main(String[] args) {
		String[] movies = {"그래비티", "맘마 미아", "레미제라블", "월터의 상상은 현실이 된다.", "노아"};
		int[] years = {2014, 2008, 2012, 2013, 2014};
	    
	    int cnt = -1;
	    
	    System.out.println("배열의 값의 갯수: " + movies.length); // 8
	    while(cnt < movies.length - 1){
	      cnt = cnt + 1;
	      System.out.println(movies[cnt] + " - " + years[cnt]); // 0 ~ 7
	    }
	}

}
