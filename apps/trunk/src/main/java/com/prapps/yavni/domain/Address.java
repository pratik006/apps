package com.prapps.yavni.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long addressId;
	@Column(name="LINE1")
	private String addressLine1;
	@Column(name="AREA")
	private String area;
	@Column(name="CITY")
	private String city;
	@Column(name="DISTRICT")
	private String district;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="PIN")
	private String pin;
	@Column(name="RESI_PHONE")
	private String residencePhone;
	@Column(name="OFF_PHONE")
	private String offPhone;
	@Column(name="MOB")
	private String mobilePhone;
	@Column(name="EMAIL")
	private String email;
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getResidencePhone() {
		return residencePhone;
	}
	public void setResidencePhone(String residencePhone) {
		this.residencePhone = residencePhone;
	}
	public String getOffPhone() {
		return offPhone;
	}
	public void setOffPhone(String offPhone) {
		this.offPhone = offPhone;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1="
				+ addressLine1 + ", district=" + district + ", state=" + state
				+ ", country=" + country + ", pin=" + pin + ", residencePhone="
				+ residencePhone + ", offPhone=" + offPhone + ", mobilePhone="
				+ mobilePhone + ", email=" + email + "]";
	}

	
	
}
