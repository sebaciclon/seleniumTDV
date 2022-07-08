package com.swagger.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -939859442104240311L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	@Column(length = 200,nullable = false)
	private String surname;
	
	@Column(length = 200,nullable = false)
	private String email;
	
	@Column(length = 200,nullable = false)
	private int edad;

	public User(Long id, String name, String surname, String email, int edad) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.edad = edad;
	}

	public User() {
		super();
	}

	public User(String name, String surname, String email, int edad) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
