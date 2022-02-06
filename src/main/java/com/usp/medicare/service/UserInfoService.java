package com.usp.medicare.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.usp.medicare.dto.DmsDTO;
import com.usp.medicare.dto.UserInfoDTO;
import com.usp.medicare.entity.DMS;
import com.usp.medicare.entity.UserInfo;
import com.usp.medicare.repository.DMSRepository;
import com.usp.medicare.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	private DMSRepository dmsRepository;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	UserInfoService(UserInfoRepository userInfoRepository,DMSRepository dmsRepository ) {
		// this.userMapper = userMapper;
		this.userInfoRepository = userInfoRepository;
		this.dmsRepository = dmsRepository;
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
			LOGGER.error(e.getMessage());
		}

		return userInfo;
	}

	/**
	 * Method to get user information along with documents
	 * @param userId
	 * @return
	 */
	public UserInfoDTO getUserInfo(String userId) {
		UserInfoDTO userInfoDTO = null;
		try {
			List<UserInfo> userInfoList = userInfoRepository.getUserInfoByUserId(userId);
			if (userInfoList != null && !userInfoList.isEmpty()) {
				userInfoDTO = new UserInfoDTO();
				UserInfo userInfo = userInfoList.get(0);
				userInfoDTO = modelMapper.map(userInfo, UserInfoDTO.class);
				// Get user document
				List<DMS> dmsList = dmsRepository.getDocumentObjectByUserId(""+userInfoDTO.getUserId());
				if(!CollectionUtils.isEmpty(dmsList)) {
					DMS dms = dmsList.get(0);
					DmsDTO dmsDto= modelMapper.map(dms, DmsDTO.class);
					userInfoDTO.setDmsDTO(dmsDto);
				}
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return userInfoDTO;
	}

}
