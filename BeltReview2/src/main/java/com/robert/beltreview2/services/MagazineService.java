package com.robert.beltreview2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.beltreview2.models.Magazine;
import com.robert.beltreview2.repositories.MagazineRepository;

@Service
public class MagazineService {
	
	@Autowired
	private MagazineRepository magazineRepo;

	public MagazineService() {
		// TODO Auto-generated constructor stub
	}
	
	public Magazine getOne(Long id) {
		Optional<Magazine> magazine = magazineRepo.findById(id);
		return magazine.isPresent() ? magazine.get() : null;
	}

	public List<Magazine> getAll() {
		return (List<Magazine>) magazineRepo.findAll();
	}

	public Magazine create(Magazine magazine) {
		return magazineRepo.save(magazine);
	}

	public Magazine update(Magazine magazine) {
		return magazineRepo.save(magazine);
	}

	public void delete(Long id) {
		magazineRepo.deleteById(id);
	}

}
