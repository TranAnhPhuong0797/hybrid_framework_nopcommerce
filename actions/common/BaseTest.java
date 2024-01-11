package common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import factoryEnvironment.BrowserStackFactory;
import factoryEnvironment.EnvironmentList;
import factoryEnvironment.GridFactory;
import factoryEnvironment.LambdaFactory;
import factoryEnvironment.LocalFactory;
import factoryEnvironment.SaucelabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends BasePage{
	private WebDriver driverBaseTest;
	// private String projectpath = System.getProperty("user.dir");
	protected final Log log;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserName(String browserName) {

		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectpath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectpath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectpath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		driverBaseTest.manage().window().fullscreen();
		// driverBaseTest.get("http://live.techpanda.org/index.php/");

		return driverBaseTest;
	}

	public WebDriver getWebDriver() {
		return this.driverBaseTest;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driverBaseTest.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driverBaseTest != null) {
				driverBaseTest.manage().deleteAllCookies();
				driverBaseTest.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
	
	protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String ipAddress, String portNumber, String osName, String osVersion) {
		switch (envName.toLowerCase()) {
		case "local":
			driverBaseTest = new LocalFactory(browserName).createDriver();
			break;
		case "grid":
			driverBaseTest = new GridFactory(browserName, ipAddress, portNumber, osName).createDriver();
			break;
		case "browserstack":
			driverBaseTest = new BrowserStackFactory(browserName, osVersion, osName).createDriver();
			break;
		case "saucelab":
			driverBaseTest = new SaucelabFactory(browserName, osName).createDriver();
			break;
		case "lambda":
			driverBaseTest = new LambdaFactory(browserName, osName).createDriver();
			break;
		default:
			driverBaseTest = new LocalFactory(browserName).createDriver();
			break;
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(getEnvironmentUrl(serverName));
		return driverBaseTest;
	}

	protected WebDriver getBrowserNameLocal(String browserName, String appUrl) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//Disabled driver logs for Firefox
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			//Disabled Notification & Location for Firefox
			options.addArguments("--disable notifications");
			options.addArguments("--disable geolocation");
			//Auto Save and Download files
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip.application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png,image/jpeg,application/pdf,text/html,text/plain,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/octet-stream");
			options.addPreference("pdfjs.disabled", true);
			//Open private browser for Firefox
//			options.addArguments("-private");
			driverBaseTest = new FirefoxDriver(options);
			
		}else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920*1080");
			driverBaseTest = new FirefoxDriver(options);
			
		}else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//Disabled driver logs for Chrome
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdricer.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			//Disabled Notification & Location for Chrome
			options.addArguments("--disable notifications");
			options.addArguments("--disable geolocation");
			options.setExperimentalOption("userAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			//Disbaled "Save Password" in Chrome
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			//Auto Save and Download files
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			options.setExperimentalOption("prefs", chromePrefs);
			//Open private browser for Chrome
//			options.addArguments("--incognito");
			driverBaseTest = new ChromeDriver(options);
			
		}else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920*1080");
			driverBaseTest = new ChromeDriver(options);
			
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriverGrid(String browserName, String appUrl, String osName, String ipAddress, String portNumber) {
		DesiredCapabilities capability = null;
		Platform platform = null;

		if (osName.contains("windows")) {
			platform = Platform.WINDOWS;
		} else {
			platform = Platform.MAC;
		}

		switch (browserName.toLowerCase()) {
			case "firefox" :
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(platform);

				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.merge(capability);
				break;
			case "chrome" :
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(platform);

				ChromeOptions cOptions = new ChromeOptions();
				cOptions.merge(capability);
				break;
			case "edge" :
				capability = DesiredCapabilities.edge();
				capability.setBrowserName("edge");
				capability.setPlatform(platform);

				EdgeOptions eOptions = new EdgeOptions();
				eOptions.merge(capability);
				break;
			default :
				throw new RuntimeException("Browser is not valid!");
		}

		try {
			driverBaseTest = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriverBrowserstack(String browserName, String appUrl, String osName, String osVersion) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", osName);
		capabilities.setCapability("os_version", osVersion);
		capabilities.setCapability("browser", browserName);
		capabilities.setCapability("browser_version", "latest");
		capabilities.setCapability("browserstack.debug", "true");
		capabilities.setCapability("project", "Nopcommerce");
		capabilities.setCapability("resolution", "1920x1080");
		capabilities.setCapability("browserstack.selenium_version", "3.141.59");
		capabilities.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);
		
		try {
			driverBaseTest = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriverSauceLab(String browserName, String appUrl, String osName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("name", "Run on" + osName + " | " + browserName);
		
		Map<String, Object> sauceOptions = new HashMap<>();
		if (osName.contains("Windows")) {
			sauceOptions.put("screenResolution", "1920x1080");
		}else {
			sauceOptions.put("screenResolution", "1920x1440");
		}
		capabilities.setCapability("sauce:options", sauceOptions);
		
		try {
			driverBaseTest = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_LAB_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriverLambda(String browserName, String appUrl, String osName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("project", "Norcommerce");
		
		if (osName.contains("Windows")) {
			capabilities.setCapability("screenResolution", "1920x1080");
		}else {
			capabilities.setCapability("screenResolution", "1440x900");
		}
		capabilities.setCapability("name", "Run on" + osName + " | " + browserName);
		
		try {
			driverBaseTest = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}
	
	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environments = EnvironmentList.valueOf(serverName.toUpperCase());
		//Method Switch/Case
		switch (environments) {
		case DEV:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case TESTING:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case PREPROD:
			envUrl = "https://demo.nopcommerce.com/";
			break;

		default:
			envUrl = null;
			break;
		}
		
		
		//Method if/else
		if (environments == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";
		}else if (environments == EnvironmentList.TESTING) {
			envUrl = "https://demo.nopcommerce.com/";
		}else if (environments == EnvironmentList.PREPROD) {
			envUrl = "https://demo.nopcommerce.com/";
		}
		return envUrl;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
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
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
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
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
