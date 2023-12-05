package com.robert.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robert.mvcdemo.models.Donation;
import com.robert.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {
	
	private final DonationRepository donationRepo;

	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public List<Donation> getAll(){
		return donationRepo.findAll();
	}
	
	public Donation create(Donation donation) {
		return donationRepo.save(donation);
	}
	
	public Donation getOne(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
//		if(optionalDonation.isPresent()) {
//			return optionalDonation.get();
//		}else {
//			return null;
//		}
		return optionalDonation.isPresent() ? optionalDonation.get() : null;
	}
	
	
	public Donation edit(Donation donation) {
		return donationRepo.save(donation);
	}
	
	
	public void delete(Long id) {
		donationRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
