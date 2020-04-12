package com.customerportal.demo.service;

import java.util.List;

import com.customerportal.demo.entity.Fitness;

public interface FitnessService {
	

	public List<Fitness> findAll();
	
	public Fitness findById(int theId);
	
	public void save(Fitness theFitness);	
	
	public void deleteById(int theId);
	

}
