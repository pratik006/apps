package com.prapps.yavni.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.prapps.core.domain.User;

@Entity
@Table(name="USER_BANK_XREF", schema="yavni")
@AssociationOverrides({
	@AssociationOverride(name = "userBankPk.user", joinColumns = @JoinColumn(name = "USER_ID")),
	@AssociationOverride(name = "userBankPk.bloodBank", joinColumns = @JoinColumn(name = "BANK_ID"))
})
public class UserBank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529538192429497680L;
	@EmbeddedId
	private UserBankPk userBankPk;

	public UserBankPk getUserBankPk() {
		return userBankPk;
	}

	public void setUserBankPk(UserBankPk userBankPk) {
		this.userBankPk = userBankPk;
	}	
	
	@Transient
	public User getUser() {
		return userBankPk.getUser();
	}
	
	@Transient
	public BloodBank getBloodBank() {
		return userBankPk.getBloodBank();
	}

	@Override
	public String toString() {
		return "UserBank [getUser()=" + getUser() + ", getBloodBank()=" + getBloodBank() + "]";
	}
}
