package com.prapps.yavni.service;

import com.prapps.yavni.domain.BloodBank;
import com.prapps.yavni.domain.Donor;
import com.prapps.yavni.domain.Organization;

public interface YavniSearchService {

	com.prapps.core.vo.User findUserByName(String uname);
	Donor findDonorByName(String firstName, String lastName);
	com.prapps.yavni.dto.BloodStock findBloodPacketByBatch(String batch);
	Organization findOrganizationByName(String organizationName);
	Donor findDonorById(long donorId);
	BloodBank findBloodBankById(long bloodBankId);
	Object findObjectById(Class clazz, long id);
	boolean isUniqueBatch(String batch);
	
}
