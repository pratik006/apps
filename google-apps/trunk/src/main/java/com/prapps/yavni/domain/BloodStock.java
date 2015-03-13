package com.prapps.yavni.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BLOOD_STOCK")
public class BloodStock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="BLOOD_GROUP")
	private String bloodGroup;
	@Column(name="RECV_DATE")
	private Timestamp receivedDate;
	@Column(name="ENTRY_DATE")
	private Timestamp entryDate;
	@Column(name="TYPE")
	private String bloodType;
	@Column(name="BATCH")
	private String batch;
	@Column(name="ISSUED")
	private Boolean issued;
	@Column(name="EXPIRY_DATE")
	private Timestamp expiryDate;
	@Column(name="ISSUE_DATE")
	private Timestamp issuedDate;
	@OneToOne
	@JoinColumn(name="BLOOD_BANK_ID")
	private BloodBank bloodBank;
	@Column(name="BLOOD_COUNT")
	private transient long count;
	
	@Column(name="PATIENT_NAME")
	private String patientName;
	@Column(name="DOCTOR_NAME")
	private String doctorName;
	@Column(name="HOSPITAL_NAME")
	private String hospitalName;
	@Column(name="BED_NUMBER")
	private String bedNumber;
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="VERIFIED")
	private boolean verified;
	@Column(name="VERIFIER_REMARKS")
	private String verifierRemarks;
	@Column(name="VERIFIED_BY")
	private String verifiedBy;
	@Column(name="VERIFIED_TS")
	private Timestamp verifiedTS;
	@Column(name="APPROVED")
	private boolean approved;
	@Column(name="APPROVER_REMARKS")
	private String approverRemarks;
	@Column(name="APPROVED_BY")
	private String approvedBy;
	@Column(name="APPROVED_TS")
	private Timestamp approvedTS;
	@Column(name="CREATED_BY", updatable=false)
	private String createdBy;
	@Column(name="CREATED_TS", updatable=false)
	private Timestamp createdTS;
	@Column(name="UPDATED_BY")
	private String updatedBy;
	@Column(name="UPDATED_TS")
	private Timestamp updatedTS;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Timestamp getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Timestamp date) {
		this.receivedDate = date;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public BloodBank getBloodBank() {
		return bloodBank;
	}
	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}
	
	public Boolean getIssued() {
		return issued;
	}
	public void setIssued(Boolean deleted) {
		this.issued = deleted;
	}
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Timestamp getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Timestamp issueDate) {
		this.issuedDate = issueDate;
	}
	
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String type) {
		this.bloodType = type;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	public Timestamp getVerifiedTS() {
		return verifiedTS;
	}
	public void setVerifiedTS(Timestamp verifiedTS) {
		this.verifiedTS = verifiedTS;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Timestamp getApprovedTS() {
		return approvedTS;
	}
	public void setApprovedTS(Timestamp approvedTS) {
		this.approvedTS = approvedTS;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getVerifierRemarks() {
		return verifierRemarks;
	}
	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}
	public String getApproverRemarks() {
		return approverRemarks;
	}
	public void setApproverRemarks(String approverRemarks) {
		this.approverRemarks = approverRemarks;
	}
	
	public Timestamp getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}
	@Override
	public String toString() {
		return "BloodStock [id=" + id + ", bloodGroup=" + bloodGroup + ", receiveDate=" + receivedDate + ", type=" + bloodType + ", batch=" + batch
				+ ", deleted=" + issued + ", expiryDate=" + expiryDate + ", issueDate=" + issuedDate + ", bloodBank=" + bloodBank + ", count="
				+ count + ", patientName=" + patientName + ", doctorName=" + doctorName + ", hospitalName=" + hospitalName + ", remarks=" + remarks
				+ "]";
	}
	
	@Override
	public BloodStock clone() {
		BloodStock bs = new BloodStock();
		bs.setBloodBank(bloodBank);
		bs.setBloodGroup(bloodGroup);
		bs.setCount(count);
		bs.setIssued(issued);
		bs.setBloodType(bloodType);
		bs.setIssued(issued);
		bs.setExpiryDate(expiryDate);
		bs.setIssuedDate(issuedDate);
		bs.setReceivedDate(receivedDate);
		return bs;
	}
	
	@Override
	public int hashCode() {
		return batch.hashCode();
	}
	
}
