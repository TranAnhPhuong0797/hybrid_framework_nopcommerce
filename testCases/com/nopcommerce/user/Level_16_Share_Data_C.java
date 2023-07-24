package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.com.common_01_Register_Cookie;


import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;


public class Level_16_Share_Data_C extends BaseTest{
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Precondition - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		
		log.info("Precondition - Step 02: Set Cookie and reload");
		loginPage.setCookie(driver, common_01_Register_Cookie.loggedCookie);
		for (Cookie cookie : common_01_Register_Cookie.loggedCookie) {
			System.out.println("Cookie at 16C class: " + cookie);
		}
		
		loginPage.refreshToPage(driver);
		
		log.info("Precondition - Step 03: Verify 'My account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Search_By_Empty() {
		 System.out.println("Search_By_Name");
	}
	
	@Test
	public void Search_By_Name() {
		System.out.println("Search_By_Company");
	}
	
	@Test
	public void Search_By_Category() {
		System.out.println("Search_By_Gender");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
