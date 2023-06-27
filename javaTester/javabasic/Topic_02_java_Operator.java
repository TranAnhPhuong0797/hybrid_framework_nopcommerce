package javabasic;

import java.util.Iterator;

public class Topic_02_java_Operator {
	
		
	public static void main(String[] args) {
		//*Assign
		int x = 0;
		x = x + 5;
		System.out.println("X = " + x);
		
		x +=10;
		System.out.println("X = " + x);
		
		x -=1;
		System.out.println("X = " + x);
		
		x *=1;
		System.out.println("X = " + x);
		
		x /=2;
		System.out.println("X = " + x);
		
		x %=2;
		System.out.println("X = " + x);
		
		int num = 10;
		System.out.println("Num = " + num++);
		
		System.out.println("Num = " + ++num);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("I = " + i);
		}
		
		String address = "Da Lat";
		if (address != "HCM" && address != "Da Nang") {
			System.out.println("Address not the same");
		}
		
		if (address != "HCM" || address != "Da Nang") {
			System.out.println("Address not the same");
		}
	}

}
