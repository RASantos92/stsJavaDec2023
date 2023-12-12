package com.robert.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.manytomany.models.Game;
import com.robert.manytomany.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;
	
	public GameService() {
		// TODO Auto-generated constructor stub
	}

	public Game getOne(Long id) {
		Optional<Game> game = gameRepo.findById(id);
		return game.isPresent() ? game.get() : null;
	}

	public List<Game> getAll() {
		return (List<Game>) gameRepo.findAll();
	}

	public Game create(Game game) {
		return gameRepo.save(game);
	}

	public Game update(Game game) {
		return gameRepo.save(game);
	}

	public void delete(Long id) {
		gameRepo.deleteById(id);
	}
}
