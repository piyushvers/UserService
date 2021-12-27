package com.usp.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usp.medicare.entity.User;

/**
 * Account Repository for CRUD operations
 * 
 * @author piyus
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("Select u from User u where u.mobNumber=mobNumber")
	User getUserByMobNumber(String mobNumber);

}
