package com.usp.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	

	@GetMapping("/get/{id}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		return new UserDTO();
	}

	@PostMapping(path="/fetchUser",consumes = "application/json")
	public UserDTO fetchUser(@RequestBody UserDTO user) {
		return userService.fetchUser(user);
	}
	/**
	 * Method to create new user
	 * @param user
	 * @return
	 */
	@PostMapping(path="/createUser",consumes = "application/json")
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.registerUser(user);
	}

}
