package singletonPattern;

public class testSingletonPattern {
	public static void main(String[] args) {
		GlobalConstants g1 = GlobalConstants.getGlobalConstants();
		GlobalConstants g2 = GlobalConstants.getGlobalConstants();
		GlobalConstants g3 = GlobalConstants.getGlobalConstants();
		
		System.out.println(g1.hashCode());
		System.out.println(g2.hashCode());
		System.out.println(g3.hashCode());
	}
}
