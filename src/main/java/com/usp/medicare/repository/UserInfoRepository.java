package com.usp.medicare.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, BigInteger> {

}
