package com.robert.loginandreg.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("")
	public String index() {
		return "main/dashboard.jsp";
	}

}
