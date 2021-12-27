package com.usp.medicare.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.entity.User;
import com.usp.medicare.mapper.UserMapper;
import com.usp.medicare.repository.UserRepository;
import com.usp.medicare.util.MailUtil;
import com.usp.medicare.util.OtpGenerator;

@Service
public class UserService {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	OtpGenerator otpGenerator;

	private UserRepository repo;
	
	@Autowired
	private UserMapper userMapper;
	
	UserService(UserRepository repo){
		//this.userMapper = userMapper;
		this.repo = repo;
	}

	//@Autowired
	//private Address address;
	
	/*
	 * public User getUserByEmail(String email) { User user = new User();
	 * user.setEmail(email); user.setUserName("Piyush"); user.setPassword("123");
	 * user.setOneTimePassword("1234"); // user.setOneTimePassword(email);
	 * user.setOtpRequestedTime(new Date()); return user; }
	 * 
	 * public void generateOneTimePassword(User user) throws
	 * UnsupportedEncodingException, MessagingException { // String OTP =
	 * otpGenerator.generateOTP(); String OTP = "1234"; // String encodedOTP =
	 * passwordEncoder.encode(OTP); System.out.println("HI" + OTP);
	 * user.setOneTimePassword(OTP); user.setOtpRequestedTime(new Date());
	 * 
	 * // customerRepo.save(customer);
	 * 
	 * //mailUtil.sendOTPEmail(user, OTP); }
	 * 
	 * public void clearOTP(User user) { user.setOneTimePassword(null);
	 * user.setOtpRequestedTime(null); // customerRepo.save(customer); }
	 */

	/**
	 * Method to register user
	 * 
	 * @param user
	 * @return
	 */
	public String registerUser(UserDTO userDTO) {
		//User user = new User();
		//user.setEmail(newUser.getEmail());
		//user.setMobNumber(newUser.getMobNumber());
		//user.setOneTimePassword(newUser.getOneTimePassword());
		//user.setOtpRequestedTime(newUser.getOtpRequestedTime());
		// user.setPassword(newUser.getPassword());
		//user.setUserName(newUser.getUserName());
		//User user = repo.getUserByMobile(newUser.getMobile());
		//if(user!=null)
			//repo.
		try {
			//UserMapper userMapper = Mappers.getMapper(UserMapper.class);
		User user = userMapper.userDTOToUser(userDTO);
		user = repo.save(user);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}

}
