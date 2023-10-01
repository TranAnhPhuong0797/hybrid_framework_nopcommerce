package javabasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_19_JAVA_FAKER {
	public static void main(String[] args) {
		// fake data US
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());
		System.out.println(faker.finance().creditCard(CreditCardType.VISA));
		
		// Fake data VI
		Faker fakerVI = new Faker(new Locale("vi"));
		System.out.println(fakerVI.address().firstName());
		System.out.println(fakerVI.address().lastName());
		System.out.println(fakerVI.address().city());
	}
}
