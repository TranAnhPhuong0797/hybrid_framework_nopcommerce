package common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import common.BasePage;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopcommerce.portal.UserAddressPageObject;
import pageObject.nopcommerce.portal.UserBackInStockSubscriptionsPageObject;
import pageObject.nopcommerce.portal.UserChangePasswordPageObject;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserDownloadProductsPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserMyProductReviewPageObject;
import pageObject.nopcommerce.portal.UserOrderPageObject;
import pageObject.nopcommerce.admin.AdminLoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRewardPointPageObject;
import pageObject.workpress.AdminDashboardPageObject;
import pageObject.workpress.UserHomePO;
import pageUI.nopcommerce.User.BasePageUINopcommerce;
import pageUIjQueryUploadFile.BasePageUIjQuery;

public class BasePage {
	// Open URL
	// Common functions
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	
	public BasePage getBasePage(){
		return new BasePage();
	}
	
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
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
	public Alert waitForAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
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

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public String getElementValueByJSXpath(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XpathResult.FIRST_ORDERED_NODE_TYPE, null) singleNodeValue),val()");
	}

	public List<WebElement> getListElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public List<WebElement> getListElements(WebDriver driver, String locatorType, String...dynamicValues ) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, dynamicValues)));
	}
	
	//LocatorType: id= / css= / name= / class= / xpath= 
	//LocatorType: ID= / CSS= / NAME= / CLASS= / XPATH=
	//LocatorType: Id= / Css= / Name= / Class= / Xpath=
	private By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith(("Id="))) {
			by = By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is NOT supported!");
		} 
		return by;
	}
	
	//If locatorType = xpath => true, if locatorType != xpath => false
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[])dynamicValues);
		}
		return locatorType;
	}
	
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getCurrentDate() {
		return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues ) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	
	/** Click to dynamic Button by TextName
	 * @author Phuong TA
	 * @param driver
	 * @param buttonText
	 * */
	public void clicktoButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUINopcommerce.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	
	/** Click to dynamic RadioButton by LabelName
	 * @author Phuong TA
	 * @param driver
	 * @param radioLabelName
	 * */
	public void clickToRadioButtonByLabel(WebDriver driver, String radioLabelName) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageUINopcommerce.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioLabelName);
	}
	
	/** Click to dynamic Checkbox by LabelName
	 * @author Phuong TA
	 * @param driver
	 * @param checkboxLabelName
	 * */
	public void clickToCheckboxButtonByLabel(WebDriver driver, String checkboxLabelName) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_CHECKBOX_BUTTON_BY_LABEL, checkboxLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageUINopcommerce.DYNAMIC_CHECKBOX_BUTTON_BY_LABEL, checkboxLabelName);
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void clearValueToElementByDeleteKeys(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	public String getTextElement(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public String getTextElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	
	
	/** Select to dynamic Dropdown by TextName
	 * @author Phuong TA
	 * @param driver
	 * @param dropdown Attribute Name
	 * @param itemValue
	 * */
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageUINopcommerce.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
	}

	public String getSelectedItemDefaultInDrodown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemDefaultInDrodown(WebDriver driver, String xpathLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	public Boolean drodownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

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

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementCSSValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementsSize(WebDriver driver, String xpathLocator) {
		return getListElements(driver, xpathLocator).size();
	}
	
	public int getElementsSize(WebDriver driver, String xpathLocator, String... dynamicValues){
		return getListElements(driver, getDynamicXpath(xpathLocator, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}


	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues){
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	
	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListElements(driver, locatorType);
		overrideImplicitTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {	
			return true;
		}else {
			System.out.println("Element is in DOM and visible");
			return false;
		}
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String...dynamicValues) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListElements(driver, getDynamicXpath(locatorType, dynamicValues));
		overrideImplicitTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {	
			return true;
		}else {
			System.out.println("Element is in DOM and visible");
			return false;
		}
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	public void highlightElement(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locator, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locator, dynamicValues)));
	}
	
	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait = new WebDriverWait(driver, longTimeout);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitwait.until(jQueryLoad) && explicitwait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isImageLoaded(WebDriver driver, String xpathLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)));
		return status;
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathLocator)));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
	}
	
	/*
	 * Wait for element undisplayed in DOM or not in DOM and override implicit timeout 
	 */
	public void waitForElementUndisplayed(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
		overrideImplicitTimeout(driver, longTimeout);
	}
	
	public void waitForAllElementsInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, xpathLocator)));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageUIjQuery.UPLOAD_FILE).sendKeys(fullFileName);
	}
	
	public BasePage openPagesAtMyAccountByName (WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_PAGES_AT_MYACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUINopcommerce.DYNAMIC_PAGES_AT_MYACCOUNT_AREA, pageName);
		
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
			
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
			
		case "Orders":
			return PageGeneratorManager.getUserOrderPage(driver);
			
		case "Downloadable products":
			return PageGeneratorManager.getUserDownloadProductsPage(driver);
			
		case "Back in stock subscriptions":
			return PageGeneratorManager.getUserBackInStockSubscriptionsPage(driver);
			
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
			
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
			
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
			
		default:
			throw new RuntimeException("Invalid page name at My Account area.");
		}
	}
	
	public void openPagesAtMyAccountByPageName (WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUINopcommerce.DYNAMIC_PAGES_AT_MYACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUINopcommerce.DYNAMIC_PAGES_AT_MYACCOUNT_AREA, pageName);
	}
	
	/** Enter to dynamic Textbox by ID
	 * @author Phuong TA
	 * @param driver
	 * @param textboxId
	 * @param value
	 * */
	public void inputToTextboxByID(WebDriver driver, String textboxId, String value) {
		waitForAllElementsVisible(driver, BasePageUINopcommerce.DYNAMIC_TEXT_BOX_BY_ID, textboxId);
		sendkeyToElement(driver, BasePageUINopcommerce.DYNAMIC_TEXT_BOX_BY_ID, value, textboxId);
	}
	
	/** Enter to dynamic Textbox by text
	 * @author Phuong TA
	 * @param driver
	 * @param textboxId
	 * @param value
	 * */
	public void inputToTextboxByText(WebDriver driver, String textbox, String value) {
		waitForAllElementsVisible(driver, BasePageUINopcommerce.DYNAMIC_TEXT_BOX_BY_TEXT, textbox);
		sendkeyToElement(driver, BasePageUINopcommerce.DYNAMIC_TEXT_BOX_BY_TEXT, value, textbox);
	}
	
	/** Enter to dynamic TextArea by ID
	 * @author Phuong TA
	 * @param driver
	 * @param textAreaId
	 * @param value
	 * */
	public void inputToTextareaByID(WebDriver driver, String textareaId, String value) {
		waitForAllElementsVisible(driver, BasePageUINopcommerce.DYNAMIC_TEXT_AREA_BY_ID, textareaId);
		sendkeyToElement(driver, BasePageUINopcommerce.DYNAMIC_TEXT_AREA_BY_ID, value, textareaId);
	}
	
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUINopcommerce.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.ADDRESS_LINK);
		clickToElement(driver, BasePageUINopcommerce.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserOrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.ORDER_LINK);
		clickToElement(driver, BasePageUINopcommerce.ORDER_LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}
	
	public UserDownloadProductsPageObject openDownloadPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, BasePageUINopcommerce.DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneratorManager.getUserDownloadProductsPage(driver);
	}
	
	public UserBackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.BACK_IN_STOCK_SUBCRIPTION_LINK);
		clickToElement(driver, BasePageUINopcommerce.BACK_IN_STOCK_SUBCRIPTION_LINK);
		return PageGeneratorManager.getUserBackInStockSubscriptionsPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUINopcommerce.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	public UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUINopcommerce.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, BasePageUINopcommerce.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUINopcommerce.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUINopcommerce.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUINopcommerce.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageURL(driver, endUserUrl);
		return pageObject.workpress.PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminDashboardPageObject openAdminUserSite(WebDriver driver, String adminUrl) {
		openPageURL(driver, adminUrl);
		return pageObject.workpress.PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
