package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.data.UserDataMapper;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_20_Fake_Data_III extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		customerPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		userDataMapper = UserDataMapper.getUserData();

	}

	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Male");
		
		log.info("Register - Step 02: Input values to field 'FirstName' with value is " + userDataMapper.getFirstName());
		registerPage.inputToTextboxByID(driver, "FirstName", userDataMapper.getFirstName());
		
		log.info("Register - Step 03: Input values to field 'LastName' with value is " + userDataMapper.getLastName());
		registerPage.inputToTextboxByID(driver, "LastName", userDataMapper.getLastName());
		
		log.info("Register - Step 04: Input values to field 'Email' with value is " + userDataMapper.getEmailAddress());
		registerPage.inputToTextboxByID(driver, "Email", userDataMapper.getEmailAddress());
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + userDataMapper.getDate());
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", userDataMapper.getDate());
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + userDataMapper.getMonth());
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", userDataMapper.getMonth());
		
		log.info("Register - Step 04: Select values to field 'Date of birth' with value is " + userDataMapper.getYear());
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", userDataMapper.getYear());
		
		log.info("Register - Step 05: Input values to field 'Password' with value is " + userDataMapper.getPassword());
		registerPage.inputToTextboxByID(driver, "Password",  userDataMapper.getPassword());
		
		log.info("Register - Step 06: Input values to field 'Confirm Password' with value is " +  userDataMapper.getPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword",  userDataMapper.getPassword());
		
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
		
		log.info("Login - Step 02: Input values to field 'Email' with value is " + userDataMapper.getEmailAddress());
		loginPage.inputToTextboxByID(driver, "Email", userDataMapper.getEmailAddress());
		
		log.info("Login - Step 03: Input values to field 'Password' with value is " + userDataMapper.getPassword());
		loginPage.inputToTextboxByID(driver, "Password", userDataMapper.getPassword());
		
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
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerPage;
	UserDataMapper userDataMapper;
}
