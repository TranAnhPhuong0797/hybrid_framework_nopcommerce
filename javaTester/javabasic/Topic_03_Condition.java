package javabasic;

public class Topic_03_Condition {

	public static void main(String[] args) {
		int num = 10;
		int compareNum = 5;
		// use if and "<"
		if (compareNum < num) {
			System.out.println("Correct");
		}
		
		// use if else and ">"
		if (compareNum > num) {
			System.out.println("Correct");
		}else {
			System.out.println("NOT Correct");
		}
		
		// use if else if else and "<="
		if (num <= compareNum) {
			System.out.println("Correct");
		}else if (num >= compareNum) {
			System.out.println("Data Accept");
		}else {
			System.out.println("Data NOT Accept");
		}
		
		String address = "Da lat";
		
		if (address != "HCM" && address == "Da Lat") {
			System.out.println("My favourite City");
		}else {
			System.out.println("NOT my favourite City");
		}
		
		if(address != "HCM" || address == "Da Lat") {
			System.out.println("My favourite City");
		}
	}

}
