package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Object Actions
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}
	
	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getTextElement(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getTextElement(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getTextElement(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getTextElement(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getTextElement(driver, existingEmailErrorMessage);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);	
	}
	
	//Set-up Page UI
	@FindBy(how=How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(how=How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;

	@FindBy(how=How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextBox;

	@FindBy(how=How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextBox;

	@FindBy(how=How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(how=How.XPATH, using = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(how=How.XPATH, using = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(how=How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(how=How.XPATH, using = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(how=How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(how=How.XPATH, using = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(how=How.XPATH, using = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(how=How.XPATH, using = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;
}
