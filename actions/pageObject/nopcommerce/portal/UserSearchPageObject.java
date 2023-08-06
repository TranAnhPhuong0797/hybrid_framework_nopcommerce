package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.SearchPageUI;

public class UserSearchPageObject extends BasePage{
	WebDriver driver;
	
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON_IN_SEARCH_PAGE);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON_IN_SEARCH_PAGE);
	}

	public void verifySearchErrorMessage(String errorMessage) {
		waitForElementVisible(driver, SearchPageUI.ERROR_MESSAGE_IN_SEARCH_PAGE);
		Assert.assertEquals(getTextElement(driver, SearchPageUI.ERROR_MESSAGE_IN_SEARCH_PAGE), errorMessage);
	}

	public void inputValueInSearchTextbox(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXT);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXT, value);
	}

	public void verifySearchNoResultMessage() {
		waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE_IN_SEARCH_PAGE);
		Assert.assertTrue(isElementDisplayed(driver, SearchPageUI.NO_RESULT_MESSAGE_IN_SEARCH_PAGE));
	}

	public void productResultEqualDisplayed(int result) {
		waitForAllElementsVisible(driver, SearchPageUI.LIST_PRODUCT);
		Assert.assertEquals(getElementsSize(driver, SearchPageUI.LIST_PRODUCT), result);
	}

	public void VeirfyProductNameIsDisplayed(String productName) {
		waitForElementVisible(driver, SearchPageUI.PRODUCTS__LINK, productName);
		Assert.assertTrue(isElementDisplayed(driver, SearchPageUI.PRODUCTS__LINK, productName));
	}

	public void checkTheCheckBoxInSearchPage(String checkboxName) {
		waitForElementVisible(driver, SearchPageUI.DYNAMIC_SEARCH_PAGE_CHECKBOX, checkboxName);
		checkToDefaultCheckboxOrRadio(driver, SearchPageUI.DYNAMIC_SEARCH_PAGE_CHECKBOX, checkboxName);
	}

	public void unCheckTheCheckBoxInSearchPage(String checkboxName) {
		waitForElementVisible(driver, SearchPageUI.DYNAMIC_SEARCH_PAGE_CHECKBOX, checkboxName);
		unCheckToDefaultCheckboxOrRadio(driver, SearchPageUI.DYNAMIC_SEARCH_PAGE_CHECKBOX, checkboxName);
	}
	
	public void selectCategoriesDropDownWithValue(String value) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN_LIST, value);
	}
	
	public void selectManufacturerDropDownWithValue(String value) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN_LIST, value);
	}
}
