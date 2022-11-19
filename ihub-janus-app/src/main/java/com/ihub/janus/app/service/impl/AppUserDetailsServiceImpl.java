//SSD Assignment 2
package com.ihub.janus.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ihub.janus.app.dto.AuthUser;
import com.ihub.janus.data.entity.User;
import com.ihub.janus.data.repository.UserRepository;

/**
 * The Class AppUserDetailsServiceImpl.
 */
@Service
@Transactional
public class AppUserDetailsServiceImpl implements UserDetailsService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new AuthUser(user);

	}
}
