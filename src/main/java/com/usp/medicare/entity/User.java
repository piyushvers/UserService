package com.usp.medicare.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter 
@Setter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", unique = true)
	private BigInteger userId;
	
	@Column(name="USER_MOBILE_NUMBER")
	private String userMobile;
	
	@Column(name="IS_EXISTING_USER")
	private String isExisting;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
}
