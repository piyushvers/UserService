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

/**
 * Entity class for persisting account information to database
 * 
 * @author piyus
 *
 */


//@Entity
@Table(name="user_information")
@Getter @Setter
public class Account {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ID", unique = true)
	private Integer accountID;
	
	@Column(name="USER_ID")
	private String userID;
	
	@Column(name="USER_FIRST_NAME")
	private String accountHolderFirstName;
	
	@Column(name="USER_LAST_NAME")
	private String accountHolderLastName;
	
	@Column(name="USER_NAME")
	private String accountHolderFullName;
	
	@Column(name="USER_SEX")
	private String sex;
	
	@Column(name="USER_DOB")
	private String dob;
	
	@Column(name="USER_MOBILE_NUMBER")
	private String mobNumber;
	
	@Column(name="USER_EMAIL_ADDRESS")
	private String email;
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
}
