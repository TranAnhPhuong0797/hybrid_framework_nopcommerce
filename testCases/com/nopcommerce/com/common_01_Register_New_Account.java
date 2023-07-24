package com.nopcommerce.com;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class common_01_Register_New_Account extends BaseTest {
	WebDriver driver;
	public static String password, emailAddress;
	private String firstname, lastname;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Registor(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstname = "Nguyen";
		lastname = "Van A";
		password = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";

		log.info("Precondition - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();

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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		driver.quit();
//		log.info("Precondition - Step 09: Click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
