package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPageObject extends BasePage{
private WebDriver driver;
	
	
	public AdminPostSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public AdminPostAddNewPageObject clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNew(driver);
	}


	public void enterToSearchTextBox(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}


	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
	}


	public boolean isPostSearchTableDisplayed(String headerName, String cellValue) {
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_NAME, headerName, cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_NAME, headerName, cellValue);
	}

	public AdminPostAddNewPageObject clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		return PageGeneratorManager.getAdminPostAddNew(driver);
	}


	public void selectPostCheckByTitle(String editTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editTitle);
	}


	public void selectTextItemInActionDropdown(String option) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN, option);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN, option);
	}


	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}


	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForAllElementsVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}


	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

}
