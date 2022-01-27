package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usp.medicare.entity.User;
import com.usp.medicare.entity.UserInfo;

/**
 * Account Repository for CRUD operations
 * 
 * @author piyus
 *
 */
public interface UserRepository extends JpaRepository<User, BigInteger> {
	
	@Query("Select u from User u where u.userMobile=userMobile")
	List<User> getUserByMobNumber(String userMobile);
	
	User findByUserMobile(String userMobile);

}
