package com.robert.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robert.beltreview.models.Donation;
import com.robert.beltreview.repositories.DonationRepository;

@Service
public class DonationService {
	
//	@Autowired
//	private DonationRepository donationRepo;
	
	private final DonationRepository donationRepo;

	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public Donation getOne(Long id) {
		Optional<Donation> donation = donationRepo.findById(id);
		return donation.isPresent() ? donation.get() : null;
	}

	public List<Donation> getAll() {
		return (List<Donation>) donationRepo.findAll();
	}

	public Donation create(Donation donation) {
		return donationRepo.save(donation);
	}

	public Donation update(Donation donation) {
		return donationRepo.save(donation);
	}

	public void delete(Long id) {
		donationRepo.deleteById(id);
	}

}
