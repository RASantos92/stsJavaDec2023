package com.robert.springdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping("/api")
	public String apiTest() {
		return "Hello world";
	}
	
	
	@RequestMapping("/api/number")
	public int apiNumber() {
		return 5;
	}

}
