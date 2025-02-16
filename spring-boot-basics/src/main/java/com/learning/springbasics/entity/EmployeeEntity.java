package com.learning.springbasics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tbl")
public class EmployeeEntity {
	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String department;

	public String getDepartment() {
		return this.department;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}