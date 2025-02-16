package com.learning.springbasics.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.learning.springbasics.entity.EmployeeEntity;
import com.learning.springbasics.model.Employee;
import com.learning.springbasics.repository.EmployeeRepository;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	EmployeeV2ServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public String deleteEmployeeById(String id) {
		this.employeeRepository.deleteById(id);
		return "Employee deleted with the id: " + id;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntityList = this.employeeRepository.findAll();

		List<Employee> employees = employeeEntityList.stream().map(employeeEntity -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			return employee;
		}).collect(Collectors.toList());

		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		EmployeeEntity employeeEntity = this.employeeRepository.findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

	@Override
	public Employee save(Employee employee) {

		if (employee.getEmployeeId() == null || employee.getEmailId().isEmpty())
			employee.setEmployeeId(UUID.randomUUID().toString());

		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		BeanUtils.copyProperties(this.employeeRepository.save(entity), employee);
		return employee;
	}
}