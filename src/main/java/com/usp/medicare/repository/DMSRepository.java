package com.usp.medicare.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.DMS;

/**
 * Account Repository for CRUD operations
 * 
 * @author piyus
 *
 */
public interface DMSRepository extends JpaRepository<DMS, BigInteger> {
	
//	@Query("Select u from User u where u.userMobile=userMobile")
//	List<User> getUserByMobNumber(String userMobile);
//	
//	User findByUserMobile(String userMobile);

}
