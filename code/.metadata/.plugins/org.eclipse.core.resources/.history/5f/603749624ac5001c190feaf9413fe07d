package day05;

class Data{
	private String name;
	private String season;
	private int year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year <= 20 && year <= 30) {
			this.year = year;
		}
		else {
			System.out.println("범위 초과");
		}
	}
	
	
}

public class DataAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data(); 
        //d.name="왕눈이"; 
        //System.out.println(d.name); 
        d.setName("왕눈이"); 
        d.setSeason("늦가을"); 
        d.setYear(35); 
         
        System.out.println(d.getName()); 
        System.out.println(d.getSeason()); 
        System.out.println(d.getYear()); 
	}

}
