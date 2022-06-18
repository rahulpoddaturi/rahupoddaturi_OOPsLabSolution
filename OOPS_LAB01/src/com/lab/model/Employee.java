package com.lab.model;

public class Employee {
	String FirstName;
	String LastName;
	String Password;
	String EmailId; 
    
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName) {
		super();
		FirstName = firstName;
		LastName = lastName;
	}

}
