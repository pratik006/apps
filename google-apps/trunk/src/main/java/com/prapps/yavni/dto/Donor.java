package com.prapps.yavni.dto;

import java.io.Serializable;

import com.prapps.yavni.util.YavniDateUtil;

public class Donor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261911134222167365L;
	private long donorId;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String bloodGroup;
	private String lastDonationDate;
	private String height;
	private String weight;
	private String bp;
	private String comments;
	private Address address;
	
	public Donor() {}
	
	public Donor(com.prapps.yavni.domain.Donor donor) {
		donorId = donor.getDonorId();
		firstName = donor.getFirstName();
		lastName = donor.getLastName();
		gender = donor.getGender();
		bloodGroup = donor.getBloodGroup();
		if(null != donor.getDateOfBirth()) {
			dateOfBirth = YavniDateUtil.dateToString(donor.getDateOfBirth().getTime());
		}
		if(null != donor.getLastDonationDate()) {
			lastDonationDate = YavniDateUtil.dateToString(donor.getLastDonationDate().getTime());
		}
		height = donor.getHeight();
		weight = donor.getWeight();
		bp = donor.getBp();
		comments = donor.getComments();
		if(null != donor.getAddress()) {
			address = new Address(donor.getAddress());
		}
	}
	
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
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getLastDonationDate() {
		return lastDonationDate;
	}
	public void setLastDonationDate(String lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", bloodGroup=" + bloodGroup + ", lastDonationDate=" + lastDonationDate + ", height=" + height + ", weight=" + weight
				+ ", bp=" + bp + ", comments=" + comments + ", address=" + address + "]";
	}
	
}

