package com.customerportal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.customerportal.demo.dao.EmployeeRepository;
import com.customerportal.demo.entity.Employee;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

	
	//private EmployeeDAO employeeDAO;
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
	
		employeeRepository = theemployeeRepository;
	}	
	
	public EmployeeServiceImpl() {
		
	}

	@Override
	public List<Employee> findAll() {
	
		return employeeRepository.findAll();
	}

	@Override	
	public Employee findById(int theId) {
	
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee =null;
		
		if(result.isPresent()) {
			
			theEmployee =result.get();
		}else {
			
			throw new RuntimeException("Did not find employee id- " + theId);
		}
				
		return theEmployee;
	}

	@Override	
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override	
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
