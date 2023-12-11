package com.datapass.datapass.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_PASS")
public class Pass {
	
	private Long id;
	private String name;
	private String url;
	private String login;
	private String pass;
	//Folder folder;
	

	public Pass(Long id, String name, String url, String login, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.login = login;
		this.pass = pass;
	}

	public Pass() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
