package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.liveguru.LoginPageUI;


public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public RegisterPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegistorPage(driver);
	}
	
	


}
