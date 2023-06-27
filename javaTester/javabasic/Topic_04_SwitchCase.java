package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_04_SwitchCase {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	String projectPath = System.getProperty("user.dir");
	
	@Test
	private void switchBrowser(String browsername) {
		driver = getBrowser(browsername);
		
		System.out.println(browsername);
		driver.quit();
	}
	
	public WebDriver getBrowser(String browsername) {
		switch (browsername) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			throw new RuntimeException("Please input correct browser name.");
		}
		return driver;
	}
}
