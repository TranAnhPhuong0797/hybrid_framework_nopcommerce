package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_MyAccount_TestCase extends BaseTest{
	private WebDriver driver;
	private String emailAddress, invalidEmail, emailNotFound, validPassword, incorrectPassword;
	private String firstName, lastName;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		invalidEmail = "testEmail" + fakeNumber() + "@@gmail.vn";
		emailNotFound = "testEmail" + fakeNumber() + "@gmail.vn";;
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		incorrectPassword= "012345";
		
		//Preconditions
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		loginPage = homePage.openLoginPage();
	}

	@Test
	public void MyAccount_01_CustomerInfor() {
		
	}
	
	@Test
	public void MyAccount_02_Address() {
		
	}
	
	@Test
	public void MyAccount_03_ChangePassword() {
		
	}
	
	@Test
	public void MyAccount_04_MyProduct_Reviews() {
		
	}
	
	
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
