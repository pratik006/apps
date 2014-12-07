package com.prapps.yavni.dto;

import java.io.Serializable;
import java.util.Date;

import com.prapps.yavni.util.YavniDateUtil;

public class Organization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5965924894767393216L;
	private long organizationId;
	private BloodBank bloodBank;
	private String organizationName;
	private String organizationCode;
	private String campDate;
	private Date registrationDate;
	private String secretaryName;
	private String presidentName;
	private String contactPerson;
	private String comments;
	private Address address;
	
	public Organization() {}
	
	public Organization(com.prapps.yavni.domain.Organization organizationDomain) {
		organizationId = organizationDomain.getOrganizationId();
		if(null != organizationDomain.getBloodBank()) {
			bloodBank = new BloodBank(organizationDomain.getBloodBank());
		}
		organizationName = organizationDomain.getOrganizationName();
		campDate = YavniDateUtil.dateToString(organizationDomain.getCampDate());
		secretaryName = organizationDomain.getSecretaryName();
		presidentName = organizationDomain.getPresidentName();
		contactPerson = organizationDomain.getContactPerson();
		comments = organizationDomain.getComments();
	}
	
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public BloodBank getBloodBank() {
		return bloodBank;
	}
	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getCampDate() {
		return campDate;
	}
	public void setCampDate(String campDate) {
		this.campDate = campDate;
	}
	public String getSecretaryName() {
		return secretaryName;
	}
	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}
	public String getPresidentName() {
		return presidentName;
	}
	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Camp [organizationId=" + organizationId + ", bloodBank=" + bloodBank + ", organizationName=" + organizationName + ", campDate="
				+ campDate + ", secretaryName=" + secretaryName + ", presidentName=" + presidentName + ", contactPerson=" + contactPerson
				+ ", comments=" + comments + "]";
	}
	
}
