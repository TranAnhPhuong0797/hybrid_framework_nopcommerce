package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.BasePageUINopcommerce;
import pageUI.nopcommerce.User.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Click to button Register")
	public UserHomePageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
//	@Step("Verify error message of First Name text box")
	public String getErrorMessageAtFirstNameTextBox() {
		waitForAllElementsVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
//	@Step("Verify error message of Last Name text box")
	public String getErrorMessageAtLastNameTextBox() {
		waitForAllElementsVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
//	@Step("Verify error message of Email text box")
	public String getErrorMessageAtEmailTextBox() {
		waitForAllElementsVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
//	@Step("Verify error message of Password text box")
	public String getErrorMessageAtPasswordTextBox() {
		waitForAllElementsVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
//	@Step("Verify error message of Confrim Password text box")
	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForAllElementsVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
//	@Step("Enter to First Name textbox with value is {0}")
	public void inputToFirstNameTextBox(String firstName) {
		waitForAllElementsVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

//	@Step("Enter to Last Name textbox with value is {0}")
	public void inputToLastNameTextBox(String lastName) {
		waitForAllElementsVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

//	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextBox(String email) {
		waitForAllElementsVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
//	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextBox(String password) {
		waitForAllElementsVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
//	@Step("Enter to Confirm Password textbox with value is {0}")
	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementsVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);		
	}
	
//	@Step("Verify error message of Email text box")
	public String getErrorExistingEmailMessage() {
		waitForAllElementsVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}
	
//	@Step("Verify success message")
	public String getRegisterSuccessMessage() {
		waitForAllElementsVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
//	@Step("Click to logout link")
	public UserHomePageObject clickToLogoutLink() {
		if (isElementDisplayed(driver, BasePageUINopcommerce.BAR_NOTIFICATION_CHANGE_PASSWORD_SUCCESS)==true) {
			waitForElementClickable(driver, BasePageUINopcommerce.CLOSE_NOTIFICATION_BUTTON);
			clickToElement(driver, BasePageUINopcommerce.CLOSE_NOTIFICATION_BUTTON);
		}
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);	
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
//	@Step("Click to continue button")
	public void clicktoContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
	}
	
	public UserHomePageObject registerNewUserAccount(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		inputToFirstNameTextBox(firstName);
		inputToLastNameTextBox(lastName);
		inputToEmailTextBox(email);
		inputToPasswordTextBox(confirmPassword);
		inputToConfirmPasswordTextBox(confirmPassword);
		return clickToRegisterButton();
	}
}
