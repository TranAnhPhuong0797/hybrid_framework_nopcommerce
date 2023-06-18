package pageObject.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class DownloadProductsPageObject extends BasePage{
	WebDriver driver;
	
	public DownloadProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
