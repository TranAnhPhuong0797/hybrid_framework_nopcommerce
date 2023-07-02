package com.nopcommerce.data;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQuery.HomePageObject;
import pageObjectjQuery.PageGeneratorManager;

public class DataTable_Grid extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("7"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("18"));
	}
	
	@Test
	public void Table_02_Search_To_Header() {
		homePage.refreshToPage(driver);
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		
		
		homePage.enterToHeaderTextboxByLabel("Females", "283821");
		homePage.enterToHeaderTextboxByLabel("Country", "Algeria");
		homePage.enterToHeaderTextboxByLabel("Males", "295140");
		homePage.enterToHeaderTextboxByLabel("Total", "578961");
		homePage.sleepInSecond(3);
	}
	
	@Test
	public void Table_03() {
		homePage.getValueEachRowAtAllPages();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
