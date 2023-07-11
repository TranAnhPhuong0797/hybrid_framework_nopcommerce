package javabasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;

@Listeners(common.MethodListener.class)
public class Topic_17_Assert extends BaseTest{
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void TC_01_ValidationUrl() {
		System.out.println("Assert 1");
		String LoginPageURL = driver.getCurrentUrl();
		verifyEquals(LoginPageURL, "https://www.facebook.com/");
		
		System.out.println("Assert 2 - Failed");
		String LoginPageTile = driver.getCurrentUrl();
		verifyEquals(LoginPageTile, "Facebook – log in or sign up ...");
		
		System.out.println("Assert 3");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		System.out.println("Assert 4 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());
		
		System.out.println("Assert 5");
		verifyTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
