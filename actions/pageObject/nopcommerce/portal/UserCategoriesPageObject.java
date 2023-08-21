package pageObject.nopcommerce.portal;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.CategoriesPageUI;


public class UserCategoriesPageObject extends BasePage{
	private WebDriver driver;
	
	public UserCategoriesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Select category {0}")
	public void selectCategories(String category) {
		waitForElementClickable(driver, CategoriesPageUI.CATEGORIES_TREE, category);
		clickToElement(driver, CategoriesPageUI.CATEGORIES_TREE, category);
	}
//	@Step("Select product {0}")
	public void selectProductTitle(String productTitle) {
		waitForElementClickable(driver, CategoriesPageUI.PRODUCT_TITLE, productTitle);
		clickToElement(driver, CategoriesPageUI.PRODUCT_TITLE, productTitle);
	}
//	@Step("Verify product name sort order A to Z")
	public void verifyProductNameSortAtoZ() {
		List<WebElement> productNames = getListElements(driver, CategoriesPageUI.LIST_PRODUCT_NAME);
		ArrayList<String> products = new ArrayList<String>();
		for (WebElement product : productNames) {
			String productValue = product.getText();
			products.add(productValue);
		}
		
	}
	
}
