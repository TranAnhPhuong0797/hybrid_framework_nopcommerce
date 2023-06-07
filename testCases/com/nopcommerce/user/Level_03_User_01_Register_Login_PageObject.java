package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Level_03_User_01_Register_Login_PageObject{
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	private String emailAddress;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Registor_With_EmptyData() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
			
		System.out.println("Register page - Step 2: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}
	
	@Test
	public void TC_02_Registor_With_InvalidEmail() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox("Nguyen");
		registerPage.inputToLastNameTextBox("Van A");
		registerPage.inputToEmailTextBox("8801233");
		registerPage.inputToPasswordTextBox("199000");
		registerPage.inputToConfirmPasswordTextBox("190000");
		
		System.out.println("Register page - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}
	
	@Test
	public void TC_03_Registor_With_Password_LessThan_6Char() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox("Nguyen");
		registerPage.inputToLastNameTextBox("Van A");
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("1990");		

		System.out.println("Register page - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\\n\" + \"must have at least 6 characters");
	}
	
	@Test
	public void TC_04_Registor_With_ConfirmPassword_NotCorrect() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox("Nguyen");
		registerPage.inputToLastNameTextBox("Van A");
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("199000");
		registerPage.inputToConfirmPasswordTextBox("190000");
		
		System.out.println("Register page - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 4: Verify error message displayed ");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");	
	}
	
	@Test
	public void TC_05_Registor_With_ValidData() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox("Nguyen");
		registerPage.inputToLastNameTextBox("Van A");
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("199000");
		registerPage.inputToConfirmPasswordTextBox("199000");
		
		System.out.println("Register page - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 4: Verify registration success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register page - Step 5: Click to Logout link");
		registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_06_Registor_With_Email_Exist() {
		System.out.println("Home page - Step 1: Click to register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox("Nguyen");
		registerPage.inputToLastNameTextBox("Van A");
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("199000");
		registerPage.inputToConfirmPasswordTextBox("199000");
		
		System.out.println("Register page - Step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 4: Verify error exist email message displayed ");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
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
