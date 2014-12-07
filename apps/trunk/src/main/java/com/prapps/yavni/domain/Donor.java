package com.prapps.yavni.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DONOR")
public class Donor {

	@Id
	@Column(name="DONOR_ID")	
	private long donorId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="DOB")
	private Date dateOfBirth;
	@Column(name="BLOOD_GROUP")
	private String bloodGroup;
	@Column(name="LAST_DON_DATE")
	private Date lastDonationDate;
	@Column(name="HEIGHT")
	private String height;
	@Column(name="WEIGHT")
	private String weight;
	@Column(name="BP")
	private String bp;
	@Column(name="COMMENTS")
	private String comments;
	/*@ManyToMany(mappedBy="donors")
	private List<Camp> camps;*/	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DONOR_ADDRESS_ID")
	private Address address;

	public long getDonorId() {
		return donorId;
	}

	public void setDonorId(long donorId) {
		this.donorId = donorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getLastDonationDate() {
		return lastDonationDate;
	}

	public void setLastDonationDate(Date lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
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

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", bloodGroup=" + bloodGroup + ", lastDonationDate=" + lastDonationDate + ", height=" + height + ", weight=" + weight
				+ ", bp=" + bp + ", comments=" + comments + ", residentialAddress=" + address + "]";
	}

	

	/*public List<Camp> getCamps() {
		return camps;
	}

	public void setCamps(List<Camp> camps) {
		this.camps = camps;
	}*/
	
}
