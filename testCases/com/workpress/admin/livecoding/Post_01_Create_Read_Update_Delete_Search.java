package com.workpress.admin.livecoding;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.workpress.AdminDashboardPageObject;
import pageObject.workpress.AdminLoginPageObject;
import pageObject.workpress.AdminPostAddNewPageObject;
import pageObject.workpress.AdminPostSearchPageObject;
import pageObject.workpress.PageGeneratorManager;
import pageObject.workpress.UserHomePO;
import pageObject.workpress.UserPostDetailPageObject;
import pageObject.workpress.UserPostSearchPageObject;



public class Post_01_Create_Read_Update_Delete_Search extends BaseTest{
	String adminUserName = "phuongtran97";
	String adminPassword = "phuongtran97@";
	String searchPostURL;
	String postTitle = "Post" + fakeNumber() ;
	String editTitle = "Edit Title" + fakeNumber() ;
	String editBody = "Edit Body" + fakeNumber();
	String postBody = "Live coding" + fakeNumber();
	String author = "phuongtran97";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDate();
	
	@Parameters({"browser", "urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		//Preconditions
		log.info("Preconditions - Step 01: Open browser and admin url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserName(browserName, this.adminUrl);
		adminLoginPO = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Preconditions - Step 02: Enter username with value " + adminUserName);
		adminLoginPO.enterToUserNameTextbox(adminUserName);
		
		log.info("Preconditions - Step 02: Enter password with value " + adminPassword);
		adminLoginPO.enterToPasswordTextbox(adminPassword);
		
		log.info("Preconditions - Step 03: Click to 'login' button");
		adminDashboard = adminLoginPO.clickTologinButton();
	}
	
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create Post - Step 01: Click to 'Post' menu link");
		adminPostSearch = adminDashboard.clickToMenuLink();
		
		log.info("Create Post - Step 02: Get page URL");
		searchPostURL = adminPostSearch.getPageURL(driver);
		
		log.info("Create Post - Step 03: Click to 'Add new' button");
		adminPostAddNew = adminPostSearch.clickToAddNewButton();
		
		log.info("Create Post - Step 04: Switch to Post content");
		adminPostAddNew.switchToPostContent();
		
		log.info("Create Post - Step 05: Enter to post title");
		adminPostAddNew.enterToPostTitle(postTitle);
		
		log.info("Create Post - Step 06: Enter to post title body");
		adminPostAddNew.enterAddNewToPostBody(postBody);		
				
		log.info("Create Post - Step 07: Switch out Post content");
		adminPostAddNew.switchOutPostContent();
		
		log.info("Create Post - Step 08: Click to 'Publish' button");
		adminPostAddNew.clickToPublishOrUpdateButton();
		
		log.info("Create Post - Step 09: Click to 'Re-Publish' button");
		adminPostAddNew.clickToRePublishButton();
		
		log.info("Create Post - Step 10: Verify 'Post Publish' message is displayed");
		verifyTrue(adminPostAddNew.isPostPublishOrUpdatedMessageDisplayed("Post published."));
		
	}
	
	@Test
	public void Post_02_Search_Post() {
		log.info("Search Post - Step 01: Open 'Search post' page");
		adminPostSearch = adminPostAddNew.openSearchPostPage(searchPostURL);
		
		log.info("Search Post - Step 02: Enter search post");
		adminPostSearch.enterToSearchTextBox(postTitle);
		
		log.info("Search Post - Step 03: Click 'Search Posts' button");
		adminPostSearch.clickToSearchPostButton();
		
		log.info("Search Post - Step 04: Verify search table contains " + postTitle);
		verifyTrue(adminPostSearch.isPostSearchTableDisplayed("Title", postTitle));
		
		log.info("Search Post - Step 05: Verify search table contains " + author);
		verifyTrue(adminPostSearch.isPostSearchTableDisplayed("Author", author));
		
		log.info("Search Post - Step 06: Open End User site");
		userHome = adminPostSearch.openEndUserSite(driver, endUserUrl);
		
		log.info("Search Post - Step 07: Veirfy post Title infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedWithPostTitle(postTitle));
		
		log.info("Search Post - Step 08: Veirfy post Body infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostBody(postTitle, postBody));
		
		log.info("Search Post - Step 09: Veirfy post Author infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostAuthor(postTitle, author));
		
		log.info("Search Post - Step 10: Veirfy post CurrentDay infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostCurrentDay(postTitle, currentDay));
		
		log.info("Search Post - Step 11: Click to Post Title");
		userPostDetail = userHome.clickToPostTitle(postTitle);
		
		log.info("Search Post - Step 12: Verify Post Title Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedWithPostTitle(postTitle));
		
		log.info("Search Post - Step 13: Verify Post Body Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostBody(postTitle, postBody));
		
		log.info("Search Post - Step 14: Verify Post Author Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostAuthor(postTitle, author));
		
		log.info("Search Post - Step 15: Verify Post CurrentDay Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostCurrentDay(postTitle, currentDay));
	}
	
	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit Post - Step 01: Open Admin user site");
		adminDashboard = userPostDetail.openAdminUserSite(driver, adminUrl);
		
		log.info("Edit Post - Step 02: Click to 'Post' menu link");
		adminPostSearch = adminDashboard.clickToMenuLink();
		
		log.info("Edit Post - Step 03: Enter search post");
		adminPostSearch.enterToSearchTextBox(postTitle);
		
		log.info("Edit Post - Step 04: Click 'Search Posts' button");
		adminPostSearch.clickToSearchPostButton();
		
		log.info("Edit Post - Step 05: Click Post Title link and navigate to Edit Post page");
		adminPostAddNew = adminPostSearch.clickToPostTitleLink(postTitle);
		
		log.info("Edit Post - Step 06: Switch to Post content");
		adminPostAddNew.switchToPostContent();
		
		log.info("Edit Post - Step 07: Enter to post title");
		adminPostAddNew.enterToPostTitle(editTitle);
		
		log.info("Edit Post - Step 08: Enter to post title body");
		adminPostAddNew.enterEditToPostBody(editBody);		
				
		log.info("Edit Post - Step 09: Switch out Post content");
		adminPostAddNew.switchOutPostContent();
		
		log.info("Edit Post - Step 10: Click to 'Update' button");
		adminPostAddNew.clickToPublishOrUpdateButton();
		
		log.info("Edit Post - Step 11: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNew.isPostPublishOrUpdatedMessageDisplayed("Post updated."));
		
		log.info("Edit Post - Step 12: Open 'Search post' page");
		adminPostSearch = adminPostAddNew.openSearchPostPage(searchPostURL);
		
		log.info("Edit Post - Step 13: Enter search post");
		adminPostSearch.enterToSearchTextBox(editTitle);
		
		log.info("Edit Post - Step 14: Click 'Search Posts' button");
		adminPostSearch.clickToSearchPostButton();
		
		log.info("Edit Post - Step 15: Verify search table contains " + editTitle);
		verifyTrue(adminPostSearch.isPostSearchTableDisplayed("Title", editTitle));
		
		log.info("Edit Post - Step 16: Verify search table contains " + author);
		verifyTrue(adminPostSearch.isPostSearchTableDisplayed("Author", author));
		
		log.info("Edit Post - Step 17: Open End User site");
		userHome = adminPostSearch.openEndUserSite(driver, endUserUrl);
		
		log.info("Edit Post - Step 18: Veirfy post Title infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedWithPostTitle(editTitle));
		
		log.info("Edit Post - Step 19: Veirfy post Body infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostBody(editTitle, editBody));
		
		log.info("Edit Post - Step 20: Veirfy post Author infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostAuthor(editTitle, author));
		
		log.info("Edit Post - Step 21: Veirfy post CurrentDay infor displayed at Home Page");
		verifyTrue(userHome.isPostSearchInforDisplayedithPostCurrentDay(editTitle, currentDay));
		
		log.info("Edit Post - Step 22: Click to Post Title");
		userPostDetail = userHome.clickToPostTitle(editTitle);
		
		log.info("Edit Post - Step 23: Verify Post Title Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedWithPostTitle(editTitle));
		
		log.info("Edit Post - Step 24: Verify Post Body Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostBody(editTitle, editBody));
		
		log.info("Edit Post - Step 25: Verify Post Author Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostAuthor(editTitle, author));
		
		log.info("Edit Post - Step 26: Verify Post CurrentDay Infor displayed at Post detail page");
		verifyTrue(userPostDetail.isPostSearchInforDisplayedithPostCurrentDay(editTitle, currentDay));
	}
	
	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete Post - Step 01: Open Admin user site");
		adminDashboard = userPostDetail.openAdminUserSite(driver, adminUrl);
		
		log.info("Delete Post - Step 02: Click to 'Post' menu link");
		adminPostSearch = adminDashboard.clickToMenuLink();
		
		log.info("Delete Post - Step 03: Enter search post");
		adminPostSearch.enterToSearchTextBox(editTitle);
		
		log.info("Delete Post - Step 04: Click 'Search Posts' button");
		adminPostSearch.clickToSearchPostButton();
		
		log.info("Delete Post - Step 05: Select Post detail checkbox");
		adminPostSearch.selectPostCheckByTitle(editTitle);
		
		log.info("Delete Post - Step 06: Select action 'Move to Trash'");
		adminPostSearch.selectTextItemInActionDropdown("Move to Trash");
		
		log.info("Delete Post - Step 07: Click to 'Apply' button");
		adminPostSearch.clickToApplyButton();
		
		log.info("Delete Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearch.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));
		
		log.info("Delete Post - Step 09: Enter search post");
		adminPostSearch.enterToSearchTextBox(editTitle);
		
		log.info("Delete Post - Step 10: Click 'Search Posts' button");
		adminPostSearch.clickToSearchPostButton();
		
		log.info("Delete Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearch.isNoPostFoundMessageDisplayed("No posts found."));
		
		log.info("Delete Post - Step 12: Open End User site");
		userHome = adminPostSearch.openEndUserSite(driver, endUserUrl);
		
		log.info("Delete Post - Step 13: Verify Post title undisplayed at Home page");
		verifyTrue(userHome.isPostSearchInforUndisplayedWithPostTitle(editTitle));
		
		log.info("Delete Post - Step 14: Enter to Search textbox");
		userHome.enterToSearchTextBox(editTitle);
		
		log.info("Delete Post - Step 15: Click to Search button");
		userPostSearch = userHome.clickToSearchButton();
		
		log.info("Delete Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userPostSearch.isNothingFoundMessageDisplayed("Nothing Found"));
	}
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	AdminLoginPageObject adminLoginPO;
	AdminDashboardPageObject adminDashboard;
	AdminPostSearchPageObject adminPostSearch;
	AdminPostAddNewPageObject adminPostAddNew;
	UserHomePO userHome;
	UserPostDetailPageObject userPostDetail;
	UserPostSearchPageObject userPostSearch;
}
