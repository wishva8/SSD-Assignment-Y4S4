//SSD Assignment 2
package com.ihub.janus.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ihub.janus.data.entity.Role;

/**
 * The Interface RoleService.
 */

@Service
@Transactional
public interface RoleService {
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	List<Role> getAll();
}
