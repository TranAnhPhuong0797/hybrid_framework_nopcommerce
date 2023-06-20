package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class OrderPageObject extends BasePage{
	WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
