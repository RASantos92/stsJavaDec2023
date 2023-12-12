package com.robert.beltreview2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robert.beltreview2.models.Magazine;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {
	List<Magazine> findAll();
}
