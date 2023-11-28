package com.datapass.datapass.entities;

public class Pass {
	
	private Long id;
	private String name;
	private String url;
	private String login;
	private String pass;
	Folder folder;
	
	public void Pass() {
		
	}

	public Pass(Long id, String name, String url, String login, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.login = login;
		this.pass = pass;
	}
	
	
}
