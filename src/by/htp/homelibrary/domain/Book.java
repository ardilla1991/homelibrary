package by.htp.homelibrary.domain;

public class Book {

	private String author;
	private String title;
	private int publishingYear;
	

	public Book() {
		
	}
	
	public Book(String title, String author, int publishingYear) {
		this.title = title;
		this.author = author;
		this.publishingYear = publishingYear;
	}
	
	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getPublishingYear() {
		return publishingYear;
	}
	
	
}

