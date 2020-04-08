package com.customerportal.demo.service;

import java.util.List;
import java.util.Optional;

import com.customerportal.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
