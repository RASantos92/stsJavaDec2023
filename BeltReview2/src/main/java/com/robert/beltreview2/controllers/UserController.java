package com.robert.beltreview2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.beltreview2.models.LoginUser;
import com.robert.beltreview2.models.User;
import com.robert.beltreview2.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServ;

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("")
	public String loginRegPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "user/loginReg.jsp";
	}

	@PostMapping("/process/register")
	public String processRegForm(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpSession session) {
		if (!user.getPassword().equals(user.getConfirm())) {
			results.rejectValue("password", "Match", "Confirm Password must match Password!");
		}
		if (userServ.getUser(user.getEmail()) != null) {
			results.rejectValue("email", "Unique", "Email already in use!");
		}
		if (results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.create(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}

	@PostMapping("/process/login")
	public String processLoginFrom(@Valid @ModelAttribute("loginUser") LoginUser user, BindingResult results,
			Model model, HttpSession session) {
		User loggingUser = userServ.login(user, results);
		if (results.hasErrors()) {
			model.addAttribute("user", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, Model model,HttpSession session) {
		if( session.getAttribute("user_id") == null) {
			return "redirect:/users";
		}
		model.addAttribute("user", userServ.getUser(id));
		return "user/edit.jsp";
	}
	
	@PatchMapping("/process/edit/{id}")
	public String processUpdateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "user/edit.jsp";
		}
		userServ.update(user);
		return "redirect:/home";
	}
	
	

}
