package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.ProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public UserProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	@Step("Verify Product Review Page have title {0}")
	public void verifyProductTitleIsDisplayedWithName(String nameProductTitle) {
		waitForElementClickable(driver, ProductReviewPageUI.PRODUCT_REVIEW_TITLE, nameProductTitle);
		isElementDisplayed(driver, ProductReviewPageUI.PRODUCT_REVIEW_TITLE, nameProductTitle);
	}
	
	
}
