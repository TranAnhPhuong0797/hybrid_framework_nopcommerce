package pageObjectjQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIjQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String label, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, label);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, label);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}
	
	public List<String> getValueEachRowAtAllPages() {
		int totalPages = getElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size: " + totalPages);
		
		List<String> allRowValues = new ArrayList<String>();
		
		for (int index = 1; index < totalPages; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(index));
			//sleepInSecond(1);
			
			List<WebElement> allRowElementEachPage = getListElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement rowElement : allRowElementEachPage) {
				allRowValues.add(rowElement.getText());
			}			
		}
		
		for (String value: allRowValues) {
			System.out.println("--------------------------------");
			System.out.println(value);
		}
		return allRowValues;
	}
	
}
