package com.robert.mvcdemo.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.robert.mvcdemo.models.Donation;
import com.robert.mvcdemo.services.DonationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/donations")
public class DonationController {
	
	private final DonationService donationServ;

	public DonationController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/all")
	public String showAllDonations(Model model,@RequestParam(value="searchValue", required=false) String searchValue) {
		if(searchValue != null) {
			model.addAttribute("allDonations", donationServ.findByDonationName(searchValue));
			return "/donation/showAll.jsp";
		}
		model.addAttribute("allDonations", donationServ.getAll());
		return "/donation/showAll.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String showOneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDonation", donationServ.getOne(id));
		return "/donation/showOne.jsp";
	}
	
	@GetMapping("/new")
	public String newDonation(@ModelAttribute("donation") Donation donation) {
		return "/donation/create.jsp";
	}
	
	@PostMapping("/process/new")
	public String createDonation(@Valid @ModelAttribute("donation") Donation newDonation, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/donation/create.jsp";
		}
		
		donationServ.create(newDonation);
		return "redirect:/donations/all";
	}

	
	@GetMapping("/edit/{id}")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "/donation/edit.jsp";
	}
	
	@PatchMapping("/process/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {

		if(result.hasErrors()) {
			return "/donation/edit.jsp";
		}
		donationServ.edit(donation);
		return "redirect:/donations/all";
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect:/donations/all";
	}
	
	
	
	
	
	
	
	
	
	
	
}
