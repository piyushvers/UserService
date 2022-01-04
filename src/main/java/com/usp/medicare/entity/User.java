package com.usp.medicare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
	
	@Column(name="USER_MOBILE_NUMBER")
	private String mobNumber;
	
	@Column(name="OTP_REQUESTED_TIME")
	private Date otpRequestedTime;
	
	@Column(name="OTP")
	private String oneTimePassword;
	
	@Embedded
	private Audit audit;
	
	
}
