package com.robert.loginandreg.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.loginandreg.models.LoginUser;
import com.robert.loginandreg.models.User;
import com.robert.loginandreg.services.UserService;

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
	
	@GetMapping("/login/register")
	public String loginRegUser(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "user/loginReg.jsp";
	}
	
	
	@PostMapping("/process/register")
	public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// reject if email is taken
		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}
		//reject if passwords dont match
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "passwords dont match");
		}
		//redirect if errors
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		
		return "redirect:/home";
	}
	
	
	@PostMapping("/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		
		User loggingUser = userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/home";
	}

}
