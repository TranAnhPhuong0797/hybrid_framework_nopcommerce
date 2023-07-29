package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUI.nopcommerce.User.AddressesPageUI;

public class UserAddressPageObject extends BasePage{
	WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Select country dropdownlist with value is {0}")
	public void selectCountryDropdownlist(String country) {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWNLIST, country);
	}
	
	@Step("Select country dropdownlist with value is {0}")
	public void selectStateProvinceDropdownlist(String stateProvince) {
		waitForElementVisible(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWNLIST, stateProvince);
	}
}
