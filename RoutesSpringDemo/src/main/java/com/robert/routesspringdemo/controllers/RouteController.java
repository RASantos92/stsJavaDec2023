package com.robert.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
	
	// query parameter: ...search?keyword=whatever&age=5 / usually seen when you send form information through a get request
    // localhost:8080/search?keyword=whatever
    // example: 1
	//http://localhost:8080/route/pet?keyword=huskies&age=5
	@GetMapping("/pet")
	public String getPet(@RequestParam("keyword") String keyword,@RequestParam("age") Integer age ) {
		return "Your pet " + keyword + " is " + age + " years old";
	}
	
	@GetMapping("/optional/pet")
	public String getPetOptional(@RequestParam(value="name", required=false) String name) {
		if(name == null) {
			return "name is not avaliable";
		}
		if(name.equals("narla")) {
			return ".equals works";
		}
		
		return "your pet name is " + name;
	}
	
	//https://login.codingdojo.com/m/315/9532/64273
	
	@GetMapping("/path/m/{name}/{color}")
	public String petWithColor(@PathVariable("name") String name, @PathVariable("color") String color) {
		return name + " is " + color;
	}
	
	
	
	
	
	

}
