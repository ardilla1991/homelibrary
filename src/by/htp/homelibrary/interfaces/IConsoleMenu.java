package by.htp.homelibrary.interfaces;

import java.util.Scanner;

import by.htp.homelibrary.domain.CheckInput;

public interface IConsoleMenu {
	
	void index();
	
	void scanMenuPoint(Scanner inString, CheckInput checkInput);
	
	void printMenu();
	
	void startAction(int menuId);
	
	String getStr();
	
	void setChoosedPoint(int choosedPoint);
}
