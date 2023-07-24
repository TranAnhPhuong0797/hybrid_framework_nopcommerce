package com.nopcommerce.com;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class common_01_Register_Cookie extends BaseTest {
	WebDriver driver;
	public static String password, emailAddress;
	private String firstname, lastname;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookie;
	
	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Registor(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstname = "Nguyen";
		lastname = "Van A";
		password = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";

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

		loggedCookie = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookie) {
			System.out.println("Cookie at common class: " + cookie);
		}
//		log.info("Register - Step 09: Click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
	}
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
