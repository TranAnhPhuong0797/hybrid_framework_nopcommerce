package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserName(String browserName) {
		
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectpath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		return driver;
	}
}
