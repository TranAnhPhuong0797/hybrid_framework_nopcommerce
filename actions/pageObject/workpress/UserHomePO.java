package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.user.UserHomePageUI;

public class UserHomePO extends BasePage{
	private WebDriver driver;
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}
	public UserPostDetailPageObject clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPOPage(driver);
	}
	public boolean isPostSearchInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}
	public boolean isPostSearchInforDisplayedithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
	}
	public boolean isPostSearchInforDisplayedithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, author);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, author);
	}
	public boolean isPostSearchInforDisplayedithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST__CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST__CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}
	public boolean isPostSearchInforUndisplayedWithPostTitle(String editTitle) {
		// TODO Auto-generated method stub
		return false;
	}
	public void enterToSearchTextBox(String editTitle) {
		// TODO Auto-generated method stub
		
	}
	public UserPostSearchPageObject clickToSearchButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
