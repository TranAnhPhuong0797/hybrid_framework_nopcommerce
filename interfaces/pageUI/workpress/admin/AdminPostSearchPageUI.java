package pageUI.workpress.admin;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_ROW_VALUE_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/td[@data-colname='%s']//a[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/th/label/span[contains(text(),'%s')]//parent::label//following-sibling::input";
	public static final String ACTIONS_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON = "css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath= //div[@id='message']/p[text()='1 post moved to the Trash. ']";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td";
}
