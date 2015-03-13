package com.prapps.yavni.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prapps.yavni.dto.BloodStock;
import com.prapps.yavni.dto.YavniConsts;
import com.prapps.yavni.util.YavniDateUtil;

@Component
public class BloodStockMapper {

	public BloodStock mapBloodStock(com.prapps.yavni.domain.BloodStock bloodStockDomain) {
		if(null == bloodStockDomain) {
			return null;
		}
		BloodStock bloodStock = new BloodStock();
		bloodStock.setId(bloodStockDomain.getId());
		bloodStock.setBloodGroup(bloodStockDomain.getBloodGroup());
		bloodStock.setReceivedDate(YavniDateUtil.dateToString(bloodStockDomain.getReceivedDate()));
		bloodStock.setBloodType(bloodStockDomain.getBloodType());
		bloodStock.setBatch(bloodStockDomain.getBatch());
		if(bloodStockDomain.getIssued() != null && bloodStockDomain.getIssued()) {
			bloodStock.setDeleted(YavniConsts.ISSUED);
		}
		
		bloodStock.setExpiryDate(YavniDateUtil.dateToString(bloodStockDomain.getExpiryDate()));
		bloodStock.setIssuedDate(YavniDateUtil.dateToString(bloodStockDomain.getExpiryDate()));
		bloodStock.setBloodBankName(bloodStockDomain.getBloodBank().getName());
		bloodStock.setBloodBankId(bloodStockDomain.getBloodBank().getBankId());
		if(null != bloodStockDomain.getBloodBank().getAddress()) {
			bloodStock.setBloodBankPin(bloodStockDomain.getBloodBank().getAddress().getPin());
			bloodStock.setBloodBankAddressLine1(bloodStockDomain.getBloodBank().getAddress().getAddressLine1());
		}
		bloodStock.setPatientName(bloodStockDomain.getPatientName());
		bloodStock.setDoctorName(bloodStockDomain.getDoctorName());
		bloodStock.setHospitalName(bloodStockDomain.getHospitalName());
		bloodStock.setBedNumber(bloodStockDomain.getBedNumber());
		bloodStock.setRemarks(bloodStockDomain.getRemarks());
		
		bloodStock.setVerified(String.valueOf(bloodStockDomain.isVerified()));
		bloodStock.setVerifiedBy(bloodStockDomain.getVerifiedBy());
		bloodStock.setVerifiedDate(YavniDateUtil.dateToString(bloodStockDomain.getVerifiedTS()));
		bloodStock.setVerifierRemark(bloodStockDomain.getVerifierRemarks());
		bloodStock.setApproved(String.valueOf(bloodStockDomain.isApproved()));
		bloodStock.setApprovedBy(bloodStockDomain.getApprovedBy());
		bloodStock.setApprovedDate(YavniDateUtil.dateToString(bloodStockDomain.getApprovedTS()));
		bloodStock.setApproverRemark(bloodStockDomain.getVerifierRemarks());
		bloodStock.setCreatedBy(bloodStockDomain.getCreatedBy());
		bloodStock.setCreatedDate(YavniDateUtil.dateToString(bloodStockDomain.getCreatedTS()));
		bloodStock.setUpdatedBy(bloodStockDomain.getUpdatedBy());
		bloodStock.setUpdatedDate(YavniDateUtil.dateToString(bloodStockDomain.getUpdatedTS()));
		
		if(bloodStockDomain.isVerified()) {
			bloodStock.setVerified(YavniConsts.VERIFIED);
		}
		else {
			bloodStock.setVerified(YavniConsts.NOT_VERIFIED);
		}
		if(bloodStockDomain.isApproved()) {
			bloodStock.setApproved(YavniConsts.APPROVED);
		}
		else {
			bloodStock.setApproved(YavniConsts.NOT_APPROVED);
		}
		bloodStock.setCount(bloodStockDomain.getCount());
		return bloodStock;
	}
	
	public List<BloodStock> mapBloodStock(List<com.prapps.yavni.domain.BloodStock> bloodStockDomains) {
		if(null != bloodStockDomains && bloodStockDomains.size() > 0) {
			List<BloodStock> bloodStocks = new ArrayList<BloodStock>(bloodStockDomains.size());
			for(com.prapps.yavni.domain.BloodStock bloodStockDomain : bloodStockDomains) {
				bloodStocks.add(mapBloodStock(bloodStockDomain));
			}
			return bloodStocks;
		}
		return new ArrayList<BloodStock>(0);
	}
}
