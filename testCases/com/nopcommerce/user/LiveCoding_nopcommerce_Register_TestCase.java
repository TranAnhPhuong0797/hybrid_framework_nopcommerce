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
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_Register_TestCase extends BaseTest{
	private WebDriver driver;
	private String emailAddress, invalidEmail, firstname, lastname, validPassword, incorrectPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstname = "Tony";
		lastname = "Teo";
		invalidEmail = "testEmail" + fakeNumber() + "@@gmail.vn";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
		validPassword = "123789";
		incorrectPassword = "1234";
		
		registerPage = homePage.clickToRegisterLink();
		
	}

	@Test
	public void Register_01_With_EmptyData() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}
	
	@Test
	public void Register_02_With_InvalidEmail() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		registerPage.inputToEmailTextBox(invalidEmail);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}
			
	@Test
	public void Register_03_With_Valid_Infor() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clicktoContinueButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage.clickToRegisterLink();
	}
	
	@Test
	public void Register_04_With_Email_Aldready_Exists() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_With_Password_LessThan_6Chars() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		
//		registerPage.inputToFirstNameTextBox(firstname);
//		registerPage.inputToLastNameTextBox(lastname);
//		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(incorrectPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void  Register_06_With_ConfirmPassword_NotCorrect() {
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox("012345");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");
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
