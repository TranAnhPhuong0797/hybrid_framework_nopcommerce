package pageUI.workpress.admin;

public class AdminPostAddNewPageUI {
	public static final String POST_TITLE_BUTTON = "css=h1.wp-block-post-title";
	public static final String POST_TITLE_TEXTBOX = "xpath=//h1[@role='textbox' and contains(@class,'is-selected')]";
	public static final String POST_BODY_BUTTON = "xpath=//p[@role='button' and contains(@class,'block-editor-default')]";
	public static final String POST_BODY_TEXTAREA = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "xpath=//button[text()='Publish']";
	public static final String PUBLISH_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
	
}
