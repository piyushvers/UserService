package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.usp.medicare.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, BigInteger> {

	@Query("Select u from UserInfo u where u.userId=userId")
	List<UserInfo> getUserInfoByUserId(String userId);
	
}
