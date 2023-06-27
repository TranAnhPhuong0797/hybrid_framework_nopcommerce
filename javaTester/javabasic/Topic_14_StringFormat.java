package javabasic;

public class Topic_14_StringFormat {
	public static String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Customer info')]";
	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Addresses')]";
	public static String ORDER_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Orders')]";
	public static String DOWNLOADABLE_PRODUCTS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Downloadable products')]";
	public static String BACK_IN_STOCK_SUBCRIPTION_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Back in stock subscriptions')]";
	public static String REWARD_POINTS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Reward points')]";
	public static String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Change password')]";
	public static String MY_PRODUCT_REVIEWS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'My product reviews')]";
	
	// 1 variable for n pages
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]";
	
	//1 locator for n pages (Header, footer, sidebar)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//div[contains(@class,'%s')]//a[contains(text(),'%s')]";
	
	public static void main(String[] args) {
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses");
		
		clickToSideBarLink(ORDER_LINK);
		clickToSideBarLink(DOWNLOADABLE_PRODUCTS_LINK);
		
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		
	}
	
	//no dynamic variable
	public static void clickToSideBarLink(String locator) {
		System.out.println("Click to: " + locator);
	}
	
	//1 dynamic variable
	public static void clickToSideBarLink(String dyamicLocator, String pageName) {
		// dyamicLocator = //div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]
		// pageName = Customer information
		String locator = String.format(dyamicLocator, pageName);
		System.out.println("Click to: " + locator);
	}
	//2 dynamic variables
	public static void clickToSideBarLink(String dyamicLocator,String areaName, String pageName) {
		String locator = String.format(dyamicLocator, areaName, pageName);
		System.out.println("Click to: " + locator);
	}
	
	//n dynamic variables
	public static void clickToSideBarLink(String dyamicLocator, String... params) {
		// dyamicLocator = //div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]
		// pageName = Customer information
		String locator = String.format(dyamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
}
