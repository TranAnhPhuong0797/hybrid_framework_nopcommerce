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
import pageObject.nopcommerce.portal.UserAddressPageObject;
import pageObject.nopcommerce.portal.UserCategoriesPageObject;
import pageObject.nopcommerce.portal.UserChangePasswordPageObject;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserDetailProductPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_MyAccount_TestCase extends BaseTest{
	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName, companyName, gender, days, months, years,country, stateProvince, city, address1, address2, zipcode, phoneNumber, faxNumber, newPassword;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserCategoriesPageObject categoryPage;
	private UserDetailProductPageObject detailProductPage;
	
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
		days = "01";
		months = "January";
		years = "1999";
		country = "Viet Nam";
		stateProvince = "Other";
		city = "Da Nang";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		zipcode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		newPassword = "654321";
		
		//Preconditions
		log.info("Preconditions - Step 01: Navigate to Register Page");
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		log.info("Preconditions - Step 02: Register new User account");
		userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		log.info("Preconditions - Step 03: Navigate to Login page");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("Preconditions - Step 04: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
	}

	@Test
	public void MyAccount_01_CustomerInfor() {
		log.info("My account - Step 01: Navigate to My account page");
		customerInforPage = userHomePage.clickToMyAccountLink();
		
		log.info("My account - Step 02: Verify My account page displayed");
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
		
		log.info("My account - Step 03: Select gender");
		customerInforPage.selectGender(gender);
		
		log.info("My account - Step 04: Input first name");
		customerInforPage.inputFirstName(firstName);
		
		log.info("My account - Step 05: Input last name");
		customerInforPage.inputLastName(lastName);
		
		log.info("My account - Step 04: Input email");
		customerInforPage.inputEmailAddress(emailAddress);
		
		log.info("My account - Step 05: Input company name");
		customerInforPage.inputCompanyName(companyName);
		
		log.info("My account - Step 06: Select day");
		customerInforPage.selectDays(days);

		log.info("My account - Step 07: Select month");
		customerInforPage.selectMonths(months);
		
		log.info("My account - Step 08: Select year");
		customerInforPage.selectYears(years);
		
		log.info("My account - Step 09: Click Save button");
		customerInforPage.clicktoButtonByText(driver, "Save");
	}
	
//	@Test
//	public void MyAccount_02_Address() {
//		log.info("My account - Step 01: Navigate to Address page");
//		addressPage = customerInforPage.openAddressPage(driver);
//		
//		log.info("My account - Step 02: Click Add New button");
//		addressPage.clicktoButtonByText(driver, "Add new");
//		
//		log.info("My account - Step 03: Input first name");
//		addressPage.inputToTextboxByText(driver, "First name", firstName);
//		
//		log.info("My account - Step 04: Input last name");
//		addressPage.inputToTextboxByText(driver, "Last name", lastName);
//		
//		log.info("My account - Step 05: Input email");
//		addressPage.inputToTextboxByText(driver, "Email", emailAddress);
//		
//		log.info("My account - Step 06: Input company");
//		addressPage.inputToTextboxByText(driver, "Company", companyName);
//		
//		log.info("My account - Step 07: Select country");
//		addressPage.selectCountryDropdownlist(country);
//		
//		log.info("My account - Step 08: Select state/province");
//		addressPage.selectStateProvinceDropdownlist(stateProvince);
//		
//		log.info("My account - Step 09: Input city");
//		addressPage.inputToTextboxByText(driver, "City", city);
//		
//		log.info("My account - Step 10: Input address 1");
//		addressPage.inputToTextboxByText(driver, "Address 1", address1);
//		
//		log.info("My account - Step 11: Input address 2");
//		addressPage.inputToTextboxByText(driver, "Address 2", address2);
//		
//		log.info("My account - Step 12: Input zip / portal code");
//		addressPage.inputToTextboxByText(driver, "Zip / postal code", zipcode);
//		
//		log.info("My account - Step 13: Input phone number");
//		addressPage.inputToTextboxByText(driver, "Phone number", phoneNumber);
//		
//		log.info("My account - Step 14: Input fax number");
//		addressPage.inputToTextboxByText(driver, "Fax number", faxNumber);
//		
//		log.info("My account - Step 15: Click Save button");
//		addressPage.clicktoButtonByText(driver, "Save");
//		
//		log.info("My account - Step 16: Veirfy message address added successfully");
//		addressPage.verifyNotificationAddressAddedSuccessfully("The new address has been added successfully.");
//	}
	
//	@Test
//	public void MyAccount_03_ChangePassword() {
//		log.info("My account - Step 01: Navigate to Chang Password page");
//		changePasswordPage = addressPage.openChangePasswordPage(driver);
//		
//		log.info("My account - Step 02: Input old password");
//		changePasswordPage.inputToTextboxByText(driver, "Old password", validPassword);
//		
//		log.info("My account - Step 03: Input new password");
//		changePasswordPage.inputToTextboxByText(driver, "New password", newPassword);
//		
//		log.info("My account - Step 04: Input confirm new password");
//		changePasswordPage.inputToTextboxByText(driver, "Confirm password", newPassword);
//		
//		log.info("My account - Step 05: Click Save button");
//		customerInforPage.clicktoButtonByText(driver, "Change password");
//		
//		log.info("My account - Step 06: Click logout link");
//		userHomePage = userRegisterPage.clickToLogoutLink();
//		
//		log.info("My account - Step 07: Click login link");
//		userLoginPage = userHomePage.openLoginPage();
//		
//		log.info("My account - Step 08: Login new User");
//		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
//		
//		log.info("My account - Step 09: Verify login unsuccessful message");
//		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
//		
//		log.info("My account - Step 10: Login new User");
//		userHomePage = userLoginPage.LoginAsUser(emailAddress, newPassword);
//		
//		log.info("My account - Step 11: Verify My account link displayed");
//		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
//	}
	
	@Test
	public void MyAccount_04_MyProduct_Reviews() {
		log.info("My account - Step 01: Back to Home Page");
		userHomePage.backToHomePage();
		
		log.info("My account - Step 02: Select menu computers");
		userHomePage.selectHeaderMenu("Computers");
		
		log.info("My account - Step 03: Select category Desktop");
		categoryPage.selectCategories("Desktops");
		
		log.info("My account - Step 04: Select product Build your own computer");
		categoryPage.selectProductTitle("Build your own computer");
		
		log.info("My account - Step 05: Click add review product");
		detailProductPage.clickAddYourReview();
		
		
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
