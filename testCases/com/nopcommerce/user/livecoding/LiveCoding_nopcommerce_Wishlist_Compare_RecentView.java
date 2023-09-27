package com.nopcommerce.user.livecoding;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_Wishlist_Compare_RecentView extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		
		//Preconditions
		log.info("Preconditions - Step 01: Navigate to Register Page");
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		log.info("Preconditions - Step 02: Register new User account");
		userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		log.info("Preconditions - Step 03: Navigate to Login page");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("Preconditions - Step 04: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		
		log.info("Preconditions - Step 05: Select any product in Home Page");
		userHomePage.selectProductInSectionFeaturedProducts("Build your own computer");
	}
	
	@Test
	public void Wishlist_01_() {
		log.info("Detail Product Page - Step 01: Click Add to Wishlist");
		
	}
	
	@Test
	public void Wishlist_02_() {
		
	}
	
	@Test
	public void Wishlist_03_() {
		
	}
	
	@Test
	public void Wishlist_04_() {
		
	}
	
	@Test
	public void Wishlist_05_() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
}
