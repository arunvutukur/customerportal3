package com.customerportal.demo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/rest")
@Slf4j
public class PostController {

	@Autowired
	private RestTemplate restTemplate;
		
	@GetMapping("/posts")
	public List<Object> getPosts(){
		
		String url ="https://jsonplaceholder.typicode.com/posts";
		Object[] objects =restTemplate.getForObject(url, Object[].class);
		//Object[] objects2 =restTemplate.get
		return Arrays.asList(objects);
		
	}
	

}
