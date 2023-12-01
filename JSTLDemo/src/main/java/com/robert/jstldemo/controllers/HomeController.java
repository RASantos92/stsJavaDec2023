package com.robert.jstldemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/java/demo")
	public String demo() {
		return "demo.jsp";
	}
	
	@GetMapping("/jstl/demo")
	public String jstlDemo(Model model) {
		String name = "Abel Zehrt";
		Integer age = 26;
		Boolean isHungry = true;
		
		ArrayList<String> users = new ArrayList<String>();
		
		users.add("bobby brown");
		users.add("mayank patel");
		users.add("turuchie networks");
		users.add("jacob");
		
		model.addAttribute("nameFromController", name);
		model.addAttribute("ageFromController", age);
		model.addAttribute("isHungryFromController", isHungry);
		model.addAttribute("listOfUsersFromController", users);
		
		return "jstlDemo.jsp";
	}
	
	

}
