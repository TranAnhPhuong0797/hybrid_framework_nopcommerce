package pageObject.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageUI.nopcommerce.Admin.AdminLoginPageUI;


public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;
	
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void inputAdminEmailTextbox(String adminEmailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmailAddress);
	}


	public void inputAdminPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}


	public AdminDashboardPageObject clickLoginAsAdmin() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public void loginAsAdmin(String Adminemail, String Adminpassword) {
		inputAdminEmailTextbox(Adminemail);
		inputAdminPasswordTextbox(Adminpassword);
		clickLoginAsAdmin();
	}
	
}
