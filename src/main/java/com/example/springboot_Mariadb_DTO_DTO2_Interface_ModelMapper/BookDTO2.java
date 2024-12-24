package com.example.springboot_Mariadb_DTO_DTO2_Interface_ModelMapper;

public class BookDTO2 
{

	int id;
	String title;
	String author;
	int bookno;

	public BookDTO2(int id, String title, String author, int bookno) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.bookno = bookno;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	
}
