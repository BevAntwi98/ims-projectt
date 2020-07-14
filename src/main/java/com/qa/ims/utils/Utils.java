package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {

	public static final String MYSQL_URL = "35.189.70.116:3306";
	public static final Scanner SCANNER = new Scanner(System.in);

	private Utils() {

	}

	public static String getInput() {
		return SCANNER.nextLine();
	}

	public static int getNumberInput() {
		return SCANNER.nextInt();

	}

	public static double getNumInput() {
		return SCANNER.nextDouble();
	}

	public static long gettheInput() {
        return SCANNER.nextLong();
	}
}
