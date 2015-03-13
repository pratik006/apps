package com.prapps.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT_ADDR_INFO")
public class ClientAddrInfo implements Serializable {

	private static final long serialVersionUID = -6808722936942212093L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="IPHASH")
	private int hash;
	@Column(name="TIME")
	private long time;
	
	public ClientAddrInfo(int hash, long time) {
		this.hash = hash;
		this.time = time;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ClientAddrInfo [hash=" + hash + ", time=" + time + "]";
	}
	
}
