package com.workpress.admin.livecoding;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.workpress.admin.AdminDashboardPageObject;
import pageObject.workpress.admin.AdminLoginPageObject;
import pageObject.workpress.admin.AdminPostAddNewPageObject;
import pageObject.workpress.admin.AdminPostSearchPageObject;
import pageObject.workpress.admin.PageGeneratorManager;



public class Post_01_Create_Read_Update_Delete_Search extends BaseTest{
	String adminUserName = "phuongtran97";
	String adminPassword = "phuongtran97@";
	String searchPostURL;
	String postTitle = "Post" + fakeNumber() ;
	String postBody = "Live coding" + fakeNumber();
	
	@Parameters({"browser", "urlAdmin"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//Preconditions
		log.info("Preconditions - Step 01: Open browser and admin url");
		driver = getBrowserName(browserName, url);
		adminLoginPO = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Preconditions - Step 02: Enter username with value " + adminUserName);
		adminLoginPO.enterToUserNameTextbox(adminUserName);
			
		log.info("Preconditions - Step 02: Enter password with value" + adminPassword);
		adminLoginPO.enterToPasswordTextbox(adminPassword);
		
		log.info("Preconditions - Step 03: Click to 'login' button");
		adminLoginPO.clickTologinButton();
		
		adminDashboard = PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create Post - Step 01: Click to 'Post' menu link");
		adminDashboard.clickToMenuLink();
		
		log.info("Create Post - Step 02: Get page URL");
		searchPostURL = adminPostSearch.getPageURL(driver);
		
		log.info("Create Post - Step 03: Click to 'Add new' button");
		adminPostSearch.clickToAddNewButton();
		
		log.info("Create Post - Step 04: Enter to post title");
		adminPostAddNew.enterToPostTitle(postTitle);
		
		log.info("Create Post - Step 05: Enter to post title body");
		adminPostAddNew.enterToPostBody(postBody);
		
		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNew.clickToPublishButton();
		
		log.info("Create Post - Step 07: Verify 'Post Publish' message is displayed");
		verifyTrue(adminPostAddNew.isPostPublishMessageDisplayed("Post Publish."));
		
	}
	
	@Test
	public void Post_02_Search_Post() {
		log.info("Search Post - Step 01: Open 'Search post' page");
		adminPostAddNew.openSearchPostPage(searchPostURL);
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
}
