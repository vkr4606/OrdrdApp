package com.ordrd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordrd.model.User;
import com.ordrd.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable(value = "userId") String userId) {
		return userService.findById(Integer.parseInt(userId));
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public List<ObjectError> createUser(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return allErrors;
		}
		userService.insert(user);
		return new ArrayList<ObjectError>(0);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.POST)
	public List<ObjectError> updateUser(@PathVariable(value = "userId") String userId,
			@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return allErrors;
		}
		user.setId(Integer.parseInt(userId));
		userService.update(user);
		return new ArrayList<ObjectError>(0);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(value = "userId") String userId) {
		userService.delete(Integer.parseInt(userId));
	}
}
