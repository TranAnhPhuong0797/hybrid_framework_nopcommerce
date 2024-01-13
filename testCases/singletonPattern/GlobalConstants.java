package singletonPattern;

public class GlobalConstants {
	// Private static variables
	private static GlobalConstants globalinstants;
	
	//Private constructor
	private GlobalConstants(){
		
	}
	
	//Public static methods
	public static GlobalConstants getGlobalConstants() {
		if (globalinstants == null) {
			globalinstants = new GlobalConstants();
		}
		return globalinstants;
	}
}
