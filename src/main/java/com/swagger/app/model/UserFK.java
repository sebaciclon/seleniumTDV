package com.swagger.app.model;

public class UserFK {

	private Long fk_user;
	private String city;
	private String street;
	private int number;

	public Long getFk_user() {
		return fk_user;
	}

	public void setFk_user(Long fk_user) {
		this.fk_user = fk_user;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
}
