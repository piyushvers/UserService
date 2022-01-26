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
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", unique = true)
	private BigInteger userId;
	
	
	
	@Column(name="USER_NAME")
	private String userName;
	
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="Last_NAME")
	private String lastName;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="BLOOD_GROUP")
	private String bloodGroup;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE")
	private String mobile;
	

	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="COUNTRY")
	private String country;
	

	@Column(name="IS_USER_ACTIVE")
	private String isUserActive;
	
	
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;
	
	
	@Column(name="LAST_LOGOUT_DATE")
	private Date lastLogoutDate;
	
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
	
}
