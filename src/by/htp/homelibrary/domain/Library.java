package by.htp.homelibrary.domain;

import by.htp.homelibrary.interfaces.ILabrary;

public class Library implements ILabrary{
	
	private Book list[] = new Book[0]; 
	
	public void add(Book book){
		this.list = this.addRecord(this.list, book);
	}
	
	public Book[] getList(){
		return list;
	}
	
	public void printRecods(Book[] books){
		//System.out.println("Library");
		if ( books.length > 0 ) {
			for ( int i = 0; i < books.length; i++ ) {
				printRecord(books[i]);
			}
		} else {
			System.out.println("Empty");
		}
	}
	
	public void delete(String title) {
		int listLength = list.length;
		int numberOfDeleted = 0;
		for ( int i = 0; i < listLength; i++ ) {
			if ( title.equals(list[i].getTitle()) ) {
				
				Book books[] = new Book[list.length - 1];
				System.arraycopy(list, 0, books, 0, i);
				System.arraycopy(list, i+1, books, i, listLength - i - 1);
				listLength--;
				numberOfDeleted++;
				list = books;
				i--;
			}
		}
		
		System.out.println("Number of deleted: " + numberOfDeleted);
	}
	
	public Book[] findRecordsByAuthorsName(String authors) {
		System.out.println("Find authors names: " + authors);
		Book[] foundedBooks = new Book[]{};
		
		for ( int i = 0; i < list.length; i++ ) {
			if ( (authors.toLowerCase()).indexOf((list[i].getAuthor()).toLowerCase()) >= 0 ) {
				foundedBooks = this.addRecord(foundedBooks, list[i]);
			}
		}

		return foundedBooks;
	}
	
	public Book[] sortByField() {
		System.out.println("SORT");
		Book serviceEl = new Book();
		Book listSort[] = new Book[]{};

		for ( int k = 0; k < list.length; k++ ) {
			listSort = this.addRecord(listSort, list[k]);
		}
		
		for ( int i = 0; i < listSort.length; i++ ) {
			for ( int j = i + 1; j < listSort.length; j++ ) {
				if ( listSort[j].getPublishingYear() > listSort[i].getPublishingYear() ) {
					serviceEl = listSort[i];
					listSort[i] = listSort[j];
					listSort[j] = serviceEl;
				}
			}
		}
		
		return listSort;
	}
	
	public void printRecord(Book book) {
		System.out.print("Title: " + book.getTitle() + ", ");
		System.out.print("Author: " + book.getAuthor() + ", ");
		System.out.println("Publishing year: " + book.getPublishingYear() + "; "); 		
	}
	
	private Book[] addRecord(Book[] coppiedArray, Book elem) {
		Book[] serv = new Book[coppiedArray.length + 1];
		for (int i = 0; i < coppiedArray.length; i++){
			serv[i] = coppiedArray[i];
		}
		serv[coppiedArray.length] = elem;
		
		return serv;
	}	
	
}
