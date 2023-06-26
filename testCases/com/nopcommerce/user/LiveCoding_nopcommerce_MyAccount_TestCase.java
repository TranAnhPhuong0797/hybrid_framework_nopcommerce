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
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_MyAccount_TestCase extends BaseTest{
	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName, companyName, gender, days, months, years;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject customerInforPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		companyName = "Automate Company";
		gender = "Female";
		
		//Preconditions
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage = userHomePage.openLoginPage();
		
		//Login as User
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
	}

	@Test
	public void MyAccount_01_CustomerInfor() {
		customerInforPage = userHomePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
		
		customerInforPage.selectGender(gender);
		customerInforPage.inputFirstName(firstName);
		customerInforPage.inputLastName(lastName);
		customerInforPage.inputEmailAddress(emailAddress);
		customerInforPage.inputCompanyName(companyName);
		
//		customerInforPage.selectDays(days);
//		customerInforPage.selectMonths(months);
//		customerInforPage.selectYears(years);
		
	}
	
	@Test
	public void MyAccount_02_Address() {
		
	}
	
	@Test
	public void MyAccount_03_ChangePassword() {
		
	}
	
	@Test
	public void MyAccount_04_MyProduct_Reviews() {
		
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
