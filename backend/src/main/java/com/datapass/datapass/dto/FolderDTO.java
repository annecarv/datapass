package com.datapass.datapass.dto;

import com.datapass.datapass.entities.Folder;

public class FolderDTO {
	/**
	 * 
	 */
	
	private Long id;
	private String name;
	
	public FolderDTO(Folder fol) {
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
	
	
}
