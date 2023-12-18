package com.nopcommerce.clouldtesting;

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

public class LiveCoding_nop_Login_SourceLap extends BaseTest{
	@Parameters({"browser", "url", "osName"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl, String osName) {
		driver = getBrowserDriverSauceLab(browserName, appUrl, osName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		invalidEmail = "testEmail" + fakeNumber() + "@@gmail.vn";
		emailNotFound = "testEmail" + fakeNumber() + "@gmail.vn";;
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		incorrectPassword= "012345";
		
		//Preconditions
		log.info("Preconditions - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Preconditions - Step 02: Register new User account");
		
		registerPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		log.info("Preconditions - Step 03: Navigate to Login page");
		loginPage = homePage.openLoginPage();
	}

	@Test
	public void Login_01_Login_With_EmptyData() {
		log.info("Login - Step 01: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 02: Verify email error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Login_With_InvalidEmail() {
		log.info("Login - Step 01: Input Invalid Email");
		loginPage.inputEmailTextBox(invalidEmail);
		
		log.info("Login - Step 02: Input Password");
		loginPage.inputPasswordTextbox(validPassword);
		
		log.info("Login - Step 03: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify email error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Login_With_Email_Not_Register() {
		log.info("Login - Step 01: Input Invalid Email");
		loginPage.inputEmailTextBox(emailNotFound);
		
		log.info("Login - Step 02: Input Password");
		loginPage.inputPasswordTextbox(validPassword);
		
		log.info("Login - Step 03: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify login unsuccessful message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Login_With_Email_Register_Password_Empty() {
		log.info("Login - Step 01: Input Email");
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login - Step 02: Input empty Password");
		loginPage.inputPasswordTextbox("");
		
		log.info("Login - Step 03: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify login unsuccessful message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Login_With_Email_Register_Password_Invalid() {
		log.info("Login - Step 01: Input Email");
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login - Step 02: Input incorrect Password");
		loginPage.inputPasswordTextbox(incorrectPassword);
		
		log.info("Login - Step 03: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify login unsuccessful message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Login_With_Email_Register_Password_Valid() {
		log.info("Login - Step 01: Input Email");
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login - Step 02: Input Password");
		loginPage.inputPasswordTextbox(validPassword);
		
		log.info("Login - Step 03: Click Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify My account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 05: Click to My account link");
		homePage.clickToMyAccountLink();
	}
	
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, invalidEmail, emailNotFound, validPassword, incorrectPassword;
	private String firstName, lastName;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
}
