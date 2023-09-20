package paggObjectSauceLabSort;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static LoginPageOb getLoginPage(WebDriver driver) {
		return new LoginPageOb(driver);
	}
	
	public static ProductPageOb getProductPage(WebDriver driver) {
		return new ProductPageOb(driver);
	}
}
