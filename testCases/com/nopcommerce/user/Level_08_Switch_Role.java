package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObject.nopcommerce.portal.HomePageObject;
import pageObject.nopcommerce.portal.LoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;


public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String emailAddress, validPassword;

	private HomePageObject homePage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		validPassword = "199000";
		emailAddress = "marvelDCcommic@gmail.com";
	}

	@Test
	public void User_01_User() {
		loginPage = homePage.openLoginPage();
		homePage = loginPage.LoginAsUser(emailAddress, validPassword);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_02_Admin() {
		homePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
