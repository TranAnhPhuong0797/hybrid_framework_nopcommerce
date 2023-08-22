package pageUI.workpress.admin;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_ROW_VALUE_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/td[@data-colname='%s']//a[text()='%s']";
}
