package com.idexcel.adminservice.dto;

import com.idexcel.adminservice.enums.LenderStatus;

public class LenderListDTO {
	private String id;
	private String name;
	private LenderStatus status;
	
	
	public LenderListDTO() {
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LenderStatus getStatus() {
		return status;
	}


	public void setStatus(LenderStatus status) {
		this.status = status;
	}
	
	

}
