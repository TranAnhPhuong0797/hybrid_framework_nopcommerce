package javabasic;

public class Topic_02_java_Compare {
	int num = 5;
	public static void main(String[] args) {
		//*Stack memory
		//set value the variable x
		int x = 9;
		
		//set value the variable y
		int y = x;
		
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		
		//set again value the variable y
		y = 18;
		
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		
		//*Heap memory
		Topic_02_java_Compare Value1 = new Topic_02_java_Compare();
		Topic_02_java_Compare Value2 = new Topic_02_java_Compare();
		
		System.out.println("Before Value1: " + Value1.num);
		System.out.println("Before Value2: " + Value2.num);
		
		Value2.num = 10;
		System.out.println("After Value1: " + Value1.num);
		System.out.println("After Value2: " + Value2.num);
	}

}
