package com.customerportal.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerportal.demo.entity.Fitness;

public interface FitnessRepository extends JpaRepository<Fitness, Integer> {

}
