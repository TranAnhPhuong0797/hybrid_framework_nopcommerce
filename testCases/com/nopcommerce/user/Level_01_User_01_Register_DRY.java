package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_User_01_Register_DRY {
	/* Note:
	 * This class violated the DRY (Don't repeat yourself) standard
	 * Repeating the same features/code lines in the same class/framework
	 */
	
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
		driver.findElement(By.id("register-button")).click();
		
		WebElement err_Firstname = driver.findElement(By.xpath("//span[@id='FirstName-error']"));
		WebElement err_Lastname = driver.findElement(By.xpath("//span[@id='LastName-error']"));
		WebElement err_Email = driver.findElement(By.xpath("//span[@id='Email-error']"));
		WebElement err_Password = driver.findElement(By.xpath("//span[@id='Password-error']"));
		WebElement err_CPassword = driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']"));
		
		Assert.assertEquals(err_Firstname.getText(), "First name is required.");
		Assert.assertEquals(err_Lastname.getText(), "Last name is required.");
		Assert.assertEquals(err_Email.getText(), "Email is required.");
		Assert.assertEquals(err_Password.getText(), "Password is required.");
		Assert.assertEquals(err_CPassword.getText(), "Password is required.");
	}
	
	@Test
	public void TC_02_Registor_With_InvalidEmail() {
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Van A");
		driver.findElement(By.id("Email")).sendKeys("8801233");
		driver.findElement(By.id("Password")).sendKeys("199000");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("190000");
		driver.findElement(By.id("register-button")).click();
		
		WebElement err_Email = driver.findElement(By.xpath("//span[@id='Email-error']"));
		Assert.assertEquals(err_Email.getText(), "Wrong email");
	}
	
	@Test
	public void TC_03_Registor_With_Password_LessThan_6Char() {
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("ConfirmPassword")).clear();
		
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Van A");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("1990");
		driver.findElement(By.id("register-button")).click();
		
		WebElement err_Password = driver.findElement(By.xpath("//span[@id='Password-error']"));
		Assert.assertEquals(err_Password.getText(), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void TC_04_Registor_With_ConfirmPassword_NotCorrect() {
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("ConfirmPassword")).clear();
		
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Van A");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("199000");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("190000");
		driver.findElement(By.id("register-button")).click();
		
		WebElement err_CPassword = driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']"));
		Assert.assertEquals(err_CPassword.getText(), "The password and confirmation password do not match.");
	}
	
	@Test
	public void TC_05_Registor_With_ValidData() {
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("ConfirmPassword")).clear();
		
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Van A");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("199000");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("199000");
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
	}
	
	@Test
	public void TC_06_Registor_With_Email_Exist() {
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("ConfirmPassword")).clear();
		
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Van A");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("199000");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("199000");
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
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
