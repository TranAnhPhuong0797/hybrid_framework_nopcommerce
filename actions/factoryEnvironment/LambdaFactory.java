package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import common.GlobalConstants;


public class LambdaFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;

	public LambdaFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("project", "Norcommerce");

		if (osName.contains("Windows")) {
			capabilities.setCapability("screenResolution", "1920x1080");
		} else {
			capabilities.setCapability("screenResolution", "1440x900");
		}
		capabilities.setCapability("name", "Run on" + osName + " | " + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getLambdaUrl()), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(appUrl);
		return driver;
	}
}
