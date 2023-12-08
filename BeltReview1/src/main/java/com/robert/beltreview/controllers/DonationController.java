package com.robert.beltreview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.beltreview.models.Donation;
import com.robert.beltreview.services.DonationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/donations")
public class DonationController {
	
	@Autowired
	private DonationService donationServ;

	public DonationController() {}
	
	@GetMapping("/create")
	public String createDonation(@ModelAttribute("donation") Donation donation, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		return "donation/create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/create.jsp";
		}
		
		donationServ.create(donation);
		return "redirect:/home";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "donation/edit.jsp";
	}
	
	
	@PatchMapping("/process/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/edit.jsp";
		}
		donationServ.update(donation);
		return "redirect:/home";
	}
	
	
	@GetMapping("/display/{id}")
	public String showOneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "donation/showOne.jsp";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
