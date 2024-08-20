package com.crud.user.model;

public class User {
	private int id;
	private String email;
	private String address;
	private String fullName;
	private String password;
	private String phone;

	
	
	public User(String email, String password, String fullName, String address, String phone) {
		super();
		this.email = email;
		this.address = address;
		this.fullName = fullName;
		this.password = password;
		this.phone = phone;
	}

	public User(int id, String email, String password, String fullName, String address, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.fullName = fullName;
		this.password = password;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
