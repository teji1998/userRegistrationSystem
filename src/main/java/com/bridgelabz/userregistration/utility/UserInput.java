package com.bridgelabz.userregistration.utility;

import java.util.Scanner;

public class UserInput {

	private static Scanner scanner = new Scanner(System.in);

	public static int getNumber() {
		return scanner.nextInt();
	}

	public static String getString() {
		return scanner.next();
	}
}
