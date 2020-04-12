package com.customerportal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.customerportal.demo.entity.Fitness;

public class FitnessServiceImpl implements FitnessService {

private com.customerportal.demo.dao.FitnessRepository FitnessRepository;
	
	//private fitnessTrackerDAO fitnessTrackerDAO;
	
	@Autowired
	public FitnessServiceImpl(com.customerportal.demo.dao.FitnessRepository thefitnessRepository) {
	
		FitnessRepository = thefitnessRepository;
	}	
	
	public FitnessServiceImpl() {
		
	}

	@Override
	public List<Fitness> findAll() {
		
		return FitnessRepository.findAll();
	}

	@Override
	public Fitness findById(int theId) {
	
		Optional<Fitness> result = FitnessRepository.findById(theId);
		
		Fitness thefitness =null;
		
		if(result.isPresent()) {
			
			thefitness =result.get();
		}else {
			
			throw new RuntimeException("Did not find fitness id- " + theId);
		}
				
		return thefitness;	
	}

	@Override
	public void save(Fitness thefitness_tracker) {

		FitnessRepository.save(thefitness_tracker);
	}

	@Override
	public void deleteById(int theId) {
	
		FitnessRepository.deleteById(theId);
		
	}

	

}
