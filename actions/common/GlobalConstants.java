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
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV2" + File.separator;
	
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
}
