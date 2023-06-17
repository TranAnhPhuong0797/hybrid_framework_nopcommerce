package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.LoginPageObject;
import pageObject.liveguru.RegisterPageObject;


public class Level_06_Page_Generator_Manage_III extends BaseTest{
	private WebDriver driver;
	
	private HomePageObject hompage;
	private LoginPageObject loginpage;
	private RegisterPageObject registerpage;
	String firstName, lastName, email, password;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		firstName = "Automation";
		lastName = "Test User";
		email = "Automation" + fakeNumber() + "@gmail.com";
		password = "123567@Automation";
	}

	@Test
	public void TC01_CreateNewAccount() {
		System.out.println("TC-01 - Step 1: Click to Account button");
		hompage.clickToMyAccountButton();
		
		System.out.println("TC-01 - Step 2: Select My account option");
		loginpage = hompage.clickToMyAccountOption();
		
		System.out.println("TC-01 - Step 3: Click button Create an Account");
		registerpage = loginpage.clickToCreateAnAccountButton();
		
		System.out.println("TC-01 - Step 4: Input to required fields");
		registerpage.inputToFirstNameTextBox(firstName);
		registerpage.inputToLastNameTextBox(lastName);
		registerpage.inputToEmailTextBox(email);
		registerpage.inputToPasswordTextBox(password);
		registerpage.inputToConfirmPasswordTextBox("123567@Automation");
		
		System.out.println("TC-01 - Step 5: Click to Register");
		registerpage.clickToRegisterButton();
		
		System.out.println("TC-01 - Step 6: Verify register success");
		Assert.assertEquals(registerpage.getRegisterSuccessMessage(), "");
	}
	
//	@Test
//	public void Login_02_Login_With_InvalidEmail() {
//		
//	}
//	
//	@Test
//	public void Login_03_Login_With_Email_Not_Register() {
//		
//	}
//	
//	@Test
//	public void Login_04_Login_With_Email_Register_Password_Empty() {
//		
//	}
//	
//	@Test
//	public void Login_05_Login_With_Email_Register_Password_Invalid() {
//		
//	}
//	
//	@Test
//	public void Login_06_Login_With_Email_Register_Password_Valid() {
//		
//		
//	}
	
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
