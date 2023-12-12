package com.robert.beltreview2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.beltreview2.services.MagazineService;
import com.robert.beltreview2.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private MagazineService magazineServ;

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users";
		}
		
		model.addAttribute("user", userServ.getUser((Long)session.getAttribute("user_id")));
		model.addAttribute("allMagazines", magazineServ.getAll());
		
		return "home/dashboard.jsp";	
	}

}
