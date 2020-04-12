package com.customerportal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customerportal.demo.dao.FitnessRepository;
import com.customerportal.demo.entity.Fitness;

@Repository
public class FitnessServiceImpl implements FitnessService {

	//private fitnessTrackerDAO fitnessTrackerDAO;
	
	private FitnessRepository FitnessRepository;
	
	
	@Autowired
	public FitnessServiceImpl(FitnessRepository thefitnessRepository) {
	
		FitnessRepository = thefitnessRepository;
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
