package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Click login button")
	public UserHomePageObject clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
//	@Step("Verify error message of Email text box")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

//	@Step("Enter to Confirm Email textbox with value is {0}")
	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
//	@Step("Verify Unssuccess message")
	public String getErrorMessageUnsuccessgfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}
	
//	@Step("Enter to Confirm Password textbox with value is {0}")
	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public UserHomePageObject LoginAsUser(String email, String password) {
		inputEmailTextBox(email);
		inputPasswordTextbox(password);
		return clickLoginButton();
	}
}
