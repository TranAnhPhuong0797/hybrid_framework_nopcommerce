package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.user.UserPostDetailPageUI;

public class UserPostDetailPageObject extends BasePage{
	private WebDriver driver;
	public UserPostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isPostSearchInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}
	public boolean isPostSearchInforDisplayedithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_TEXT, postTitle, postBody);
	}
	public boolean isPostSearchInforDisplayedithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, author);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, author);
	}
	public boolean isPostSearchInforDisplayedithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST__CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST__CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}
	
}
