package com.usp.medicare.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.constants.DMSHeaderInd;
import com.usp.medicare.dto.DmsDTO;
import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.dto.UserInfoDTO;
import com.usp.medicare.entity.UserInfo;
import com.usp.medicare.service.DMSService;
import com.usp.medicare.service.UserInfoService;
import com.usp.medicare.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private DMSService dmsService;

	@Autowired
	private ModelMapper modelMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/getUserByUserId/{userId}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		LOGGER.info("userid ====> " + userId);
		return userService.fetchUserById(userId);
	}

	@GetMapping("/get/UserByMobileNumber/{userMobile}")
	public UserDTO getUserByUserMobile(@PathVariable String userMobile) {
		return userService.getUserByMobile(userMobile);
	}

	/**
	 * Method to get the user 
	 * @param user
	 * @return
	 */
	/*
	 * @PostMapping(path = "/get/f", consumes = "application/json") public UserDTO
	 * fetchUser(@RequestBody UserDTO user) { return userService.fetchUser(user); }
	 */
	/**
	 * Method to create new user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/RegisterNewUser", consumes = "application/json")
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
			
			UserInfo userInfo = userInfoService.saveUserInformation(userInfoDto);

			DmsDTO dmsDTO = userInfoDto.getDmsDTO();
			
			if(dmsDTO !=null) {
			dmsDTO.setHeaderTableId(userInfo.getId());
			dmsDTO.setHeaderTableConstant(DMSHeaderInd.PROFILE_PHOTO.toString());
			dmsDTO.setUserId(userInfo.getId());
			dmsDTO = dmsService.uploadDocument(dmsDTO);
			}

			userInfoDto = modelMapper.map(userInfo, UserInfoDTO.class);
			userInfoDto.setDmsDTO(dmsDTO);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return userInfoDto;
	}
	
	@GetMapping("/get/fetchUserInfo/{userId}")
	public UserInfoDTO fetchUserInfo(@PathVariable String userId) {
		return userInfoService.getUserInfo(userId);
	}
	

}
