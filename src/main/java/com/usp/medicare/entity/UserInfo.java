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
@Table(name="user_information")
@Getter
@Setter
public class UserInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_INFO_ID", unique = true)
	private BigInteger id;
	
	@Column(name="USER_ID_FK", unique = true)
	private BigInteger userId;
	
	@Column(name="USER_FIRST_NAME")
	private String firstName;
	
	@Column(name="USER_LAST_NAME")
	private String lastName;
	
	@Column(name="USER_SEX")
	private String sex;
	
	@Column(name="USER_DOB")
	private String dob;
	
	@Column(name="USER_BLOOD_GROUP")
	private String bloodGroup;

	@Column(name="USER_EMAIL_ID")
	private String email;
	
	@Column(name="USER_MOBILE")
	private String mobile;
	
	@Column(name="USER_ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIPCODE")
	private String zipCode;
	
	@Column(name="COUNTRY")
	private String country;

	@Column(name="IS_ACTIVE")
	private String isUserActive;
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
	
	@Column(name="appointment_id")
	private BigInteger appointmentId;	
	
}
