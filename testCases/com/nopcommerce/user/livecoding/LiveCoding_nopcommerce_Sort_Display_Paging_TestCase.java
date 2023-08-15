package com.nopcommerce.user.livecoding;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCategoriesPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;

public class LiveCoding_nopcommerce_Sort_Display_Paging_TestCase extends BaseTest{
	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCategoriesPageObject categoryPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		
		//Preconditions
		log.info("Preconditions - Step 01: Navigate to Register Page");
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		log.info("Preconditions - Step 02: Register new User account");
		userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		log.info("Preconditions - Step 03: Navigate to Login page");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("Preconditions - Step 04: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		
		log.info("Preconditions - Step 05: Select menu computers");
		userHomePage.selectHeaderMenu("Computers");
		
		log.info("Preconditions - Step 06: Select category Notebooks");
		categoryPage = PageGeneratorManager.getUserCategoriesPage(driver);
		categoryPage.selectCategories("Notebooks");
	}

	@Test
	public void Sort_01_Sort_With_Name_AtoZ() {
		log.info("Categories Page - Step 01: Select sorting categories Name A to Z");
		categoryPage.selectToDropdownByName(driver, "products-orderby", "Name: A to Z");
		
		log.info("Categories Page - Step 02: Verify the product name is sorted correctly");
		categoryPage.verifyProductNameSortAtoZ();
	}
	
	@Test
	public void Sort_02_Sort_With_Name_ZtoA() {
		log.info("Categories Page - Step 01: Select sorting categories Name Z to A");
		
	}
	
	@Test
	public void Sort_03_Sort_With_Price_LowToHigh() {
		log.info("Categories Page - Step 01: Select sorting categories Price Low to High");
		
	}
	
	@Test
	public void Sort_04_Sort_With_Price_HighToLow() {
		log.info("Categories Page - Step 01: Select sorting categories Price High to Low");
		
	}
	
	@Test
	public void Sort_05_() {
		log.info("Search Page - Step 01: Input value in Search textbox");
		
	}
	
	@Test
	public void Sort_06_() {
		log.info("Search Page - Step 01: Input value in Search textbox");
		
	}
	
	@Test
	public void Sort_07_() {
		log.info("Search Page - Step 01: Input value in Search textbox");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
