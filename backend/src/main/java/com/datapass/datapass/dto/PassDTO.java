package com.datapass.datapass.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.datapass.datapass.entities.Folder;
import com.datapass.datapass.entities.Pass;

public class PassDTO {
	/**
	 * 
	 */

	private Long id;
	private String name;
	private String url;
	private String login;
	private String pass;

	private List<FolderDTO> folder = new ArrayList<>();
	
	public PassDTO() {
		
	}
	
	//Não se deve colocar a lista de folder aqui, pois nao colocamos coleção em construtores
	public PassDTO(Long id, String name, String url, String login, String pass) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.login = login;
		this.pass = pass;
	}
	
	public PassDTO(Pass entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.url = entity.getUrl();
		this.login = entity.getLogin();
		this.pass = entity.getPass();
	}
	
	public PassDTO(Pass entity, Set<Folder> folder) {
		this(entity);
		folder.forEach(fol -> this.folder.add(new FolderDTO(fol)));
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

	public List<FolderDTO> getFolder() {
		return folder;
	}

	public void setFolder(List<FolderDTO> folder) {
		this.folder = folder;
	}
	
	

}
