package com.revature;

import java.util.Scanner;

public class Parser {
	private Scanner sc;

	public Parser() {
		this.sc = new Scanner(System.in);
	}

	public String getInput() {
		String input = sc.nextLine();
		return input;
	}

}
