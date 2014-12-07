package com.prapps.yavni.dto;

import java.io.Serializable;
import java.util.List;

public class BloodBank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94998889552616168L;
	
	private long bankId;
	private String name;
	private String cmo;
	private List<Organization> camps;
	private Address address;
	
	public BloodBank() {}
	
	public BloodBank(com.prapps.yavni.domain.BloodBank bloodBankDomain) {
		bankId = bloodBankDomain.getBankId();
		name = bloodBankDomain.getName();
		cmo = bloodBankDomain.getCmo();
		if(null != bloodBankDomain.getAddress()) {
			address = new Address(bloodBankDomain.getAddress());
		}
		else {
			address = new Address();
		}
		/*if(null != bloodBankDomain.getCamps() && bloodBankDomain.getCamps().size() > 0) {
			camps = new ArrayList<Organization>(bloodBankDomain.getCamps().size());
			for(com.websoft.yavni.domain.Organization camp : bloodBankDomain.getCamps()) {
				camps.add(new Organization(camp));
			}
		}*/
	}
	
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCmo() {
		return cmo;
	}
	public void setCmo(String cmo) {
		this.cmo = cmo;
	}
	public List<Organization> getCamps() {
		return camps;
	}
	public void setCamps(List<Organization> camps) {
		this.camps = camps;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "BloodBank [bankId=" + bankId + ", name=" + name + ", cmo=" + cmo + ", camps=" + camps + ", address=" + address + "]";
	}
	
	
}
