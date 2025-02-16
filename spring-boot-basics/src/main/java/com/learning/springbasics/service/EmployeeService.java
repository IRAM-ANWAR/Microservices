package com.learning.springbasics.service;

import java.util.List;

import com.learning.springbasics.model.Employee;

public interface EmployeeService {

	String deleteEmployeeById(String id);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String id);

	Employee save(Employee employee);
}