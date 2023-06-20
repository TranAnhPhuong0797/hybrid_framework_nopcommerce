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
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_06_Page_Generator_Manage_I extends BaseTest{
	private WebDriver driver;
	private String emailAddress, invalidEmail, emailNotFound, firstname, lastname, validPassword, incorrectPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		loginPage = new UserLoginPageObject(driver);
		
		firstname = "Nguyen";
		lastname = "Van A";
		validPassword = "199000";
		incorrectPassword = "123456";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
		invalidEmail = "anonymous@@gmail.com";
		emailNotFound = "anonymous@gmail.com";
		
		//Preconditions
		System.out.println("Preconditions - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Preconditions - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		
		System.out.println("Preconditions - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Preconditions - Step 4: Verify registration success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Preconditions - Step 5: Click to Register link");
		homePage.clickToRegisterLink();
	}

	@Test
	public void Login_01_Login_With_EmptyData() {
		System.out.println("TC-01 - Step 1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("TC-01 - Step 2: Click to login button");
		loginPage.clickLoginButton();
		
		System.out.println("TC-01 - Step 3: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Login_With_InvalidEmail() {
		System.out.println("TC-02 - Step 1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("TC-02 - Step 2: Input invalid email");
		loginPage.inputEmailTextBox(invalidEmail);
		
		System.out.println("TC-02 - Step 3: Click to login button");
		loginPage.clickLoginButton();
		
		System.out.println("TC-02 - Step 4: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Login_With_Email_Not_Register() {
		System.out.println("TC-03 - Step 1: Click to login link");
		homePage.openLoginPage();	
		
		System.out.println("TC-03 - Step 2: Input email not found");
		loginPage.inputEmailTextBox(emailNotFound);
		
		System.out.println("TC-03 - Step 3: Click to login button");
		loginPage.clickLoginButton();
		
		System.out.println("TC-03 - Step 4: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Login_With_Email_Register_Password_Empty() {
		System.out.println("TC-04 - Step 1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("TC-04 - Step 2: Input email");
		loginPage.inputEmailTextBox(emailAddress);
		
		
		System.out.println("TC-04 - Step 2: Input empty password");
		loginPage.inputPasswordTextbox("");
		
		System.out.println("TC-04 - Step 3: Click to login button");
		loginPage.clickLoginButton();
		
		System.out.println("TC-04 - Step 4: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Login_With_Email_Register_Password_Invalid() {
		System.out.println("TC-05 - Step 1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("TC-05 - Step 2: Input email");
		loginPage.inputEmailTextBox(emailAddress);
		
		System.out.println("TC-05 - Step 3: Input invalid password");
		loginPage.inputPasswordTextbox(incorrectPassword);

		System.out.println("TC-05 - Step 4: Click to login button");
		loginPage.clickLoginButton();
		
		System.out.println("TC-05 - Step 5: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Login_With_Email_Register_Password_Valid() {
		System.out.println("TC-06 - Step 1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("TC-06 - Step 2: Input email");
		loginPage.inputEmailTextBox(emailAddress);
		
		System.out.println("TC-06 - Step 3: Input password");
		loginPage.inputPasswordTextbox(validPassword);
		
		System.out.println("TC-06 - Step 4: Click to login button");
		loginPage.clickLoginButton();
		
		
		homePage = new UserHomePageObject(driver);
		
		System.out.println("TC-06 - Step 5: Verify login success");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
