package com.nopcommerce.user.livecoding;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCategoriesPageObject;

public class LiveCoding_nopcommerce_Sort_Display_Paging_TestCase extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		//Preconditions
		log.info("Preconditions - Step 01: Select menu computers");
		userHomePage.selectHeaderMenu("Computers");
		
		log.info("Preconditions - Step 02: Select category Notebooks");
		categoryPage = PageGeneratorManager.getUserCategoriesPage(driver);
		categoryPage.selectCategories("Notebooks");
	}

	@Test
	public void Sort_01_Sort_With_Name_AtoZ_Asc() {
		log.info("Categories Page - Step 01: Select sorting categories Name A to Z");
		categoryPage.selectToDropdownByName(driver, "products-orderby", "Name: A to Z");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify the product name is sorted correctly");
		Assert.assertTrue(categoryPage.verifyProductNameSortAtoZAsc());
	}
	
	@Test
	public void Sort_02_Sort_With_Name_ZtoA_Desc() {
		log.info("Categories Page - Step 01: Select sorting categories Name Z to A");
		categoryPage.selectToDropdownByName(driver, "products-orderby", "Name: Z to A");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify the product name is sorted correctly");
		Assert.assertTrue(categoryPage.verifyProductNameSortZtoADesc());
	}
	
	@Test
	public void Sort_03_Sort_With_Price_LowToHigh() {
		log.info("Categories Page - Step 01: Select sorting categories Price Low to High");
		categoryPage.selectToDropdownByName(driver, "products-orderby", "Price: Low to High");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify the product price is sorted correctly");
		Assert.assertTrue(categoryPage.verifyProductPriceSortAtoZAsc());
	}
	
	@Test
	public void Sort_04_Sort_With_Price_HighToLow() {
		log.info("Categories Page - Step 01: Select sorting categories Price High to Low");
		categoryPage.selectToDropdownByName(driver, "products-orderby", "Price: High to Low");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify the product price is sorted correctly");
		Assert.assertTrue(categoryPage.verifyProductPriceSortZtoADesc());
	}
	
	@Test
	public void Sort_05_Displayed_3_Products_per_page() {
		log.info("Categories Page - Step 01: Select dropdown list Display");
		categoryPage.selectToDropdownByName(driver, "products-pagesize", "3");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify have 3 products is displayed");
		Assert.assertTrue(categoryPage.verifyThePageShowTotalProductsEqualTo(3));
		
		log.info("Categories Page - Step 03: Verify next paging icon is displayed");
		Assert.assertTrue(categoryPage.verifyNextPagingIconDisplayed());
		
		log.info("Categories Page - Step 04: Verify previous paging icon Undisplayed");
		Assert.assertTrue(categoryPage.verifyPreviousPagingIconUndisplayed());
		
		log.info("Categories Page - Step 05: Click next paging icon");
		categoryPage.clickNextPagingIcon();
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 06: Verify previous paging icon displayed");
		Assert.assertTrue(categoryPage.verifyPreviousPagingIconDisplayed());
		
		log.info("Categories Page - Step 07: Verify next paging icon is Undisplayed");
		Assert.assertTrue(categoryPage.verifyNextPagingIconUndisplayed());
	}
	
	@Test
	public void Sort_06_6_Products_per_page() {
		log.info("Categories Page - Step 01: Select dropdown list Display");
		categoryPage.selectToDropdownByName(driver, "products-pagesize", "6");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify have 6 products is displayed");
		Assert.assertTrue(categoryPage.verifyThePageShowTotalProductsEqualTo(6));
		
		log.info("Categories Page - Step 03: Verify undisplayed paging");
		Assert.assertTrue(categoryPage.verifyPagingUndisplatyed());
	}
	
	@Test
	public void Sort_07_9_Products_per_page() {
		log.info("Categories Page - Step 01: Select dropdown list Display");
		categoryPage.selectToDropdownByName(driver, "products-pagesize", "9");
		categoryPage.sleepInSecond(3);
		
		log.info("Categories Page - Step 02: Verify have 9 products is displayed");
		Assert.assertTrue(categoryPage.verifyThePageShowTotalProductsEqualTo(9));
		
		log.info("Categories Page - Step 03: Verify undisplayed paging");
		Assert.assertTrue(categoryPage.verifyPagingUndisplatyed());
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserCategoriesPageObject categoryPage;
}
