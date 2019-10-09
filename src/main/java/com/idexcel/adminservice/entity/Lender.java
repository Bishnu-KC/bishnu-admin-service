package com.idexcel.adminservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.idexcel.adminservice.enums.LenderStatus;

@Document
public class Lender {

	@Id
	private String id;
	
	@Indexed(unique=true, direction=IndexDirection.ASCENDING)
	private String name;
	
	//
	private Address address;
	
	private PrimaryContact primaryContact;
	
	private LenderStatus status;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	
	
	public Lender() {
		
	}



	public Lender(String id, String name, Address address, PrimaryContact primaryContact, LenderStatus status,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.primaryContact = primaryContact;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
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



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public PrimaryContact getPrimaryContact() {
		return primaryContact;
	}



	public void setPrimaryContact(PrimaryContact primaryContact) {
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



	@Override
    public String toString() {
        return "Lender{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", primaryContact=" + primaryContact +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", updatedBy=" + updatedBy +
                ", updatedDate=" + updatedDate +
                '}';
    }
	
	

}
