package pageUI.nopcommerce.User;

public class CategoriesPageUI {
	public static final String LIST_PRODUCT_NAME = "xpath=//div[@class='product-item']//div[@class='details']//a";
	
	
	public static final String CATEGORIES_TREE = "xpath=//strong[text()='Categories']//parent::div[@class='title']//following-sibling::div[@class='listbox']//a[contains(text(),'%s')]";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']//a[contains(text(),'%s')]";
}
