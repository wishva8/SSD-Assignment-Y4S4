//SSD Assignment 2
package com.ihub.janus.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.janus.app.service.RoleService;
import com.ihub.janus.data.entity.Role;
import com.ihub.janus.data.repository.RoleRepository;

/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Override
	public List<Role> getAll() {
		return roleRepository.getAll();
	}
}
