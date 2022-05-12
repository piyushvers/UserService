package com.usp.medicare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="property")
@Getter
@Setter
public class Property {
	@Id
	@Column(name="PROPERTY_ID")
	private Integer propertyId;
	
	@Column(name="PROPERTY_NAME")
	private String propertyName;
	
	@Column(name="PROPERTY_VALUE")
	private String propertyValue;
	
	@Column(name="PROPERTY_CD")
	private String propertyCd;
	
	@Column(name="IS_ACTIVE")
	private Character isActive;

}
