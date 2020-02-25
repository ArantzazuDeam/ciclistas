package com.arantzazudealbamoreno.segundaevaluacion.model;

import java.util.Set;

import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;

public class UserModel {
	private String username;
	private String password;
	private boolean enabled;
	private Set<UserRole> userRole;
	
	public UserModel() {
		super();
	}
	
	public UserModel(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public UserModel(String username, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
}
