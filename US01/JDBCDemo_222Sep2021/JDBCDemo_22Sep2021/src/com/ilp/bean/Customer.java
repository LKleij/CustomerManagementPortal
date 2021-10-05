package com.ilp.bean;

public class Customer {
	private String Password;
	private String Name;
	private String ContactNumber;
	private String Address;
	private String email;
	
	public Customer(String Password, String Name, String ContactNumber, String Address, String email) {
		super();
		this.Password = Password;
		this.Name = Name;
		this.ContactNumber = ContactNumber;
		this.Address = Address;
		this.email = email;
	}
	
	public Customer(){
		
	}
	

	public Customer(int i, String string, int j, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
