package com.usp.medicare.service;

import org.springframework.stereotype.Service;

import com.usp.medicare.dto.DmsDTO;

@Service
public interface DMSService {

	

	/**
	 * Method to upload the document into dms repository
	 * 
	 * @param user
	 * @return
	 */
	public DmsDTO uploadDocument(DmsDTO dmsDTO);

	/**
	 * Method to get document
	 * 
	 * @param user
	 * @return
	 */
	public DmsDTO getDocument(DmsDTO dmsDTO);


}
