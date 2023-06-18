package pageObject.nopcommerce;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegistorPage(WebDriver driver) {	
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {	
		return new CustomerInforPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static DownloadProductsPageObject getDownloadProductsPage(WebDriver driver) {
		return new DownloadProductsPageObject(driver);
	}
	
	public static BackInStockSubscriptionsPageObject getBackInStockSubscriptionsPage(WebDriver driver) {
		return new BackInStockSubscriptionsPageObject(driver);
	}
	
	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
}
