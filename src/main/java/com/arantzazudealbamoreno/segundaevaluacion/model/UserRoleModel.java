package com.arantzazudealbamoreno.segundaevaluacion.model;

import com.arantzazudealbamoreno.segundaevaluacion.entity.User;

public class UserRoleModel {
	private Integer userRoleId;
	private User user;
	private String role;
	
	public UserRoleModel() {
		super();
	}

	public UserRoleModel(User user, String role) {
		super();
	
		this.user = user;
		this.role = role;
	}
	
	public UserRoleModel(Integer userRoleId, User user, String role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
