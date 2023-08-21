package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
//import io.qameta.allure.Step;
import pageUI.nopcommerce.User.AddressesPageUI;
import pageUI.nopcommerce.User.BasePageUINopcommerce;

public class UserAddressPageObject extends BasePage{
	WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Step("Select country dropdownlist with value is {0}")
	public void selectCountryDropdownlist(String country) {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWNLIST, country);
	}
	
//	@Step("Select country dropdownlist with value is {0}")
	public void selectStateProvinceDropdownlist(String stateProvince) {
		waitForElementVisible(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWNLIST, stateProvince);
	}

	public void verifyAddressinformationOfTitile(String titile, String emailAddress, String phoneNumber, String faxNumber, String companyName, String address1, String address2, String zipcode, String country) {
		waitForElementVisible(driver, BasePageUINopcommerce.ADDRESS_INFOR_SECTION, titile);
		String valuesSection = getTextElement(driver, BasePageUINopcommerce.ADDRESS_INFOR_SECTION, titile);
		
		Assert.assertEquals(valuesSection, valuesSection.contains(titile));
		Assert.assertEquals(valuesSection, valuesSection.contains(emailAddress));
		Assert.assertEquals(valuesSection, valuesSection.contains(phoneNumber));
		Assert.assertEquals(valuesSection, valuesSection.contains(faxNumber));
		Assert.assertEquals(valuesSection, valuesSection.contains(companyName));
		Assert.assertEquals(valuesSection, valuesSection.contains(address1));
		Assert.assertEquals(valuesSection, valuesSection.contains(address2));
		Assert.assertEquals(valuesSection, valuesSection.contains(zipcode));
		Assert.assertEquals(valuesSection, valuesSection.contains(country));
	}

	public void clickDeleteButtonOfTitle(String title) {
		waitForElementClickable(driver, AddressesPageUI.DELETE_BUTTON_ADDRESS_SECTION, title);
		clickToElement(driver, AddressesPageUI.DELETE_BUTTON_ADDRESS_SECTION, title);
	}

	public void verifyNotificationAddressAddedSuccessfully(String message) {
		waitForElementVisible(driver, BasePageUINopcommerce.BAR_NOTIFICATION);
		Assert.assertEquals(getTextElement(driver, BasePageUINopcommerce.BAR_NOTIFICATION), message);
	}
	

}
