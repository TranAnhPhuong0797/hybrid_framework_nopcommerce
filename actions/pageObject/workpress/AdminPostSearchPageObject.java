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
		// TODO Auto-generated method stub
		
	}


	public void clickToSearchPostButton() {
		// TODO Auto-generated method stub
		
	}


	public boolean isPostSearchTableDisplayed(String string, String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

}
