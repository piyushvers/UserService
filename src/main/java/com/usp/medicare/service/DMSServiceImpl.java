package com.usp.medicare.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.DmsDTO;
import com.usp.medicare.entity.DMS;
import com.usp.medicare.repository.DMSRepository;

@Service
public class DMSServiceImpl implements DMSService {

	@Autowired
	private ModelMapper modelMapper;

	private DMSRepository dmsRepository;

	DMSServiceImpl(DMSRepository dmsRepository) {
		// this.userMapper = userMapper;
		this.dmsRepository = dmsRepository;
	}

	/**
	 * Method to upload the document into DMS repository
	 * 
	 * @param user
	 * @return
	 */
	public DmsDTO uploadDocument(DmsDTO dmsDTO) {
		DMS dms = null;
		try {
			dms = modelMapper.map(dmsDTO, DMS.class);
			dms.setCreateDate(new Date());
			dms.setUpdateDate(new Date());
			dms.setCreateBy(null);
			dms.setUpdatedBy(null);
			dms.setIsFileDeleted("N");
			dms = dmsRepository.save(dms);

			dmsDTO.setRepositoryId(dms.getRepositoryId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return dmsDTO;
	}

	/**
	 * Method to get document by userID
	 * 
	 * @param user
	 * @return
	 */
	public DmsDTO getDocumentByUserId(String userId) {
		DmsDTO dmsDTO = null;
		List<DMS> dmsList = dmsRepository.getDocumentObjectByUserId(userId);
		if (dmsList != null && !dmsList.isEmpty()) {
			dmsDTO = new DmsDTO();
			DMS dms = dmsList.get(0);
			dmsDTO = modelMapper.map(dms, DmsDTO.class);
		}
		return dmsDTO;
	}

}
