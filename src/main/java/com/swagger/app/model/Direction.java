package com.swagger.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "directions")
public class Direction {

	@Id
	@Column()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private int number;
	
	@ManyToOne
	@JoinColumn(name = "fk_user", nullable = false)
	private User user;

	public Direction(String city, String street, int number, User user) {
		super();
		this.city = city;
		this.street = street;
		this.number = number;
		this.user = user;
	}

	public Direction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
