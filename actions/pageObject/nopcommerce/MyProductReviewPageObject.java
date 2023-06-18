package pageObject.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class MyProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
