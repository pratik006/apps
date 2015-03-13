package com.prapps.yavni.dto;

import com.prapps.core.vo.User;

public class YavniUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6121127494396238627L;
	private BloodBank bloodBbank;

	public BloodBank getBloodBbank() {
		return bloodBbank;
	}

	public void setBloodBank(BloodBank bloodBbank) {
		this.bloodBbank = bloodBbank;
	}
}
