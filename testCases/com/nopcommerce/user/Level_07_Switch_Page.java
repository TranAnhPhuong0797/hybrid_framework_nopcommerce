package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserAddressPageObject;
import pageObject.nopcommerce.portal.UserBackInStockSubscriptionsPageObject;
import pageObject.nopcommerce.portal.UserChangePasswordPageObject;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserDownloadProductsPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserMyProductReviewPageObject;
import pageObject.nopcommerce.portal.UserOrderPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String emailAddress, firstname, lastname, validPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserOrderPageObject orderPage;
	private UserDownloadProductsPageObject downloadProductsPage;
	private UserBackInStockSubscriptionsPageObject backInStockSubscriptionsPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstname = "Nguyen";
		lastname = "Van A";
		validPassword = "199000";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register() {
		System.out.println("TC-01 - Step 1: Click to register Link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("TC-01 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);

		System.out.println("TC-01 - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("TC-01 - Step 4: Verify registration success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("TC-01 - Step 5: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
	}

	@Test
	public void User_02_Login() {
		System.out.println("TC-02 - Step 1: Click to login link");
		loginPage = homePage.openLoginPage();

		System.out.println("TC-02 - Step 2: Input email");
		loginPage.inputEmailTextBox(emailAddress);

		System.out.println("TC-02 - Step 3: Input password");
		loginPage.inputPasswordTextbox(validPassword);

		System.out.println("TC-02 - Step 4: Click to login button");
		homePage = loginPage.clickLoginButton();

		System.out.println("TC-02 - Step 5: Verify login success");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Customer Infor => Address
		System.out.println("TC-04 - Step 1: Switch to page Address");
		addressPage = customerInforPage.openAddressPage(driver);

		// Address => My Product review
		System.out.println("TC-04 - Step 1: Switch to page My Product review");
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		// My Product review => Reward Point
		System.out.println("TC-04 - Step 1: Switch to page Reward Point");
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

		// Reward Point => Address
		System.out.println("TC-04 - Step 1: Switch to page address");
		addressPage = rewardPointPage.openAddressPage(driver);

		// Address => Order
		System.out.println("TC-04 - Step 1: Switch to Order Page");
		orderPage = addressPage.openOrderPage(driver);
		
		// Order => Download Product Page
		System.out.println("TC-04 - Step 1: Switch to Download Product Page");
		downloadProductsPage = orderPage.openDownloadPage(driver);
		
		// Download Product Page => Back In Stock Subscription Page
		backInStockSubscriptionsPage = downloadProductsPage.openBackInStockSubscriptionsPage(driver);
		
		// Back In Stock Subscription Page => Change Password Page
		changePasswordPage = backInStockSubscriptionsPage.openChangePasswordPage(driver);
		
		// Change Password Page => Customer Infor Page
		customerInforPage = changePasswordPage.openCustomerInforPage(driver);
	}
	
	@Test
	public void User_05_Switch_Dynamic_Page() {
		// use function openPagesAtMyAccountByName (in case the system only have 10-20 pages)
		rewardPointPage = (UserRewardPointPageObject) customerInforPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		// use function openPagesAtMyAccountByPageName (in case the system have more than 10-20 pages)
		changePasswordPage.openPagesAtMyAccountByPageName(driver, "Change password");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
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
