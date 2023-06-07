package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
}
