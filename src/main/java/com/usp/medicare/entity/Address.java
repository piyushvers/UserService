package com.usp.medicare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="user_address")
@Getter @Setter
public class Address {

	@Column(name="ID")
	private Integer addressID;
	
	@Column(name="ADDRESS_LINE_1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE_2")
	private String addressLine2;
	
	@Column(name="CITY_FK")
	private String city;
	
	@Column(name="STATE_FK")
	private String state;
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="COUNTRY_FK")
	private String country;
	
	@Column(name="ADDRESS_TYPE_FK")
	private String addressType;
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;

}
