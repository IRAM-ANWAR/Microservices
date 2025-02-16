package com.learning.springbasics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springbasics.model.Employee;
import com.learning.springbasics.service.EmployeeService;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

	private EmployeeService employeeService;

	EmployeeV2Controller(@Qualifier("employeeV2ServiceImpl") EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@DeleteMapping(value = "/{id}")
	public String deleteEmployeeById(@PathVariable("id") String id) {
		return this.employeeService.deleteEmployeeById(id);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return this.employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		return this.employeeService.getEmployeeById(id);
	}

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}
}