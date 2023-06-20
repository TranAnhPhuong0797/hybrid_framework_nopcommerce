package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.AddressPageObject;
import pageObject.nopcommerce.portal.BackInStockSubscriptionsPageObject;
import pageObject.nopcommerce.portal.ChangePasswordPageObject;
import pageObject.nopcommerce.portal.CustomerInforPageObject;
import pageObject.nopcommerce.portal.DownloadProductsPageObject;
import pageObject.nopcommerce.portal.HomePageObject;
import pageObject.nopcommerce.portal.LoginPageObject;
import pageObject.nopcommerce.portal.MyProductReviewPageObject;
import pageObject.nopcommerce.portal.OrderPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.RegisterPageObject;
import pageObject.nopcommerce.portal.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String emailAddress, firstname, lastname, validPassword;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInforPageObject customerInforPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private DownloadProductsPageObject downloadProductsPage;
	private BackInStockSubscriptionsPageObject backInStockSubscriptionsPage;
	private RewardPointPageObject rewardPointPage;
	private ChangePasswordPageObject changePasswordPage;
	private MyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

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
		//
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

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
