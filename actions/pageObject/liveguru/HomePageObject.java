package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.liveguru.HomePageUI;


public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToMyAccountButton() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.MYACCOUNT_BUTTON);
	}

	public LoginPageObject clickToMyAccountOption() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_OPTION);
		clickToElement(driver, HomePageUI.MYACCOUNT_OPTION);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public RegisterPageObject clickToRegistorOption() {
		waitForElementClickable(driver, HomePageUI.REGISTER_OPTION);
		clickToElement(driver, HomePageUI.REGISTER_OPTION);
		return PageGeneratorManager.getRegistorPage(driver);
	}

	
	public LoginPageObject clickToLoginOption() {
		waitForElementClickable(driver, HomePageUI.LOGIN_OPTION);
		clickToElement(driver, HomePageUI.LOGIN_OPTION);
		return PageGeneratorManager.getLoginPage(driver);
	}

	
}
