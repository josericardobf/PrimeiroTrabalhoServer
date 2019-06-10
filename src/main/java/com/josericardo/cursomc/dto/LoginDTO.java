package com.josericardo.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.josericardo.cursomc.domain.Login;

public class LoginDTO implements Serializable {	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String password;
	
	public LoginDTO() {		
	}
	
	public LoginDTO(Login obj) {
		email = obj.getEmail();
		password = obj.getPassword();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
