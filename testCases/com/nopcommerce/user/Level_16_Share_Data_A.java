package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.com.common_01_Register_New_Account;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;


public class Level_16_Share_Data_A extends BaseTest{
	private WebDriver driver;
	private String emailAddress, password;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		emailAddress = common_01_Register_New_Account.emailAddress;
		password = common_01_Register_New_Account.password;
		
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 02: Input values to field 'Email' with value is " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login - Step 03: Input values to field 'Password' with value is " + password);
		loginPage.inputPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' button");
		homePage = loginPage.clickLoginButton();
		
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
