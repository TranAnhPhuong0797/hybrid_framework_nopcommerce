package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.admin.AdminDashboardPageObject;
import pageObject.nopcommerce.admin.AdminLoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;


public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String emailAddress, validPassword, adminEmailAddress, adminPassword;

	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInforPageObject	userCustomerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		validPassword = "199000";
		emailAddress = "marvelDCcommic@gmail.com";
		
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void User_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		
		//Login as User
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		// After login: Home page => Customer page
		userCustomerInforPage = userHomePage.openCustomerInforPage(driver);
		
		//After logout: Customer page => Home page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
		
		
		userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		//Login as Admin
		adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void User_02_Admin_To_User() {
		adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
