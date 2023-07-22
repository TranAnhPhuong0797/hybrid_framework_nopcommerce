package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_15_Allure extends BaseTest{
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

	@Description("Register to System")
	@Severity (SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstname);
		
		registerPage.inputToLastNameTextBox(lastname);
		
		registerPage.inputToEmailTextBox(emailAddress);
		
		registerPage.inputToPasswordTextBox(password);
		
		registerPage.inputToConfirmPasswordTextBox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		//homePage = registerPage.clickToLogoutLink();
	}
	
	@Description("Login to System")
	@Severity (SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		
		loginPage = homePage.openLoginPage();
		
		loginPage.inputEmailTextBox(emailAddress);
		
		loginPage.inputPasswordTextbox(password);
		
		homePage = loginPage.clickLoginButton();
		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		customerPage = homePage.openCustomerInforPage(driver);
		
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
