//SSD Assignment 2
package com.ihub.janus.app.dto;

import java.io.Serializable;

/**
 * The Class AuthRequestDto.
 */
public class AuthRequestDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3638523817427955238L;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** Refresh token. */
	private String refreshToken;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
