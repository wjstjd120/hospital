package com.view;

import java.util.Scanner;

public class InOutClass {
	
	private Scanner scan = new Scanner(System.in);
		
	public void oPrint(String str) {
		System.out.print(str);
	}
	
	public void nPrint(String str) {
		System.out.println(str);
	}
	
	public String inStr(String str) {
		oPrint(str);
		String s = scan.nextLine();
		return s;
	}
	
	public int inNum(String str) {
		oPrint(str);
		int n = -999999;
		String s = scan.nextLine();
		
		try {
			n = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		} 
		
		return n;
		
	}
	
	

} //class end
