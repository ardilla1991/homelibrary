package by.htp.homelibrary.launch;

import by.htp.homelibrary.domain.Book;
import by.htp.homelibrary.domain.ConsoleMenu;
import by.htp.homelibrary.domain.Library;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("Book One", "Author One", 1990);
		Library library = new Library();
		library.add(book1);
		Book book4 = new Book("Book Two", "Author One", 1994);
		library.add(book4);
		Book book2 = new Book("Book Two", "Author Second", 1995);
		library.add(book2);
		Book book3 = new Book("Book Three", "Author Two", 1992);
		library.add(book3);
		
		ConsoleMenu consoleMenu = new ConsoleMenu(library);
		consoleMenu.index();
		/*library.printRecods(library.getList());
		
		String authors[] = new String[]{"Author One", "Author Second"};
		library.findRecord(authors);

		library.delete("Book Two");
		library.printRecods(library.getList());
		
		library.printRecods(library.sortByField());*/
	}

}
