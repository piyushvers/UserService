package com.usp.medicare.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.dto.UserInfoDTO;
import com.usp.medicare.entity.User;
import com.usp.medicare.entity.UserInfo;
import com.usp.medicare.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ModelMapper modelMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	UserInfoService(UserInfoRepository userInfoRepository) {
		// this.userMapper = userMapper;
		this.userInfoRepository = userInfoRepository;
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

	public UserInfoDTO getUserInfo(String userId) {
		UserInfoDTO userInfoDTO = null;
		try {
			List<UserInfo> userInfoList = userInfoRepository.getUserInfoByUserId(userId);
			if (userInfoList != null && !userInfoList.isEmpty()) {
				userInfoDTO = new UserInfoDTO();
				UserInfo userInfo = userInfoList.get(0);
				userInfoDTO = modelMapper.map(userInfo, UserInfoDTO.class);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return userInfoDTO;
	}

}
