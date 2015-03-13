package com.prapps.yavni.dto;

import java.sql.Date;

public class Event {

	private Long eventId;
	private Long organizationId;
	private String organizationCode;
	private Date activityDate;
	private Address activityLocation;
	private String requirement;
	private String fulfilment;
	private int expectedDonorCount;
	private Long bloodBankId;
	private BloodBank bloodBank;
	private Organization organization;
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public Date getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	public Address getActivityLocation() {
		return activityLocation;
	}
	public void setActivityLocation(Address activityLocation) {
		this.activityLocation = activityLocation;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getFulfilment() {
		return fulfilment;
	}
	public void setFulfilment(String fulfilment) {
		this.fulfilment = fulfilment;
	}
	public int getExpectedDonorCount() {
		return expectedDonorCount;
	}
	public void setExpectedDonorCount(int expectedDonorCount) {
		this.expectedDonorCount = expectedDonorCount;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public Long getBloodBankId() {
		return bloodBankId;
	}
	public void setBloodBankId(Long bloodBankId) {
		this.bloodBankId = bloodBankId;
	}
	public BloodBank getBloodBank() {
		return bloodBank;
	}
	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", organizationId=" + organizationId + ", organizationCode=" + organizationCode + ", activityDate="
				+ activityDate + ", activityLocation=" + activityLocation + ", requirement=" + requirement + ", fulfilment=" + fulfilment
				+ ", expectedDonorCount=" + expectedDonorCount + ", bloodBankId=" + bloodBankId + "]";
	}

}
