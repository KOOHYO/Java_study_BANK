package com.iu.start.bankbook;


public class BankBookDTO {
	//변수선언
	private long booknum;
	private String bookname;
	private double bookrate;
	private int booksale;
	
	//개터 세터

	public long getBooknum() {
		return booknum;
	}
	public void setBooknum(long booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public int getBooksale() {
		return booksale;
	}
	public void setBooksale(int booksale) {
		this.booksale = booksale;
	}
	
}
