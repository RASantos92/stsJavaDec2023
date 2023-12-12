package com.robert.manytomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.manytomany.models.Game;
import com.robert.manytomany.models.Genre;
import com.robert.manytomany.services.GameService;
import com.robert.manytomany.services.GenreService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/games/genres")
public class GameGenreController {
	
	@Autowired
	private GameService gameServ;
	
	@Autowired
	private GenreService genreServ;

	public GameGenreController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/create/genre")
	public String createGenre(@ModelAttribute("genre") Genre genre) {
		return "game_genre/createGenre.jsp";
	}
	
	
	@GetMapping("/create/game")
	public String createGame(@ModelAttribute("game") Game game) {
		return "game_genre/createGame.jsp";
	}
	
	
	@PostMapping("/process/create/game")
	public String CreateGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "game_genre/createGame.jsp";
		}
		genreServ.createGameWithGenre(game);
		return "redirect:/games/genres/create/game";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
