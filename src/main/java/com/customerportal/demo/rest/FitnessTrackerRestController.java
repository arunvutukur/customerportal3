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

import com.customerportal.demo.entity.Fitness;
import com.customerportal.demo.service.FitnessService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/food")
@Slf4j
public class FitnessTrackerRestController {
	
	private FitnessService fitnessService;

	//Refactored the code to use employee service
	@Autowired
	public FitnessTrackerRestController(FitnessService thefitnessTrackerService) {	
		
		fitnessService =thefitnessTrackerService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
			
			// get employees from db
		List<Fitness> thefitness = fitnessService.findAll();
			
			// add to the spring model
		theModel.addAttribute("fitness", thefitness);		
		
		//System.out.println(thefitness.toString());
			
		return "food/fitnesstracker";
	}
	
	
	@GetMapping("/hello")
	public String Hello_World() {
	
		System.out.println("Mapped to Hello World");
		
		return "food/fitnesstracker";
	}
	
	
	
	
	
	
	
	
	
//	@GetMapping("/food")
//	public List<fitness> findAll(){
//
//		return fitnessTrackerService.findAll();
//	}	
//	@GetMapping("/food/{foodId}")
//	public fitness getEmployee(@PathVariable int foodId) {
//		
//		fitness thefitness_tracker =fitnessTrackerService.findById(foodId);
//		
//		if( thefitness_tracker ==null) {
//			throw new RuntimeException("the employee is not found " + foodId);
//		}
//		
//		return thefitness_tracker;		
//	}
//
//
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
//		
}
