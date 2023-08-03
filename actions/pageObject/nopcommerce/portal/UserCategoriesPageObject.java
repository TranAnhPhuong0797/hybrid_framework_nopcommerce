package pageObject.nopcommerce.portal;


import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUI.nopcommerce.User.CategoriesPageUI;


public class UserCategoriesPageObject extends BasePage{
	private WebDriver driver;
	
	public UserCategoriesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Select category {0}")
	public void selectCategories(String category) {
		waitForElementClickable(driver, CategoriesPageUI.CATEGORIES_TREE, category);
		clickToElement(driver, CategoriesPageUI.CATEGORIES_TREE, category);
	}
	@Step("Select product {0}")
	public void selectProductTitle(String productTitle) {
		waitForElementClickable(driver, CategoriesPageUI.PRODUCT_TITLE, productTitle);
		clickToElement(driver, CategoriesPageUI.PRODUCT_TITLE, productTitle);
	}
}
