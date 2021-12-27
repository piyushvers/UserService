package com.usp.medicare.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	//UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
	/*
	 * @Mappings({
	 * 
	 * @Mapping(target="employeeId", source="entity.id"),
	 * 
	 * @Mapping(target="employeeName", source="entity.name") })
	 */
	UserDTO userToUserDTO(User user);
	User userDTOToUser(UserDTO userDto);
}
