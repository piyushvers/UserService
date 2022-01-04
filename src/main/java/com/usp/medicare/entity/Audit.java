package com.usp.medicare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * Embeddable class containing audit info for each entity
 * @author piyus
 *
 */
@Getter @Setter
@Embeddable
public class Audit {

	@Column(name="CREATED_DATE")
	private Date createDate;
	
	@Column(name="MODIFIED_DATE")
	private Date updateDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="MODIFIED_BY")
	private String updatedBy;	
}
