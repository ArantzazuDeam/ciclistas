package com.arantzazudealbamoreno.segundaevaluacion.model;

public class RegistroUsuario {
	private String username;
	private String role;
	private String password1;
	private String password2;
	
	public RegistroUsuario() {
		super();
	}

	public RegistroUsuario(String username, String role, String password1, String password2) {
		super();
		this.username = username;
		this.role = role;
		this.password1 = password1;
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
