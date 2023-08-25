package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.user.UserPostSearchPageUI;

public class UserPostSearchPageObject extends BasePage{
	private WebDriver driver;
	public UserPostSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isNothingFoundMessageDisplayed(String message) {
		waitForAllElementsVisible(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, message);
	}

}
