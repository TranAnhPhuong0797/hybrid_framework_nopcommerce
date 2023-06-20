package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserOrderPageObject extends BasePage{
	WebDriver driver;
	
	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
