package com.robert.manytomany.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.manytomany.models.Game;
import com.robert.manytomany.models.Genre;
import com.robert.manytomany.repositories.GameRepository;
import com.robert.manytomany.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private GameRepository gameRepo;

	public GenreService() {
		// TODO Auto-generated constructor stub
	}
	
	public Genre getOne(Long id) {
		Optional<Genre> genre = genreRepo.findById(id);
		return genre.isPresent() ? genre.get() : null;
	}

	public List<Genre> getAll() {
		return (List<Genre>) genreRepo.findAll();
	}

	public Genre create(Genre genre) {
		return genreRepo.save(genre);
	}

	public Genre update(Genre genre) {
		return genreRepo.save(genre);
	}

	public void delete(Long id) {
		genreRepo.deleteById(id);
	}
	
	
//	*************************create game with genre logic****************************
	
	public Genre getOne(String name) {
		Optional<Genre> genre = genreRepo.findByName(name);
		return genre.isPresent() ? genre.get() : null;
	}
	
	
	public Genre createGenreIfNotInDatabase(String genreName) {
		if(this.getOne(genreName) == null) {
			Genre newGenre = new Genre();
			newGenre.setName(genreName);
			return genreRepo.save(newGenre);
		}
		return this.getOne(genreName);
	}
	
	
	
	

	public Game createGameWithGenre(Game game) {
		String[] genresFromForm = game.getFormGenres().split(",");
		ArrayList<Genre> genresToBeAdded = new ArrayList<Genre>();
		for(String genre: genresFromForm)
		{
			genresToBeAdded.add(this.createGenreIfNotInDatabase(genre));
		}
		game.setGenres(genresToBeAdded);
		return gameRepo.save(game);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
