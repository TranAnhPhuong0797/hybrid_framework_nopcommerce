package pageUI.nopcommerce.User;

public class AddressesPageUI {
	public static final String ADDRESSES_HEADER = "xpath=//div[@class='page-title']/h1[text()='My account - Add new address']";
	public static final String FIRST_NAME_TEXTBOX = "ID=Address_FirstName";
	public static final String LAST_NAME_TEXTBOX = "ID=Address_LastName";
	public static final String EMAIL_TEXTBOX = "ID=Address_Email";
	public static final String COMPANY_NAME_TEXTBOX = "ID=Address_Company";
	public static final String City_TEXTBOX = "ID=Address_City";
	public static final String ADDRESS1_TEXTBOX = "ID=Address_Address1";
	public static final String ADDRESS2_TEXTBOX = "ID=Address_Address2";
	public static final String ZIP_CODE_TEXTBOX = "ID=Address_ZipPostalCode";
	public static final String PHONE_NUMBER_TEXTBOX = "ID=Address_PhoneNumber";
	public static final String FAX_NUMBER_TEXTBOX = "ID=Address_PhoneNumber";
		
	public static final String COUNTRY_DROPDOWNLIST = "xpath=//label[contains(text(),'Country')]//following-sibling::select[@id='Address_CountryId']";
	public static final String STATE_PROVINCE_DROPDOWNLIST = "xpath=//label[contains(text(),'State / province')]//following-sibling::select[@id='Address_StateProvinceId']";
	
	//Pattern Object
	public static final String DELETE_BUTTON_ADDRESS_SECTION = "xpath=//strong[text()='%s']//parent::div[@class='title']//following-sibling::div[@class='buttons']//button[text()='Delete']";
}
