package practice;

public class prac {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str = "안 녕 하 세 요";
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == ' '){
        str = str.substring(0,i) + str.substring(i+1, str.length());
        i = i - 1;
      }
    }
    
    System.out.println(str);
  }

}
