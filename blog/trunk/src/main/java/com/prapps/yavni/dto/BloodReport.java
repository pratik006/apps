package com.prapps.yavni.dto;


public class BloodReport {

	private String bankName;
	private String bloodGroup;
	private String bloodType;
	private long bloodInCount;
	private long bloodOutCount;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getBloodInCount() {
		return bloodInCount;
	}

	public void setBloodInCount(long bloodInCount) {
		this.bloodInCount = bloodInCount;
	}

	public long getBloodOutCount() {
		return bloodOutCount;
	}

	public void setBloodOutCount(long bloodOutCount) {
		this.bloodOutCount = bloodOutCount;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "BloodReport [bankName=" + bankName + ", bloodGroup=" + bloodGroup + ", bloodType=" + bloodType + ", bloodInCount=" + bloodInCount
				+ ", bloodOutCount=" + bloodOutCount + "]";
	}

	public static String toCSVHeader() {
		return "Bank Name," +"Blood Group"+ "," + "Blood Type" +  "," + "Blood In Count"+ ","+ "Blood Out Count";
	}
	
	public String toCSV() {
		String s = bankName + "," + bloodGroup + "," + bloodType + "," + bloodInCount + "," + bloodOutCount;
		return s;
	}
}
