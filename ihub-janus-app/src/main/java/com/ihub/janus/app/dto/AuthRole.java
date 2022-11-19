//SSD Assignment 2
package com.ihub.janus.app.dto;

import org.springframework.security.core.GrantedAuthority;

import com.ihub.janus.data.entity.Role;

/**
 * The Class AuthRole.
 */
public class AuthRole implements GrantedAuthority {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 67008954569805009L;

	/** The role. */
	private Role role;

	/**
	 * Instantiates a new auth role.
	 *
	 * @param role the role
	 */
	public AuthRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	@Override
	public String getAuthority() {
		return role.getName();
	}

}