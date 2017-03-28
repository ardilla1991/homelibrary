package by.htp.homelibrary.domain;

import java.util.Scanner;

public class ConsoleMenu {
	
	private static String[] menu = new String[5];
	private Library object;
	private int choosedPoint = -1;
	
	public ConsoleMenu(Library obj) {
		menu[0] = "0. Exit";
		menu[1] = "1. View list";
		menu[2] = "2. Sort books by publishing year";
		menu[3] = "3. Find books by authors";
		menu[4] = "4. Delete book by title";
		object = obj;
	}
	
	public void index() {
		printMenu();
		
		Scanner inString = new Scanner(System.in);
		CheckInput checkInput = new CheckInput();
		scanMenuPoint(inString, checkInput);
		int menuId = choosedPoint;
		
		if ( menuId > 0 ) {
			startAction(menuId);
		} else {
			System.out.println("Buy.");
			inString.close();
		}
	}
	
	private void scanMenuPoint(Scanner inString, CheckInput checkInput) {
		String menuId = inString.nextLine();
		System.out.println("Selected point is " + menuId);
		int menuIdInt = 0;
		if ( checkInput.checkNumber(menuId) )
			menuIdInt = Integer.valueOf(menuId);
		else
			menuIdInt = -1;
		
		if ( menu.length > menuIdInt && ( menuIdInt != -1 ) && menuIdInt != 0) {
			setChoosedPoint(menuIdInt);
		} else if ( menuIdInt == -1 ) {
			System.out.print("Number not found. Enter other number: ");
			scanMenuPoint(inString, checkInput);
		} else if ( menuIdInt == 0 ) {
			setChoosedPoint(menuIdInt);
		}
	}
	
	private void printMenu() {
		System.out.println("Choose a point of menu");
		for ( int i = 0; i < menu.length; i++ ) {
			System.out.println(menu[i]);
		}
	}
	
	private void startAction(int menuId) {
		switch (menuId) {
		case 1:
			object.printRecods(object.getList());
			break;
		case 2:
			object.printRecods(object.sortByField());
			break;
		case 3:
			System.out.println("Enter names separated by , ");
			object.printRecods(object.findRecordsByAuthorsName(getStr()));
			break;
		case 4:
			System.out.print("Inter title:");
			object.delete(getStr());
		default:
			break;
		}
		index();
	}
	
	private String getStr() {
		Scanner inString = new Scanner(System.in);
		String names = inString.nextLine();
		System.out.println();
		
		return names;
	}
	
	private void setChoosedPoint(int choosedPoint) {
		this.choosedPoint = choosedPoint;
	}
	
}
