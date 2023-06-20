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
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class Level_04_Multiple_Browsers_Register extends BaseTest {
	private WebDriver driverTestClass;
	private String emailAddress, firstname, lastname, password;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserName(browserName);
		
		homePage = new UserHomePageObject(driverTestClass);
		registerPage = new UserRegisterPageObject(driverTestClass);

		firstname = "Nguyen";
		lastname = "Van A";
		password = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
	}

	@Test
	public void Registor_01_Registor_With_EmptyData() {
		System.out.println("Registor_01 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_01 - Step 2: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_01 - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}

	@Test
	public void Registor_02_Registor_With_InvalidEmail() {
		System.out.println("Registor_02 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_02 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox("8801233");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox("190000");

		System.out.println("Registor_02 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_02 - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Registor_03_Registor_With_Password_LessThan_6Char() {
		System.out.println("Registor_03 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_03 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("1990");

		System.out.println("Registor_03 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_03 - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");
	}

	@Test
	public void Registor_04_Registor_With_ConfirmPassword_NotCorrect() {
		System.out.println("Registor_04 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_04 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox("190000");

		System.out.println("Registor_04 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_04 - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Registor_05_Registor_With_ValidData() {
		System.out.println("Registor_05 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_05 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Registor_05 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_05 - Step 4: Verify registration success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Registor_05 - Step 5: Click to Register link");
		homePage.clickToRegisterLink();
	}

	@Test
	public void Registor_06_Registor_With_Email_Exist() {
		System.out.println("Registor_06 - Step 1: Click to register Link");
		homePage.clickToRegisterLink();

		System.out.println("Registor_06 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Registor_06 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Registor_06 - Step 4: Verify error exist email message displayed ");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}

}
