package com.robert.beltreview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.beltreview.services.DonationService;
import com.robert.beltreview.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private DonationService donationServ;
	
	@Autowired
	private UserService userServ;

	public HomeController() {}
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allDonations", donationServ.getAll());
		return "main/dashboard.jsp";
	}
	

}
