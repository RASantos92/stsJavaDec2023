package com.robert.sessionformdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("")
	public String setCount(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		
		return "counterPage.jsp";
	}
	
	@GetMapping("/get/count")
	public String getCount() {
		return "countGet.jsp";
	}
	// localhost:8080/search?keyword=whateverWePutIn
	
	@GetMapping("/search")
	public String searchForm() {
		return "getForm/searchForm.jsp";
	}
	
	@GetMapping("/display")
	public String displayForm(@RequestParam("keyword") String searchValue, Model model) {
		model.addAttribute("searchValue", searchValue);
		return "getForm/displaySearchForm.jsp";
	}
	
	@GetMapping("/review/form")
	public String reviewForm() {
		return "postForm/reviewForm.jsp";
	}
	
	@PostMapping("/review/process")
	public String displayReviewForm(@RequestParam("movie") String movie, @RequestParam("comment") String comment, @RequestParam("rating") Integer rating, HttpSession session) {
		session.setAttribute("movie", movie);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		
		return "redirect:/home/review/display";
	}
	
	@GetMapping("/review/display")
	public String reviewDisplay(){
		return "postForm/display.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
