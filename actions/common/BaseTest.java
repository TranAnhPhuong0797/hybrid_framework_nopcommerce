package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	//private String projectpath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserName(String browserName) {
		
		if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		}else if (browserName.equals("edge")) {
			//System.setProperty("webdriver.edge.driver", projectpath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		//driverBaseTest.get("http://live.techpanda.org/index.php/");
		
		return driverBaseTest;
	}
	
	// Head less
//	protected WebDriver getBrowserName(String browserName) {
//		
//		if(browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1920*1080");
//			driver = new FirefoxDriver(options);
//		}else if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1920*1080");
//			driver = new ChromeDriver(options);
//		}else if (browserName.equals("edge")) {
//			System.setProperty("webdriver.edge.driver", projectpath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		}else {
//			throw new RuntimeException("Browser name invalid");
//		}
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://demo.nopcommerce.com/");
//		
//		return driver;
//	}
	
	protected WebDriver getBrowserName(String browserName, String apURL) {
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(apURL);
		return driverBaseTest;
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
}
