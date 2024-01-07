package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.GlobalConstants;

public class BrowserStackFactory {
	private WebDriver driver;
	private String browserName;
	private String osVersion;
	private String osName;
	
	public BrowserStackFactory(String browserName, String osVersion, String osName) {
		this.browserName = browserName;
		this.osVersion = osVersion;
		this.osName = osName;
	}
	
	
	public WebDriver createDriver() {
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
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
