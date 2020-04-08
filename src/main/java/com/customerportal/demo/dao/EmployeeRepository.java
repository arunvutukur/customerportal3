package com.customerportal.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customerportal.demo.entity.Employee;;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//No need to write CRUD ->FINDALL/FIND stuff as jpa takes care of it

}
