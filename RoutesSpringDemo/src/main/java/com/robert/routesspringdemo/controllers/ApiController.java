package com.robert.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	// option 1 : request mapping default: GET
	@RequestMapping("/option/1")
	public String option1() {
		return "Option 1 request mapping";
	}
	
	// option 2: explicitly set request method
	@RequestMapping(value="/option/2",method = RequestMethod.GET)
	public String option2() {
		return "Option 2 request Mapping";
	}
	
	// option 3: my preffred method.
	@GetMapping("/option/3")
	public String option3() {
		return "option 3 request mapping";
	}
	
	
	
	

}
