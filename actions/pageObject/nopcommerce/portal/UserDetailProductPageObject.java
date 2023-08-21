package pageObject.nopcommerce.portal;


import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.DetailProductPageUI;


public class UserDetailProductPageObject extends BasePage{
	private WebDriver driver;
	
	public UserDetailProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Click add review product")
	public void clickAddYourReview() {
		waitForElementClickable(driver, DetailProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, DetailProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

}
