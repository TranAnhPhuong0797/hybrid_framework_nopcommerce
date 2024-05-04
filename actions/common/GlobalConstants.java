package common;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalConstants {
	
	//Private static variables
	private static GlobalConstants globalConstants;
	
	//Private constructor
	private GlobalConstants() {
		
	}
	
	//Public static methods
	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalConstants == null) {
			globalConstants = new GlobalConstants();
		}
		return globalConstants;
	}
	
	
	private final String portalPageUrl = "https://demo.nopcommerce.com/";
	private final String adminPageUrl = "https://admin-demo.nopcommerce.com/";
	
	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = System.getProperty("os.name");
	private final String uploadFileFolder = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String downloadFileFolder = projectPath + File.separator + "downloadFiles";
	private final String browserLogFolder = projectPath + File.separator + "browserLogs";
	private final String reportScreenshort = projectPath + File.separator + "reportNGImage" + File.separator;
	private final String extentPath = projectPath + File.separator + "extentV5" + File.separator;
	
	//Cloud variables
	private final String browserUsename = "phuongtranautomaf85ei";
	private final String browserAutomateKey = "xgzPpeG6931sMtuZYtfc";
	private final String browserStackUrl = "https://" + browserUsename + ":" + browserAutomateKey + "@hub-cloud.browserstack.com/wd/hub";
	
	private final String sauceUsername = "oauth-trananhphuongbl112-b898d";
	private final String sauceAutomateKey = "c847b2c2-7bef-485a-afea-59b923519fbb";
	private final String sauceLabUrl = "https://" + sauceUsername + ":" + sauceAutomateKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	private final String lambdaUsername = "trananhphuongbl112";
	private final String lambdaAutomateKey = "61S0HSmXwzxoXPUmKdsAigXCWLUBC99OYotPP6dV8CCc8wk5GP";
	private final String lambdaUrl = "https://" + lambdaUsername + ":" + lambdaAutomateKey + "@hub.lambdatest.com/wd/hub";
	
	private final long shortTimeout = 5;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;
}
