package pageUI.workpress.admin;

public class AdminPostAddNewPageUI {
	public static final String IFRAME_ADD_NEW_POST = "xpath=//iframe[@name='editor-canvas']";
	public static final String POST_TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String POST_BODY_BUTTON = "xpath=//p[@role='button' and contains(@class,'block-editor-default')]";
	public static final String POST_BODY_TEXTAREA = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_UPDATE_BUTTON = "css=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button']";
	public static final String RE_PUBLISH_BUTTON = "css=div[class*='editor-post-publish'] button[class*='editor-post-publish-button']";
	public static final String PUBLISH_UPDATED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
	
}
