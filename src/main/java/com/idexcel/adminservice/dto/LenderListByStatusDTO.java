package com.idexcel.adminservice.dto;

import java.util.Date;

import com.idexcel.adminservice.enums.LenderStatus;

public class LenderListByStatusDTO {

	private String id;
	private String name;
	private AddressDTO address;
	private PrimaryContactDTO primaryContact;
	private LenderStatus status;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	public LenderListByStatusDTO() {

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

	public LenderStatus getStatus() {
		return status;
	}

	public void setStatus(LenderStatus status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
