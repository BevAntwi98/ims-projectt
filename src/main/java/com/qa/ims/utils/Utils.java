package com.qa.ims.utils;


import java.util.Date;
import java.util.Scanner;

public class Utils {

	public static final String MYSQL_URL = "35.189.70.116:3306";
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final Date date = new Date();

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
	
	public  void getTheDate() {
		System.out.println(date);
	}

	
}
