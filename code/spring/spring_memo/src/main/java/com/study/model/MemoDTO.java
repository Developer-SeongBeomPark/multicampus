package com.study.model;

import org.springframework.web.multipart.MultipartFile;

public class MemoDTO {
	private int memono;
	private String wname;
	private String title;
	private String content;
	private String passwd;
	private int viewcnt;
	private String wdate;
	private int grpno;
	private int indent;
	private int ansnum;
	/** 파일 이름 */
  private String filename;
  /** 파일 사이즈 */
  private int filesize;
  /** form 선택한 파일을 서버에서 처리할 수 있는 타입으로 선언 */
  private MultipartFile filenameMF;
  
	

	@Override
  public String toString() {
    return "MemoDTO [memono=" + memono + ", wname=" + wname + ", title=" + title + ", content=" + content + ", passwd="
        + passwd + ", viewcnt=" + viewcnt + ", wdate=" + wdate + ", grpno=" + grpno + ", indent=" + indent + ", ansnum="
        + ansnum + ", filename=" + filename + ", filesize=" + filesize + ", filenameMF=" + filenameMF + "]";
  }

  public MemoDTO(int memono, String wname, String title, String content, String passwd, int viewcnt, String wdate,
      int grpno, int indent, int ansnum, String filename, int filesize, MultipartFile filenameMF) {
    super();
    this.memono = memono;
    this.wname = wname;
    this.title = title;
    this.content = content;
    this.passwd = passwd;
    this.viewcnt = viewcnt;
    this.wdate = wdate;
    this.grpno = grpno;
    this.indent = indent;
    this.ansnum = ansnum;
    this.filename = filename;
    this.filesize = filesize;
    this.filenameMF = filenameMF;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public int getFilesize() {
    return filesize;
  }

  public void setFilesize(int filesize) {
    this.filesize = filesize;
  }

  public MultipartFile getFilenameMF() {
    return filenameMF;
  }

  public void setFilenameMF(MultipartFile filenameMF) {
    this.filenameMF = filenameMF;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getGrpno() {
		return grpno;
	}

	public void setGrpno(int grpno) {
		this.grpno = grpno;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public int getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(int ansnum) {
		this.ansnum = ansnum;
	}

}
