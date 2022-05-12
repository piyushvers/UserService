package com.usp.medicare.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.PropertyDto;
import com.usp.medicare.entity.Property;
import com.usp.medicare.repository.PropertyRepository;
import com.usp.medicare.util.ObjectMapperUtils;

@Service
public class ProperyServiceImpl {
	@Autowired
	private PropertyRepository propertyRepository;

	public List<PropertyDto> getPropertyData(String propertyName) {
		List<Property> propertyList = 	propertyRepository.findByPropertyName(propertyName);
		return propertyList!=null && !propertyList.isEmpty()? ObjectMapperUtils.mapAll(propertyList, PropertyDto.class):Collections.emptyList();
	}
	
	
}
