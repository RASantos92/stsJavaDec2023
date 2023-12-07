package com.robert.mvconetomanydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.mvconetomanydemo.models.Donation;
import com.robert.mvconetomanydemo.models.User;
import com.robert.mvconetomanydemo.services.DonationService;
import com.robert.mvconetomanydemo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private final UserService userServ;
	
	private final DonationService donationServ;

	public HomeController(UserService userServ,DonationService donationServ) {
		this.userServ = userServ;
		this.donationServ = donationServ;
	}
	
	@GetMapping("")
	public String index() {
		return "main/dashboard.jsp";
	}
	
	
	@GetMapping("/user/create")
	public String createUser(@ModelAttribute("user") User user) {
		return "user/create.jsp";
	}
	
	
	@PostMapping("/user/process/create")
	public String processCreateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/create.jsp";
		}
		userServ.create(user);
		return "redirect:/home";
	}
	
	@GetMapping("/donation/create")
	public String createDonation(@ModelAttribute("donation") Donation donation, Model model) {
		
		model.addAttribute("allUsers", userServ.getAll());
		return "donation/create.jsp";
	}
	
	
	@PostMapping("/donation/process/create")
	public String processCreateDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/create.jsp";
		}
		
		donationServ.create(donation);
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	
	
	

}
