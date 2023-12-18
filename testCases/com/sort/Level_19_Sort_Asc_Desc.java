package com.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import paggObjectSauceLabSort.LoginPageOb;
import paggObjectSauceLabSort.PageGeneratorManager;
import paggObjectSauceLabSort.ProductPageOb;

public class Level_19_Sort_Asc_Desc extends BaseTest{
	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String sauceLabUrl) {
		driver = getBrowserNameLocal(browserName, sauceLabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void Sort_01_name() {
		//Asc name
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		//Desc name
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}
	
	@Test
	public void Sort_02_price() {
		//Asc Price
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		
		//Desc Price
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	LoginPageOb loginPage;
	ProductPageOb productPage;
}
