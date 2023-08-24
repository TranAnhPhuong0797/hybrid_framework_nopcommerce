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
		// TODO Auto-generated method stub
		
	}


	public void selectTextItemInActionDropdown(String string) {
		// TODO Auto-generated method stub
		
	}


	public boolean isMoveToTrashMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isNoPostFoundMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	public void clickToApplyButton() {
		// TODO Auto-generated method stub
		
	}

}
