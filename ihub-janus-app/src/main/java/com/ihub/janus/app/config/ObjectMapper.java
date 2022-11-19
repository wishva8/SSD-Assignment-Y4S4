//SSD Assignment 2
package com.ihub.janus.app.config;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.ihub.janus.data.entity.User;

/**
 * The Interface ObjectMapper.
 */
@Mapper
public interface ObjectMapper {

	/** The instance. */
	ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

	/**
	 * Map user.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 */
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void mapUser(User dto, @MappingTarget User entity);

	/**
	 * Map project.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 */


}
