package pageUI.nopcommerce.User;

public class SearchPageUI {
	
	public static final String SEARCH_TEXT = "xpath=//input[@class='search-text']";
	public static final String ADVANCED_CHECK_BOX = "xpath=//label[text()='Advanced search']//preceding-sibling::input";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']//preceding-sibling::input";
	public static final String SEARCH_IN_PRODUCT_CHECKBOX = "xpath=//label[text()='Search In product descriptions']//preceding-sibling::input";
	
	public static final String CATEGORY_DROPDOWN_LIST = "xpath=//label[text()='Category:']//following-sibling::select";
	public static final String MANUFACTURER_DROPDOWN_LIST = "xpath=//label[text()='Manufacturer:']//following-sibling::select";
	
	public static final String SEARCH_BUTTON_IN_SEARCH_PAGE = "xpath=//div[@class='search-input']//button[text()='Search']";
	
	public static final String ERROR_MESSAGE_IN_SEARCH_PAGE = "xpath=//div[@class='warning']";
	public static final String NO_RESULT_MESSAGE_IN_SEARCH_PAGE = "xpath=//div[@class='no-result' and text()='No products were found that matched your criteria.']";
	
	public static final String LIST_PRODUCT = "xpath=//div[@class='product-item']";
	//Pattern Object
	public static final String DYNAMIC_SEARCH_PAGE_CHECKBOX = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String DYNAMIC_SEARCH_PAGE_DROPDOWN_LIST = "xpath=//label[contains(text(),'%s')]//following-sibling::select";
	public static final String PRODUCTS__LINK = "xpath=//div[@class='product-item']//div[@class='details']//a[contains(text(),'%s')]";
}
