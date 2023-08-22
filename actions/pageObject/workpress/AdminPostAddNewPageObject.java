package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPageObject extends BasePage{
private WebDriver driver;
	
	
	public AdminPostAddNewPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitle);
//		switchToDefaultContent(driver);
	}


	public void enterToPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTAREA);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTAREA, postBody);
	}


	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}

	public void clickToRePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.RE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.RE_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISH_MESSAGE, message);
	}


	public AdminPostSearchPageObject openSearchPostPage(String searchPostURL) {
		openPageURL(driver, searchPostURL);
		return PageGeneratorManager.getAdminPostSearch(driver);
	}


	public void switchToPostContent() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.IFRAME_ADD_NEW_POST);
		switchToFrameIframe(driver, AdminPostAddNewPageUI.IFRAME_ADD_NEW_POST);
	}


	public void switchOutPostContent() {
		switchToDefaultContent(driver);
	}


}
