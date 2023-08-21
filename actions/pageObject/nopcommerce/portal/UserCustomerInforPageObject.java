package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	WebDriver driver;
	
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Verify Customer Header")
	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	
//	@Step("Enter to First Name textbox with value is {0}")
	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
//	@Step("Enter to Last Name textbox with value is {0}")
	public void inputLastName(String lastName) {
		waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
//	@Step("Enter to Email textbox with value is {0}")
	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL);
		sendkeyToElement(driver, CustomerInforPageUI.EMAIL, emailAddress);
	}
	
//	@Step("Enter to Company textbox with value is {0}")
	public void inputCompanyName(String companyName) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
//	@Step("Select Gender with value is {0}")
	public void selectGender(String gender) {
		if (gender == "Male" || gender == "male" || gender == "MALE") {
			waitForElementClickable(driver, CustomerInforPageUI.GENDER_MALE_RADIOBUTTON);
			clickToElement(driver, CustomerInforPageUI.GENDER_MALE_RADIOBUTTON);
		}else if (gender == "Female" || gender == "female" || gender == "FEMALE") {
			waitForElementClickable(driver, CustomerInforPageUI.GENDER_FEMALE_RADIOBUTTON);
			clickToElement(driver, CustomerInforPageUI.GENDER_FEMALE_RADIOBUTTON);
		} else {
			System.out.print("No found the Radio button");
		}
		
	}
	
//	@Step("Select Days with value is {0}")
	public void selectDays(String days) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_DAY);
	}
	
//	@Step("Select Months with value is {0}")
	public void selectMonths(String months) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_MONTH);
		
	}
	
//	@Step("Select Years with value is {0}")
	public void selectYears(String years) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_YEAR);
		
	}
}
