package com.prapps.yavni.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EVENT_ID")
	private Long eventId;	
	@Column(name="EVENT_DATE")
	private Date eventDate;	
	@Column(name="REQUIREMENT")
	private String requirement;
	@Column(name="FULFILMENT")
	private String fulfilment;
	@Column(name="EXP_DONOR_COUNT")
	private int expectedDonorCount;
	@OneToOne
	@JoinColumn(name="BLOOD_BANK_ID", updatable=false)
	private BloodBank bloodBank;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID", updatable=false)
	private Address activityLocation;
	@OneToOne
	@JoinColumn(name="ORGANIZATION_ID", updatable=false)
	private Organization organization;
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Date getActivityDate() {
		return eventDate;
	}
	public void setActivityDate(Date activityDate) {
		this.eventDate = activityDate;
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
	public BloodBank getBloodBank() {
		return bloodBank;
	}
	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}

}
