package com.usp.medicare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ID", unique = true)
	private Long userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_MOBILE_NUMBER")
	private String mobNumber;
	
	@Column(name="USER_EMAIL_ADDRESS")
	private String email;
	
	@Column(name="OTP_REQUESTED_TIME")
	private Date otpRequestedTime;
	
	@Column(name="OTP")
	private String oneTimePassword;
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
}
