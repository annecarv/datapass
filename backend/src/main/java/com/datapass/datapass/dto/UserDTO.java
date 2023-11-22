package com.datapass.datapass.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.datapass.datapass.entities.User;

public class UserDTO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String firstname;
	private String email;
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.firstname = entity.getFirstname();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
	}

	public UserDTO(Long id, String firstname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
