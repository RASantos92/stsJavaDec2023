package com.robert.mvcdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robert.mvcdemo.models.Donation;
import com.robert.mvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class DonationApiController {

	private final DonationService donationServ;
	public DonationApiController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/donations")
	public List<Donation> findAllDonations(){
		return donationServ.getAll();
	}
	
	@PostMapping("/donations")
	public Donation createDonation(@RequestParam("donationName") String donationName,@RequestParam("donor") String donor, @RequestParam("quantity") Integer quantity) {
		Donation newDonation = new Donation(donationName, donor,quantity);
		
		return donationServ.create(newDonation);
	}
	
	
	
	//-------------FIND ONE (/donations/{id})----------------
	@GetMapping("/donations/{id}")
	public Donation oneDonation(@PathVariable("id") Long id) {
		return donationServ.getOne(id);
	}
	
	//-------------Edit (/donations/{id})----------------
	
	//1. id from the @PathVariable
	//2. data from the @RequestParam
	@PatchMapping("/donations/{id}")
	public Donation editDonation(@PathVariable("id") Long id,@RequestParam("donationName") String donationName,@RequestParam("donor") String donor, @RequestParam("quantity") Integer quantity) {
		Donation possibleDonation = donationServ.getOne(id);
		if(possibleDonation == null) {
			return null;
		}
		Donation donationToEdit = new Donation(id, donationName,donor,quantity);
		
		return donationServ.edit(donationToEdit);
	}
	
	
	//-------------Delete (/donations/{id})----------------
	
	@DeleteMapping("/donations/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "You have deleted " + id + " id";
	}
	
	
	
	
	
	
	
	

}
