package exam;

import java.util.Date;

public class BookDTO {
  private int isbn;
  private String title;
  private String author;
  private String publisher;
  private int price;
  private String des;
  private Date date;
  
  public BookDTO(int isbn, String title, String author, String publisher, int price, String des, Date date) {
    super();
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.price = price;
    this.des = des;
    this.date = date;
  }

  public BookDTO() {
    super();
  }

  @Override
  public String toString() {
    return "BookDTO [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", price="
        + price + ", des=" + des + ", date=" + date + "]";
  }

  public int getIsbn() {
    return isbn;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  
  
  
  
}
