package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
//	private Locale local = new Locale("vi");
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getCity() {
		return faker.address().city();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}
	
	public String getCompany() {
		return faker.company().name();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getPassword() {
		return faker.internet().password(10000, 100000, true, true);
	}
	

	//First name; Last Name; Email; City; City name; Company; Phone number
}
