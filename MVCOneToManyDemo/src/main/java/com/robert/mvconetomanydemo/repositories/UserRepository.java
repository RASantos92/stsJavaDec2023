package com.robert.mvconetomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robert.mvconetomanydemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findAll();
}
