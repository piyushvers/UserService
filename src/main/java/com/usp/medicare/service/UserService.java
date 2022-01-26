package com.usp.medicare.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.entity.User;
import com.usp.medicare.repository.UserRepository;
import com.usp.medicare.util.MailUtil;
import com.usp.medicare.util.OtpGenerator;

@Service
public class UserService {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	OtpGenerator otpGenerator;

	private UserRepository userRepository;
	

	
	UserService(UserRepository userRepository){
		//this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	/**
	 * Method to register user
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO fetchUser(UserDTO userDTO) {
		UserDTO userDto = null;
		
		List<User> userList = userRepository.getUserByMobNumber(userDTO.getMobile());
		if(userList != null && userList.size() >0) {
			userDto =  new UserDTO();
			User user = userList.get(0);
			BeanUtils.copyProperties( user,userDTO);
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
			//UserMapper userMapper = Mappers.getMapper(UserMapper.class);
			User user =  new User();
			BeanUtils.copyProperties(userDTO, user);
		    user = userRepository.save(user);
		    userDTO.setUserId(user.getUserId());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return userDTO;
	}

}
