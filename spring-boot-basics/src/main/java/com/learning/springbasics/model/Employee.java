package com.learning.springbasics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;

	@JsonIgnore
	private String department;
}
