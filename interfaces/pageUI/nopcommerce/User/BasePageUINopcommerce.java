package pageUI.nopcommerce.User;

public class BasePageUINopcommerce {
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Customer info')]";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Addresses')]";
	public static final String ORDER_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Orders')]";
	public static final String DOWNLOADABLE_PRODUCTS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Downloadable products')]";
	public static final String BACK_IN_STOCK_SUBCRIPTION_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Back in stock subscriptions')]";
	public static final String REWARD_POINTS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Reward points')]";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Change password')]";
	public static final String MY_PRODUCT_REVIEWS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'My product reviews')]";
	
	public static final String DYNAMIC_PAGES_AT_MYACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]";
	
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
}
