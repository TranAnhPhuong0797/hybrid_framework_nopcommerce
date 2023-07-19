//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import common.BaseTest;
//import pageObject.nopcommerce.portal.PageGeneratorManager;
//import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
//import pageObject.nopcommerce.portal.UserHomePageObject;
//import pageObject.nopcommerce.portal.UserLoginPageObject;
//import pageObject.nopcommerce.portal.UserRegisterPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_15_Extent_ScreenshotV2 extends BaseTest{
//	private WebDriver driver;
//	private String emailAddress, firstname, lastname, password;
//
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerPage;
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserName(browserName);
//		
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
//		loginPage = PageGeneratorManager.getUserLoginPage(driver);
//		customerPage = PageGeneratorManager.getUserCustomerInforPage(driver);
//		
//		firstname = "Nguyen";
//		lastname = "Van A";
//		password = "199000";
//		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
//	}
//
//	
//	@Test
//	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register Page");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Input values to field 'FirstName' with value is " + firstname);
//		registerPage.inputToFirstNameTextBox(firstname);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Input values to field 'LastName' with value is " + lastname);
//		registerPage.inputToLastNameTextBox(lastname);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Input values to field 'Email' with value is " + emailAddress);
//		registerPage.inputToEmailTextBox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Input values to field 'Password' with value is " + password);
//		registerPage.inputToPasswordTextBox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Input values to field 'Confirm Password' with value is " + password);
//		registerPage.inputToConfirmPasswordTextBox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Registor' button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
//		
//		ExtentManager.endTest();
//	}
//	
//	@Test
//	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login Page");
//		loginPage = homePage.openLoginPage();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Input values to field 'Email' with value is " + emailAddress);
//		loginPage.inputEmailTextBox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Input values to field 'Password' with value is " + password);
//		loginPage.inputPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button");
//		homePage = loginPage.clickLoginButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Vertify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to My Account Page");
//		customerPage = homePage.openCustomerInforPage(driver);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Vertify 'Customer Infor' Page is displayed");
//		Assert.assertFalse(customerPage.isMyAccountPageDisplayed());
//		
//		ExtentManager.endTest();
//	}
//	
//	
//	public int fakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(9999);
//	}
//	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//}
