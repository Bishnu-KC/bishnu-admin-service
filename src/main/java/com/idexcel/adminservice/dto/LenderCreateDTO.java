package com.idexcel.adminservice.dto;

import javax.validation.constraints.NotNull;

public class LenderCreateDTO {
	
	@NotNull
	private String name;
	@NotNull
	private AddressDTO address;
	@NotNull
	private PrimaryContactDTO primaryContact;
	
	public LenderCreateDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public PrimaryContactDTO getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(PrimaryContactDTO primaryContact) {
		this.primaryContact = primaryContact;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
