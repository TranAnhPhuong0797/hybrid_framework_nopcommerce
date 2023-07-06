package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQueryUploadFile.HomePageObject;
import pageObjectjQueryUploadFile.PageGeneratorManager;


public class Upload_files extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private String oneFileName = "Vmodel.png";
	private String[] multipleFiles = {"waterfallModel.jpg", "ScrumProcess.jpg"};

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, oneFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(oneFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(oneFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(oneFileName));
	}

	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.uploadMultipleFiles(driver, multipleFiles);
		Assert.assertTrue(homePage.isFileLoadedByName("waterfallModel.jpg"));
		Assert.assertTrue(homePage.isFileLoadedByName("ScrumProcess.jpg"));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName("waterfallModel.jpg"));
		Assert.assertTrue(homePage.isFileLinkUploadedByName("ScrumProcess.jpg"));
		
		Assert.assertTrue(homePage.isFileImageUploadedByName("waterfallModel.jpg"));
		Assert.assertTrue(homePage.isFileImageUploadedByName("ScrumProcess.jpg"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
