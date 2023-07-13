package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_15_ReportNG_Screenshot extends BaseTest{
	private WebDriver driver;
	private String emailAddress, firstname, lastname, password;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		customerPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		firstname = "Nguyen";
		lastname = "Van A";
		password = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
	}

	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Input values to field 'FirstName' with value is " + firstname);
		registerPage.inputToFirstNameTextBox(firstname);
		
		log.info("Register - Step 03: Input values to field 'LastName' with value is " + lastname);
		registerPage.inputToLastNameTextBox(lastname);
		
		log.info("Register - Step 04: Input values to field 'Email' with value is " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		
		log.info("Register - Step 05: Input values to field 'Password' with value is " + password);
		registerPage.inputToPasswordTextBox(password);
		
		log.info("Register - Step 06: Input values to field 'Confirm Password' with value is " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		log.info("Register - Step 07: Click to 'Registor' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 02: Input values to field 'Email' with value is " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login - Step 03: Input values to field 'Password' with value is " + password);
		loginPage.inputPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' button");
		homePage = loginPage.clickLoginButton();
		
		log.info("Login - Step 05: Vertify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Navigate to My Account Page");
		customerPage = homePage.openCustomerInforPage(driver);
		
		log.info("Login - Step 05: Vertify 'Customer Infor' Page is displayed");
		Assert.assertFalse(customerPage.isMyAccountPageDisplayed());
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
