package com.usp.medicare.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, BigInteger> {
	UserInfo findByUserId(BigInteger userId);
}
