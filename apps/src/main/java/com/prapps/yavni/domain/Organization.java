package com.prapps.yavni.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORG_ID")
	private Long organizationId;
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private BloodBank bloodBank;
	
	@Column(name="ORG_NAME")
	private String organizationName;
	@Column(name="CAMP_DATE")
	private Date campDate;
	@Column(name="SEC_NAME")
	private String secretaryName;
	@Column(name="PRESI_NAME")
	private String presidentName;
	@Column(name="CONTACT_PERSON")
	private String contactPerson;
	@Column(name="COMMENTS")
	private String comments;
	@Column(name="REGISTRATION_DATE")
	private Date registrationDate;
	@Column(name="ORGANIZATION_CODE")
	private String organizationCode;
	
	private transient int donorCount;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CAMP_DONOR",
		joinColumns={@JoinColumn(name="CAMP_ID")},
		inverseJoinColumns={@JoinColumn(name="DONOR_ID")})
	private List<Donor> donors;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;


	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getCampDate() {
		return campDate;
	}

	public void setCampDate(Date campDate) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}

	public List<Donor> getDonors() {
		return donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
		if(null != donors) {
			donorCount = donors.size();
		}
	}
	

	public int getDonorCount() {
		return donorCount;
	}

	public void setDonorCount(int donorCount) {
		this.donorCount = donorCount;
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

	@Override
	public String toString() {
		return "Camp [campId=" + organizationId + ", organizationName=" + organizationName + ", campDate=" + campDate
				+ ", secretaryName=" + secretaryName + ", presidentName=" + presidentName + ", contactPerson=" + contactPerson + ", comments="
				+ comments + ", donors=" + donors + "]";
	}
	
}
