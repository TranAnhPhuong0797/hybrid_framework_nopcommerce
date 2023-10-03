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
import utilities.DataHelper;

public class Level_20_Fake_Data_I extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		dataHelper = DataHelper.getDataHelper();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		customerPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		firstname = dataHelper.getFirstName();
		lastname = dataHelper.getLastName();
		password = dataHelper.getPhoneNumber();
		emailAddress = dataHelper.getEmailAddress();
		days = "30";
		month = "June";
		year = "1997";
	}

	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Male");
		
		log.info("Register - Step 02: Input values to field 'FirstName' with value is " + firstname);
		registerPage.inputToTextboxByID(driver, "FirstName", firstname);
		
		log.info("Register - Step 03: Input values to field 'LastName' with value is " + lastname);
		registerPage.inputToTextboxByID(driver, "LastName", lastname);
		
		log.info("Register - Step 04: Input values to field 'Email' with value is " + emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + days);
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", days);
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + month);
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", month);
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + year);
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", year);
		
		log.info("Register - Step 05: Input values to field 'Password' with value is " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Register - Step 06: Input values to field 'Confirm Password' with value is " + password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Register - Step 07: Click to 'Registor' button");
		registerPage.clicktoButtonByText(driver, "Register");
		
		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
//		log.info("Register - Step 09: Click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 02: Input values to field 'Email' with value is " + emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 03: Input values to field 'Password' with value is " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Login - Step 04: Click to 'Login' button");
		loginPage.clicktoButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: Vertify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Click 'My Account' link");
		homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Navigate to My Account Page");
		customerPage = homePage.openCustomerInforPage(driver);
		
		log.info("Login - Step 08: Vertify 'Customer Infor' Page is displayed");
		Assert.assertTrue(customerPage.isMyAccountPageDisplayed());
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
	private String emailAddress, firstname, lastname, password, days, month, year;
	
	private DataHelper dataHelper;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerPage;
}
