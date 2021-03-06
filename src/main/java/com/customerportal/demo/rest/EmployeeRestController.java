package com.customerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerportal.demo.entity.Employee;
import com.customerportal.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

//@RestController ->simply returns the object and object data is directly written into HTTP response as JSON or XML
@Controller //Controller returns in the form of model as we need it to view in thymleaf template(is to create a Map of the model object and find a view
@RequestMapping("/employees")
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
			
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
			
	// create model attribute to bind form data
		
		Employee theEmployee =new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";	
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	//you get 405 errors if its not proper format or wrong Mapping like using GET instead of POST
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "employees/employee-form";			
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/employees/list";
		
	}
		
}
