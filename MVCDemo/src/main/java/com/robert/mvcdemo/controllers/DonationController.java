package com.robert.mvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.mvcdemo.services.DonationService;

@Controller
@RequestMapping("/donations")
public class DonationController {
	
	private final DonationService donationServ;

	public DonationController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/all")
	public String showAllDonations(Model model) {
		model.addAttribute("allDonations", donationServ.getAll());
		return "/donation/showAll.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String showOneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDonation", donationServ.getOne(id));
		return "/donation/showOne.jsp";
	}

}
