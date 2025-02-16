package com.learning.springbasics.model;

public class User {

	private String id;
	private String name;
	private String emailId;

	public String getEmailId() {
		return this.emailId;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
