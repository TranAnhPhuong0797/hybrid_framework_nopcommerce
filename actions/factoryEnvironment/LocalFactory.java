package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportException;
import factoryBrowser.ChromeDriverManage;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManage;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.IEDriverManager;
import factoryBrowser.SafariDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	
	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case CHROME:
			driver = new ChromeDriverManage().getBrowserDriver();
			break;
			
		case FIREFOX:
			driver = new FirefoxDriverManage().getBrowserDriver();
			break;
			
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
			
		case IE:
			driver = new IEDriverManager().getBrowserDriver();
			break;
			
		case EDGE_CHROMENIUM:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
			
		case H_CHROME:
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
			
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
			
		default:
			throw new BrowserNotSupportException(browserName);
		}
		return driver;
	}
}
