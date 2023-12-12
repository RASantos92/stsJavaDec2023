package com.robert.beltreview2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.beltreview2.models.Magazine;
import com.robert.beltreview2.services.MagazineService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/magazines")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineServ;

	public MagazineController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/create")
	public String createMagazine(@ModelAttribute("magazine") Magazine magazine, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users";
		}
		return "magazine/create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateMagazine(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result) {
		if(result.hasErrors()) {
			return "magazine/create.jsp";
		}
		magazineServ.create(magazine);
		return "redirect:/home";
	}
	
	@GetMapping("/display/{id}")
	public String displayMagazine(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users";
		}
		model.addAttribute("magazine", magazineServ.getOne(id));
		return "magazine/showOne.jsp";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteMagazine(@PathVariable("id") Long id) {
		magazineServ.delete(id);
		return "redirect:/home";
	}
	
	
	
	
	
	

}
