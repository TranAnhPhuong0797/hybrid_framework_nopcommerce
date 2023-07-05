package com.nopcommerce.data;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQuery.HomePageObject;
import pageObjectjQuery.PageGeneratorManager;

public class DataTable_Grid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
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
	public void Table_03_Enter_To_Header() {
		actualAllCountryValues = homePage.getValueEachRowAtAllPages();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@Test
	public void Table_04_Enter_To_TextBox_At_Any_Row() {
		homePage.clickToLoadButton();
		
		homePage.enterToTextboxByColumnNameAtRow("Company","1","Welch LLC");
		homePage.enterToTextboxByColumnNameAtRow("Contact Person","1","Leo");
		homePage.selectDropDownByColumnNameAtRowNumber("Country","1", "Hong Kong");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.clickToIconByRowNumber("3", "Move Down");
		
		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.clickToIconByRowNumber("6", "Remove Current Row");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
