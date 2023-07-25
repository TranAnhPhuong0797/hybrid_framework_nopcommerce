package com.nopcommerce.user.livecoding;

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

public class LiveCoding_nopcommerce_Login_TestCase extends BaseTest{
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
	public void Login_01_Login_With_EmptyData() {
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Login_With_InvalidEmail() {
		loginPage.inputEmailTextBox(invalidEmail);
		loginPage.inputPasswordTextbox(validPassword);
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Login_With_Email_Not_Register() {
		loginPage.inputEmailTextBox(emailNotFound);
		loginPage.inputPasswordTextbox(validPassword);
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Login_With_Email_Register_Password_Empty() {
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextbox("");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Login_With_Email_Register_Password_Invalid() {
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextbox(incorrectPassword);
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Login_With_Email_Register_Password_Valid() {
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextbox(validPassword);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
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

}
