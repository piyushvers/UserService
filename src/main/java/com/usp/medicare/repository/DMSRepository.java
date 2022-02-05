package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usp.medicare.entity.DMS;

/**
 * Account Repository for CRUD operations
 * 
 * @author piyus
 *
 */
public interface DMSRepository extends JpaRepository<DMS, BigInteger> {
	
	@Query("Select u from DMS u where u.userId=userId")
	List<DMS> getDocumentObjectByUserId(String userId);
//	
//	User findByUserMobile(String userMobile);

}
