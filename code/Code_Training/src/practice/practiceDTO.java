package practice;

import java.util.Date;

public class practiceDTO {
  private int memono;
  private String wname;
  private String title;
  private String content;
  private String passwd;
  private int viewcnt;
  private Date date;

  public practiceDTO() {
    super();
  }

  public practiceDTO(int memono, String wname, String title, String content, String passwd, int viewcnt, Date date) {
    super();
    this.memono = memono;
    this.wname = wname;
    this.title = title;
    this.content = content;
    this.passwd = passwd;
    this.viewcnt = viewcnt;
    this.date = date;
  }

  @Override
  public String toString() {
    return "practiceDTO [memono=" + memono + ", wname=" + wname + ", title=" + title + ", content=" + content + ", passwd="
        + passwd + ", viewcnt=" + viewcnt + ", date=" + date + "]";
  }

  public int getMemono() {
    return memono;
  }

  public void setMemono(int memono) {
    this.memono = memono;
  }

  public String getWname() {
    return wname;
  }

  public void setWname(String wname) {
    this.wname = wname;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public int getViewcnt() {
    return viewcnt;
  }

  public void setViewcnt(int viewcnt) {
    this.viewcnt = viewcnt;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
