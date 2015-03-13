package com.prapps.yavni.dto;

import java.sql.Timestamp;

import com.prapps.yavni.util.YavniDateUtil;


public class BloodGroupData {

	private Long id;
	private String bloodGroup;
	private String bloodType;
	private String bankName;
	private String batch;
	private String receivedDate;
	private long count;
	private String recent;
	private String oldest;
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = YavniDateUtil.dateToString(receivedDate.getTime());
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getRecent() {
		return recent;
	}
	public void setRecent(Timestamp recent) {
		this.recent = YavniDateUtil.dateToString(recent.getTime());
	}
	public String getOldest() {
		return oldest;
	}
	public void setOldest(Timestamp oldest) {
		this.oldest = YavniDateUtil.dateToString(oldest.getTime());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BloodGroupData [bloodGroup=" + bloodGroup + ", bloodType=" + bloodType + ", bankName=" + bankName + ", batch=" + batch
				+ ", receivedDate=" + receivedDate + ", count=" + count + ", recent=" + recent + ", oldest=" + oldest + "]";
	}
}
