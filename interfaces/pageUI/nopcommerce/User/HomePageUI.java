package pageUI.nopcommerce.User;

public class HomePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String LOGO_HOME = "xpath=//div[@class='header-logo']";
	
	//Header locator
	public static final String HEADER_MENU = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	
	//Footer locator
	public static final String FOOTER_MENU_CUSTOMER_SERVICE_LINK = "xpath=//div[@class='footer']//div[@class='footer-block customer-service']//a[text()='%s']";
	
	//Featured products
	public static final String PRODUCT_BY_NAME = "xpath=//div[@class='product-item']//h2[@class='product-title']/a[text()='%s']";
}
