package pageUI.nopcommerce.User;

public class CategoriesPageUI {
	public static final String LIST_PRODUCT_NAME = "xpath=//div[@class='product-item']//div[@class='details']//a";
	public static final String LIST_PRODUCT_PRICE = "xpath=//div[@class='product-item']//div[@class='prices']//span";
	public static final String LIST_PRODUCT = "xpath=//div[@class='product-item']";
	public static final String CURRENT_PAGING_PRODUCT = "xpath=//div[@class='pager']//li[@class='current-page']/span";
	public static final String PREVIOUS_PAGING_PRODUCT = "xpath=//div[@class='pager']//li[@class='previous-page']";
	public static final String NEXT_PAGING_PRODUCT = "xpath=//div[@class='pager']//li[@class='next-page']";
	
	
	public static final String CATEGORIES_TREE = "xpath=//strong[text()='Categories']//parent::div[@class='title']//following-sibling::div[@class='listbox']//a[contains(text(),'%s')]";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']//a[contains(text(),'%s')]";
}
