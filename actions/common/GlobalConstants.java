package common;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String REPORT_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV5" + File.separator;
	
	//Cloud variables
	public static final String BROWSER_USERNAME = "phuongtranautomaf85ei";
	public static final String BROWSER_AUTOMATE_KEY = "xgzPpeG6931sMtuZYtfc";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCE_USERNAME = "oauth-trananhphuongbl112-b898d";
	public static final String SAUCE_AUTOMATE_KEY = "c847b2c2-7bef-485a-afea-59b923519fbb";
	public static final String SAUCE_LAB_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
}
