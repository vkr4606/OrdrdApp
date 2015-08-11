package com.ordrd.controller.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordrd.model.User;
import com.ordrd.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "true");
		}
		if (logout != null) {
			model.addAttribute("logout", "true");
		}
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			System.out.println(allErrors);
			return "register";
		}

		if (user.getUsername() == null) {
			user.setUsername(user.getEmailId());
		}
		user.setRole("ROLE_ADMIN");
		user.setActiveFlag(true);
		userService.insert(user);
		return "redirect:/welcome";
	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Custom Login Form");
		model.addAttribute("message", "This is welcome page!");
		return "welcome";
	}

}
