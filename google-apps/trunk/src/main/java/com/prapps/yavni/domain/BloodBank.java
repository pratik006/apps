package com.prapps.yavni.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BLOOD_BANK")
public class BloodBank {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BANK_ID")
	private long bankId;
	@Column(name="BANK_NAME")
	private String name;
	@Column(name="CMO")
	private String cmo;
	
	@OneToMany(mappedBy="bloodBank")
	private List<Organization> camps;
	
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	@JoinColumn(name="BANK_ADDRESS_ID")
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Organization> getCamps() {
		return camps;
	}

	public void setCamps(List<Organization> camps) {
		this.camps = camps;
	}

	public String getCmo() {
		return cmo;
	}

	public void setCmo(String cmo) {
		this.cmo = cmo;
	}

	@Override
	public String toString() {
		return "BloodBank [bankId=" + bankId + ", name=" + name + ", cmo=" + cmo + ", address=" + address + "]";
	}
	
}
