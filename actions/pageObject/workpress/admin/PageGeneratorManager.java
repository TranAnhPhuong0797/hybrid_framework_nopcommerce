package pageObject.workpress.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminPostAddNewPageObject getAdminPostAddNew(WebDriver driver) {
		return new AdminPostAddNewPageObject(driver);
	}
	
	public static AdminPostCategoriesPageObject getAdminPostCategories(WebDriver driver) {
		return new AdminPostCategoriesPageObject(driver);
	}
	
	
	public static AdminPostSearchPageObject getAdminPostSearch(WebDriver driver) {
		return new AdminPostSearchPageObject(driver);
	}
	
	public static AdminPostTagNamePageObject getAdminPostTagName(WebDriver driver) {
		return new AdminPostTagNamePageObject(driver);
	}
}
