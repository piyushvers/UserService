package com.usp.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.dto.PropertyDto;
import com.usp.medicare.service.ProperyServiceImpl;

@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonController {
	
	@Autowired
	private ProperyServiceImpl propertyServiceImpl;
   
	@GetMapping("/getProperty")
	private List<PropertyDto> getPropertyData(@RequestParam String propertyName){
		return propertyServiceImpl.getPropertyData(propertyName);
	}
}
