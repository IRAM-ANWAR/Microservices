package com.learning.springbasics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learning.springbasics.error.EmployeeNotFoundException;
import com.learning.springbasics.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	List<Employee> employees = new ArrayList<>();

	@Override
	public String deleteEmployeeById(String id) {
		Employee employee = this.employees.stream().filter(e -> e.getEmployeeId().equalsIgnoreCase(id)).findFirst()
		        .orElse(null);

		if (employee != null) {
			this.employees.remove(employee);
			return "Employee deleted with the id: " + id;
		}
		return "Employee Not Found";
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		return this.employees.stream().filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id)).findFirst()
		        .orElseThrow(() -> new EmployeeNotFoundException("" + "Employee not found with Id: " + id));
	}

	@Override
	public Employee save(Employee employee) {

		if (employee.getEmployeeId() == null || employee.getEmailId().isEmpty())
			employee.setEmployeeId(UUID.randomUUID().toString());
		this.employees.add(employee);
		return employee;
	}

}
