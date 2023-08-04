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
	
	//Notifications
	public static final String BAR_NOTIFICATION_CHANGE_PASSWORD_SUCCESS = "xpath=//div[@class='bar-notification success']/p[text()='Password was changed']";
	public static final String CLOSE_NOTIFICATION_BUTTON = "xpath=//div[@class='bar-notification success']/span[@class='close']";
	public static final String BAR_NOTIFICATION = "xpath=//div[@class='bar-notification success']//p";
	
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	
	//Pattern Object
	public static final String DYNAMIC_PAGES_AT_MYACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXT_BOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_TEXT_BOX_BY_TEXT = "xpath=//label[contains(text(),'%s')]//following-sibling::input";
	public static final String DYNAMIC_TEXT_AREA_BY_ID = "xpath=//textarea[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BUTTON_BY_LABEL = "xpath=//label[contains(text(),'%s')]//following-sibling::input";
	public static final String BAR_NOTIFICATION_SUCCESS = "xpath=//div[@class='bar-notification success']/p[text()='%s']";
	public static final String ADDRESS_INFOR_SECTION = "xpath=//strong[text()='%s']//parent::div[@class='title']//following-sibling::ul";
}
