package com.usp.medicare.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.dto.UserInfoDTO;
import com.usp.medicare.entity.UserInfo;
import com.usp.medicare.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/get/{userId}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		return new UserDTO();
	}

	@GetMapping("/get/mob/{userMobile}")
	public UserDTO getUserByUserMobile(@PathVariable String userMobile) {
		return userService.getUserByMobile(userMobile);
	}

	@PostMapping(path = "/get/fetchUser", consumes = "application/json")
	public UserDTO fetchUser(@RequestBody UserDTO user) {
		return userService.fetchUser(user);
	}

	/**
	 * Method to create new user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/createUser", consumes = "application/json")
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.registerUser(user);
	}

	/**
	 * Method to save user information
	 * 
	 * @param userInfoDto
	 * @return
	 */
	@PostMapping(path = "/saveUserInfo", consumes = "application/json")
	public UserInfoDTO saveUserInfo(@RequestBody UserInfoDTO userInfoDto) {
		try {
			UserInfo userInfo = userService.saveUserInformation(userInfoDto);
			userInfoDto = modelMapper.map(userInfo, UserInfoDTO.class);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return userInfoDto;
	}

}
