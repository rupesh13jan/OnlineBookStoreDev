package com.journaldev.spring.model;

public class BookModel {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BookModel() {
		
	}
	public BookModel(int id, String bookname, String booktype, String author) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.booktype = booktype;
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private int id;
	private String bookname;
	private String booktype;
	private String author;
	
	

}
