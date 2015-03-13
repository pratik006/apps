package com.prapps.yavni.dto;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7483529510321204904L;
	private long addressId;
	private String addressLine1;
	private String area;
	private String city;
	private String district;
	private String state;
	private String country;
	private String pin;
	private String residencePhone;
	private String offPhone;
	private String mobilePhone;
	private String email;
	
	public Address() {}
	
	public Address(com.prapps.yavni.domain.Address addressDomain) {
		addressId = addressDomain.getAddressId();
		addressLine1 = addressDomain.getAddressLine1();
		area = addressDomain.getArea();
		city = addressDomain.getCity();
		district = addressDomain.getDistrict();
		state = addressDomain.getState();
		country = addressDomain.getCountry();
		pin = addressDomain.getPin();
		residencePhone = addressDomain.getResidencePhone();
		offPhone = addressDomain.getOffPhone();
		mobilePhone = addressDomain.getMobilePhone();
		email = addressDomain.getEmail();
	}
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
