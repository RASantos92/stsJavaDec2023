package com.robert.routesspringdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("someData", "this is some data");
		return "index.jsp";
	}

}
