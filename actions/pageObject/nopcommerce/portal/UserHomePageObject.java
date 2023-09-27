package pageObject.nopcommerce.portal;


import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Navigate to Register Page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// 2
		//return new RegisterPageObject(driver);
		
		// 3
		return PageGeneratorManager.getUserRegistorPage(driver);
	}

//	@Step("Navigate to Login Page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
//	@Step("Verify My Account Page")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

//	@Step("Navigate to My Account Page")
	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
//	@Step("Back to Home Page")
	public void backToHomePage() {
		waitForElementClickable(driver, HomePageUI.LOGO_HOME);
		clickToElement(driver, HomePageUI.LOGO_HOME);		
	}

//	@Step("Select menu {0}")
	public void selectHeaderMenu(String menu) {
		waitForElementClickable(driver, HomePageUI.HEADER_MENU, menu);
		clickToElement(driver, HomePageUI.HEADER_MENU, menu);
	}

//	@Step("Click Customer service Link in footer {0}")
	public void clickCustomerServiceLinkInFooter(String link) {
		waitForElementClickable(driver, HomePageUI.FOOTER_MENU_CUSTOMER_SERVICE_LINK, link);
		clickToElement(driver, HomePageUI.FOOTER_MENU_CUSTOMER_SERVICE_LINK, link);
	}

	public void selectProductInSectionFeaturedProducts(String productName) {
		waitForElementVisible(driver, HomePageUI.PRODUCT_BY_NAME);
		clickToElement(driver, HomePageUI.PRODUCT_BY_NAME, productName);
	}
}
