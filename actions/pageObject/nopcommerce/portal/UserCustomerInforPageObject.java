package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.nopcommerce.User.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	WebDriver driver;
	
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL);
		sendkeyToElement(driver, CustomerInforPageUI.EMAIL, emailAddress);
	}

	public void inputCompanyName(String companyName) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

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

	public void selectDays(String days) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_DAY);
	}

	public void selectMonths(String months) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_MONTH);
		
	}

	public void selectYears(String years) {
		waitForElementVisible(driver, CustomerInforPageUI.DATE_OF_BIRTH_YEAR);
		
	}
}
