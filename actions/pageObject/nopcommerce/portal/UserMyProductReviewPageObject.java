package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProductReviewTitle(String title) {
		waitForElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_TITLE);
		Assert.assertEquals(getTextElement(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_TITLE),title);
	}

	public void verifyProductReviewContent(String content) {
		waitForElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_CONTENT);
		Assert.assertEquals(getTextElement(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_CONTENT),content);
	}
}
