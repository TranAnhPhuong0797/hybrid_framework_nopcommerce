package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;

public class Level_02_User_01_Register_ApplyBasePage_III extends BasePage {
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");
	String emailAddress;

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test
	public void TC_01_Registor_With_EmptyData() {
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
			
		Assert.assertEquals(getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}
	
	@Test
	public void TC_02_Registor_With_InvalidEmail() {
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "Van A");
		sendkeyToElement(driver, "//input[@id='Email']", "8801233");
		sendkeyToElement(driver, "//input[@id='Password']", "199000");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "190000");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Wrong email");	
	}
	
	@Test
	public void TC_03_Registor_With_Password_LessThan_6Char() {
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "Van A");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "1990");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\n" + "must have at least 6 characters");	
	}
	
	@Test
	public void TC_04_Registor_With_ConfirmPassword_NotCorrect() {
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "Van A");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "199000");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "190000");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}
	
	@Test
	public void TC_05_Registor_With_ValidData() {
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "Van A");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "199000");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "199000");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");
	}
	
	@Test
	public void TC_06_Registor_With_Email_Exist() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "Van A");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "199000");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "199000");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
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
