package com.ordrd.controller.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordrd.model.UserQuery;
import com.ordrd.service.UserQueryService;

@RestController
public class UserQueryController {

	@Autowired
	private UserQueryService userQueryService;

	@RequestMapping(value = "/user-queries/{userQueryId}", method = RequestMethod.GET)
	public ResponseEntity<UserQuery> getUserQueryById(
			@PathVariable(value = "userQueryId") String userQueryId) {
		UserQuery userQuery = userQueryService.findById(Integer.parseInt(userQueryId));
		return ResponseEntity.status(HttpStatus.OK).body(userQuery);
	}

	@RequestMapping(value = "/user-queries", method = RequestMethod.GET)
	public ResponseEntity<List<UserQuery>> getUserQueryList() {
		List<UserQuery> userQueryList = userQueryService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(userQueryList);
	}

	@RequestMapping(value = "/user-queries", method = RequestMethod.POST)
	public ResponseEntity<?> createUserQuery(@Valid UserQuery userQuery, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		userQueryService.insert(userQuery);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path(String.valueOf(userQuery.getId())).build().toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(locationUri).build();
	}

	@RequestMapping(value = "/user-queries/{userQueryId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUserQuery(
			@PathVariable(value = "userQueryId") String userQueryId, @Valid UserQuery userQuery,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		userQuery.setId(Integer.parseInt(userQueryId));
		userQueryService.update(userQuery);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/user-queries/{userQueryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserQuery(
			@PathVariable(value = "userQueryId") String userQueryId) {
		userQueryService.delete(Integer.parseInt(userQueryId));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
