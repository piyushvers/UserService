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
@Table(name="dms")
@Getter @Setter
public class DMS {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REPOSITORY_ID", unique = true)
	private BigInteger repositoryId;
	
	@Column(name="SIZE_IN_BYTES")
	private double sizeInBytes;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="EXTENTION")
	private String extension;
	
	@Column(name="CONTENT_TYPE")
	private String contentType;
	
	@Column(name="BASE64")
	private String base64;
	
	@Column(name="USER_ID")
	private BigInteger userId;
	
	@Column(name="HEADER_TABLE_ID")
	private BigInteger headerTableId;
	
	
	@Column(name="HEADER_TABLE_CONST")
	private String headerTableConstant;

	@Column(name="MENU_ID")
	private String menuId;
	
	@Column(name="SUB_MENU_ID")
	private String subMenuId;
	
	@Column(name="IS_FILE_DEL")
	private String isFileDeleted;
	
	
	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
	
}
