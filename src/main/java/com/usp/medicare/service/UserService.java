package com.usp.medicare.service;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usp.medicare.dto.SMSDto;
import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.dto.UserInfoDTO;
import com.usp.medicare.entity.User;
import com.usp.medicare.entity.UserInfo;
import com.usp.medicare.repository.UserInfoRepository;
import com.usp.medicare.repository.UserRepository;
import com.usp.medicare.util.MailUtil;
import com.usp.medicare.util.OtpGenerator;

@Service
public class UserService {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	OtpGenerator otpGenerator;

	@Autowired
	private ModelMapper modelMapper;

	private UserRepository userRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	private static final String COMMUNICATION_URL = "http://localhost:8093/communication/";

	@Autowired
	private RestTemplate restClient;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	UserService(UserRepository userRepository) {
		// this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	/**
	 * Method to fetch a user based on User object
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO fetchUser(UserDTO userDTO) {
		UserDTO userDto = null;

		List<User> userList = userRepository.getUserByMobNumber(userDTO.getMobile());
		if (userList != null && !userList.isEmpty()) {
			userDto = new UserDTO();
			User user = userList.get(0);
			userDto = modelMapper.map(user, UserDTO.class);
		}
		return userDto;
	}

	/**
	 * Method to get a user based on User mobile
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO getUserByMobile(String mobile) {
		UserDTO userDto = null;
		User user = userRepository.findByUserMobile(mobile);
		if (user != null) {
			userDto = modelMapper.map(user, UserDTO.class);
		}
		return userDto;
	}

	/**
	 * Method to register user
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO registerUser(UserDTO userDTO) {

		try {
			User user = null;
			user = modelMapper.map(userDTO, User.class);
			user.setIsActive("Y");
			user.setIsExisting("Y");
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			user.setCreateBy(null);
			user.setUpdatedBy(null);
			// BeanUtils.copyProperties(userDTO, user);
			user = userRepository.save(user);
			userDTO.setUserId(user.getUserId());
			String baseUrl = COMMUNICATION_URL + "/sms/updateUser" + user.getUserId();

			URI uri = new URI(baseUrl);
			SMSDto otpValidateResponse = restClient.getForObject(uri, SMSDto.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return userDTO;
	}

	public UserInfo saveUserInformation(UserInfoDTO userInfoDTO) {
		UserInfo userInfo = null;
		try {
			userInfo = modelMapper.map(userInfoDTO, UserInfo.class);
			userInfo.setCreateDate(new Date());
			userInfo.setUpdateDate(new Date());
			userInfo.setCreateBy(null);
			userInfo.setUpdatedBy(null);
			userInfo.setIsUserActive("Y");
			userInfo = userInfoRepository.save(userInfo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return userInfo;
	}

}
