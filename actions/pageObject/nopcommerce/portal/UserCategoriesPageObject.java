package pageObject.nopcommerce.portal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.CategoriesPageUI;

public class UserCategoriesPageObject extends BasePage {
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
	public boolean verifyProductNameSortAtoZAsc() {
		List<WebElement> productNames = getListElements(driver, CategoriesPageUI.LIST_PRODUCT_NAME);
		ArrayList<String> productsUI = new ArrayList<String>();
		for (WebElement product : productNames) {
			productsUI.add(product.getText());
		}

		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productsUI) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productsUI);
	}

	public boolean verifyProductNameSortZtoADesc() {
		List<WebElement> productNames = getListElements(driver, CategoriesPageUI.LIST_PRODUCT_NAME);
		ArrayList<String> productsUI = new ArrayList<String>();
		for (WebElement product : productNames) {
			productsUI.add(product.getText());
		}

		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productsUI) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);

		return productSortList.equals(productsUI);
	}

	public boolean verifyProductPriceSortAtoZAsc() {
		ArrayList<Float> productsUI = new ArrayList<Float>();

		List<WebElement> products = getListElements(driver, CategoriesPageUI.LIST_PRODUCT_PRICE);

		for (WebElement producPrice : products) {
			productsUI.add(Float.parseFloat(producPrice.getText().replace("$", "").replace(",", "")));
			System.out.println("Sort on UI: " + producPrice.getText());
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productsUI) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);
		
		for (Float producPrice : productSortList) {
			System.out.println("Sort on UI ASC: " + producPrice);
		}
		
		return productSortList.equals(productsUI);
	}

	public boolean verifyProductPriceSortZtoADesc() {
		ArrayList<Float> productsUI = new ArrayList<Float>();

		List<WebElement> products = getListElements(driver, CategoriesPageUI.LIST_PRODUCT_PRICE);

		for (WebElement producPrice : products) {
			productsUI.add(Float.parseFloat(producPrice.getText().replace("$", " ").replace(",", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productsUI) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);
		for (Float producPrice : productSortList) {
			System.out.println("Sort on UI Desc: " + producPrice);
		}
		
		return productSortList.equals(productsUI);
	}

	public boolean verifyThePageShowTotalProductsEqualTo(int i) {
		waitForElementVisible(driver, CategoriesPageUI.LIST_PRODUCT);
		int totalProducts = getElementsSize(driver, CategoriesPageUI.LIST_PRODUCT);
		return totalProducts <= i;
	}

	public boolean verifyNextPagingIconDisplayed() {
		waitForElementVisible(driver, CategoriesPageUI.NEXT_PAGING_PRODUCT);
		waitForElementVisible(driver, CategoriesPageUI.CURRENT_PAGING_PRODUCT);
		
		Assert.assertEquals(getTextElement(driver, CategoriesPageUI.CURRENT_PAGING_PRODUCT), "1");
		return isElementDisplayed(driver, CategoriesPageUI.NEXT_PAGING_PRODUCT);
	}

	public boolean verifyPreviousPagingIconUndisplayed() {
		return isElementUndisplayed(driver, CategoriesPageUI.PREVIOUS_PAGING_PRODUCT);
	}

	public void clickNextPagingIcon() {
		waitForElementClickable(driver, CategoriesPageUI.NEXT_PAGING_PRODUCT);
		clickToElement(driver, CategoriesPageUI.NEXT_PAGING_PRODUCT);
	}

	public boolean verifyPreviousPagingIconDisplayed() {
		waitForElementVisible(driver, CategoriesPageUI.PREVIOUS_PAGING_PRODUCT);
		waitForElementVisible(driver, CategoriesPageUI.CURRENT_PAGING_PRODUCT);
		
		Assert.assertEquals(getTextElement(driver, CategoriesPageUI.CURRENT_PAGING_PRODUCT), "2");
		return isElementDisplayed(driver, CategoriesPageUI.PREVIOUS_PAGING_PRODUCT);
	}

	public boolean verifyNextPagingIconUndisplayed() {
		return isElementUndisplayed(driver, CategoriesPageUI.NEXT_PAGING_PRODUCT);
	}

	public boolean verifyPagingUndisplatyed() {
		return isElementUndisplayed(driver, CategoriesPageUI.CURRENT_PAGING_PRODUCT);
	}

}
