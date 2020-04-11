package com.customerportal.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customerportal.demo.entity.Employee;;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//No need to write CRUD ->FINDALL/FIND stuff as jpa takes care of it
	
	//Custom methods or anything u can specify here and invoke the samething in service class
	
	// add a method to sort by last name
		public List<Employee> findAllByOrderByLastNameAsc();

}
