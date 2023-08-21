package pageObject.workpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.workpress.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
private WebDriver driver;
	
	
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public AdminPostSearchPageObject clickToMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearch(driver);
	}
}
