package paggObjectSauceLabSort;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.saucelabSort.ProductPageUI;

public class ProductPageOb extends BasePage{
	WebDriver driver;
	
	public ProductPageOb(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String item) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, item);
	}
	
}
