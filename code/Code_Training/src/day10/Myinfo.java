package day10;

public class Myinfo implements Myinfointer {
  private String name, phone, address;
  private int age;
  
  Myinfo(){
    
  }
  
  Myinfo(String name, String phone, String address, int age){
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.age = age;
  }
  
  
  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return name;
  }

  @Override
  public String getPhone() {
    // TODO Auto-generated method stub
    return phone;
  }
  
  public String getAddress() {
    return address;
  }
  
  public int getAge() {
    return age;
  }

}
