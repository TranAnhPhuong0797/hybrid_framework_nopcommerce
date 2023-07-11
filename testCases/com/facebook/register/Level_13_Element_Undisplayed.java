package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObject.Facebook.LoginPageObject;
import pageObject.Facebook.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPageObject;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserName(browserName, appURL);	
		loginPageObject = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Veirfy_Element_Displayed() {
		loginPageObject.clickToCreateNewAccountButton();
		verifyTrue(loginPageObject.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Veirfy_Element_Undisplayed_In_Dom() {
		// Verify false - the function returns is Displayed
		loginPageObject.enterToEmailAddressTextbox("");
		verifyTrue(loginPageObject.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@Test
	public void TC_03_Veirfy_Element_Undisplayed_Not_In_Dom() {
		loginPageObject.clickCloseIconAtRegisterform();
		verifyTrue(loginPageObject.isConfirmEmailAddressTextboxUndisplayed());
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
