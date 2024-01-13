package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;
import io.reactivex.rxjava3.subjects.Subject;

public class UserDataMapper {
	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("emailaddress")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("login")
	private List<String> login;

	@JsonProperty("sport")
	private List<Subject> sports;

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/resources/UserData.json"),
					UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Subject> getSports() {
		return sports;
	}

	public static class Sport {
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("point")
		private Float point;

		public String getName() {
			return name;
		}

		public Float getPoint() {
			return point;
		}
	}

	public List<String> getLogin() {
		return login;
	}

	public static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}
}
