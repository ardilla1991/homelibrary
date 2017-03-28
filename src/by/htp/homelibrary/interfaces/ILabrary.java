package by.htp.homelibrary.interfaces;

import by.htp.homelibrary.domain.Book;

public interface ILabrary {
	public void add(Book book);
	
	public Book[] getList();
	
	public void printRecods(Book[] books);
	
	public void delete(String title);
	
	public Book[] findRecordsByAuthorsName(String authors);
	
	public Book[] sortByField();
	
	public void printRecord(Book book);
}
