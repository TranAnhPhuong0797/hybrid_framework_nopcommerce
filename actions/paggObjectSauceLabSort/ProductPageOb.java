package paggObjectSauceLabSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUI.saucelabSort.ProductPageUI;

public class ProductPageOb extends BasePage {
	WebDriver driver;

	public ProductPageOb(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String item) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, item);
	}

	public boolean isProductNameSortByAscending() {
		// New arraylist to contain the product names on UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Get all elements text product names
		List<WebElement> products = getListElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		for (WebElement productName : products) {
			productUIList.add(productName.getText());
//			System.out.println("Sort on UI: " + productName.getText());
		}

		// New arraylist to sort data in the old arraylist and compare
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);

//		for (String productName : productSortList) {
//			System.out.println("Sort on UI ASC: " + productName);
//		}

		// Compare 2 lists
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// New arraylist to contain the product names on UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Get all elements text product names
		List<WebElement> products = getListElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		for (WebElement productName : products) {
			productUIList.add(productName.getText());
		}

		// New arraylist to sort data in the old arraylist and compare
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);

		// Reversed productSortList
		Collections.reverse(productSortList);

		// Compare 2 lists
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// New arraylist to contain the product names on UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Get all elements text product names
		List<WebElement> products = getListElements(driver, ProductPageUI.PRODUCT_Price_TEXT);

		for (WebElement producPrice : products) {
			productUIList.add(Float.parseFloat(producPrice.getText().replace("$", " ")));
			System.out.println("Sort on UI: " + producPrice.getText());
		}

		// New arraylist to sort data in the old arraylist and compare
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);
		
		for (Float producPrice : productSortList) {
			System.out.println("Sort on UI ASC: " + producPrice);
		}
		
		// Compare 2 lists
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		// New arraylist to contain the product names on UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Get all elements text product names
		List<WebElement> products = getListElements(driver, ProductPageUI.PRODUCT_Price_TEXT);

		for (WebElement producPrice : products) {
			productUIList.add(Float.parseFloat(producPrice.getText().replace("$", " ")));
		}

		// New arraylist to sort data in the old arraylist and compare
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);

		// Reversed productSortList
		Collections.reverse(productSortList);

		// Compare 2 lists
		return productSortList.equals(productUIList);
	}

}
