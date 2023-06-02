package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Open URL
	// Common functions
	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
		;
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	

	public Alert waitForAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		Alert aler = waitForAlertPresent(driver);
		aler.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert aler = waitForAlertPresent(driver);
		aler.dismiss();
	}

	public void getTextAlert(WebDriver driver) {
		Alert alert = waitForAlertPresent(driver);
		alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		Alert alert = waitForAlertPresent(driver);
		alert.sendKeys(textValue);
	}

	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	
	
	public WebElement getWebElement (WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public By getByXpath (String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getTextElement(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(xpathLocator);		
	}
	
	public String getSelectedItemDefaultInDrodown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean drodownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		List<WebElement> allItems = explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementCSSValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
