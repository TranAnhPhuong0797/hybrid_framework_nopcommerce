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
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest{
	private WebDriver driver;
	private String emailAddress, firstname, lastname, password;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		firstname = "Nguyen";
		lastname = "Van A";
		password = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";

		log.info("Precondition - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		driver = null;
		
		log.info("Precondition - Step 02: Input values to field 'FirstName' with value is " + firstname);
		registerPage.inputToFirstNameTextBox(firstname);

		log.info("Precondition - Step 03: Input values to field 'LastName' with value is " + lastname);
		registerPage.inputToLastNameTextBox(lastname);
		
		log.info("Precondition - Step 04: Input values to field 'Email' with value is " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);

		log.info("Precondition - Step 05: Input values to field 'Password' with value is " + password);
		registerPage.inputToPasswordTextBox(password);

		log.info("Precondition - Step 06: Input values to field 'Confirm Password' with value is " + password);
		registerPage.inputToConfirmPasswordTextBox(password);

		log.info("Precondition - Step 07: Click to 'Registor' button");
		registerPage.clickToRegisterButton();

		log.info("Precondition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed, .....");
		
		log.info("Precondition - Step 09: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		
		log.info("Precondition - Step 10: Input values to field 'Email' with value is " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Precondition - Step 11: Input values to field 'Password' with value is " + password);
		loginPage.inputPasswordTextbox(password);
		
		log.info("Precondition - Step 12: Click to 'Login' button");
		homePage = loginPage.clickLoginButton();
	}

	
	@Test
	public void Search_By_Product_Name() {
		
	}
	
	@Test
	public void Search_By_Address() {
		
	}
	
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
