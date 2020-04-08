package com.customerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerportal.demo.entity.Employee;
import com.customerportal.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

//@RestController ->simply returns the object and object data is directly written into HTTP response as JSON or XML
@Controller //Controller returns in the form of model as we need it to view in thymleaf template(is to create a Map of the model object and find a view
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//private EmployeeDAO employeeDAO;
		// Quick and Dirty: Inject employee DAO
//	@Autowired
//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {		
//		employeeDAO =theEmployeeDAO;
//	}
	//Refactored the code to use employee service
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {		
		employeeService =theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
			
			// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
			
			// add to the spring model
		theModel.addAttribute("employees", theEmployees);
			
		return "list-employees";
	}
	
	
//	// Expose "/employees" and return list of employees
//	@GetMapping("/employees")
//	public List<Employee> findAll(){
//		//return employeeDAO.findAll();
//		return employeeService.findAll();
//	}
//	
//	@GetMapping("/employees/{employeeId}")
//	public Employee getEmployee(@PathVariable int employeeId) {
//		
//		Employee theEmployee =employeeService.findById(employeeId);
//		
//		if( theEmployee ==null) {
//			throw new RuntimeException("the employee is not found " + employeeId);
//		}
//		
//		return theEmployee;		
//	}
//
//	@PutMapping("/employees")
//	public Employee addEmployee(@RequestBody Employee theEmployee) {
//		
//		
//		//this is to force save of new item...instead of update and also just set incase they pass any id
//		//in Json so set id to 0
//		theEmployee.setId(0);
//		employeeService.save(theEmployee);		
//		return theEmployee;
//		
//	}
//	
//	@DeleteMapping("/employees/{employeeId}")
//	public String deleteEmployee(@PathVariable int employeeId){
//		
//		Employee theEmployee =employeeService.findById(employeeId);
//		
//		if( theEmployee ==null) {
//			throw new RuntimeException("the employee id not found " + employeeId);
//		}
//		
//		employeeService.deleteById(employeeId);	
//		return "Deleted EmployeeId " +employeeId;	
//		
//	}
//	
//	
//	@GetMapping("/hello")
//	public String HelloWorld() {
//	
//		return "Hello World";
//	}
//	
//	@GetMapping("/")
//	public String index() {
//		return "Greetings from Spring Boot!";
//	}
		
}
