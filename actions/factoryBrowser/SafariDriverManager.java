package factoryBrowser;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SafariDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		if(!IS_OS_MAC) {
			throw new BrowserNotSupportException("Safari is not supported on " + System.getProperty("os.name"));
		}
		WebDriverManager.safaridriver().setup();
		SafariOptions options = new SafariOptions();
		//set capabilities/options
		options.setCapability("safari.cleanSession",true);
		
		return new SafariDriver(options);
	}
	
}
