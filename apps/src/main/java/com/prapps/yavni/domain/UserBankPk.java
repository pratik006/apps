package com.prapps.yavni.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.prapps.core.domain.User;

@Embeddable
public class UserBankPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8192540290663461044L;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToOne
	@JoinColumn(name = "BANK_ID")
	private BloodBank bloodBank;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BloodBank getBloodBank() {
		return bloodBank;
	}
	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}
	
	
}
