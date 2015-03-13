package com.prapps.yavni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prapps.yavni.dao.YavniDao;
import com.prapps.yavni.domain.BloodBank;
import com.prapps.yavni.domain.BloodStock;
import com.prapps.yavni.domain.Organization;
import com.prapps.yavni.domain.Donor;
import com.prapps.core.domain.User;
import com.prapps.yavni.mapper.BloodStockMapper;

@Service
@Transactional(readOnly=true)
public class YavniSearchServiceImpl implements YavniSearchService {

	@Autowired
	private YavniDao yavniDao;
	@Autowired
	private BloodStockMapper bloodStockMapper;
	
	@Override
	public com.prapps.core.vo.User findUserByName(String uname) {
		User user = (User) yavniDao.loadDistinctEntity(User.class, new String[] {"userName"}, new String[] {uname}, 
				null, true);
		return new com.prapps.core.vo.User(user);
	}
	
	@Override
	public Object findObjectById(Class clazz, long id) {
		return yavniDao.findObjectById(clazz, id);
	}
	
	@Override
	public BloodBank findBloodBankById(long bloodBankId) {
		BloodBank bank = (BloodBank) yavniDao.loadDistinctEntity(BloodBank.class, "id", bloodBankId);
		return bank;
	}
	
	@Override
	public Donor findDonorByName(String firstName, String lastName) {
		Donor donor = (Donor) yavniDao.loadDistinctEntity(Donor.class, new String[]{"firstName", "lastName"}, new String[]{firstName, lastName});
		return donor;
	}
	
	@Override
	public Donor findDonorById(long donorId) {
		Donor donor = (Donor) yavniDao.loadDistinctEntity(Donor.class, new String[]{"donorId"}, new Object[]{donorId});
		return donor;
	}
	
	@Override
	public Organization findOrganizationByName(String organizationName) {
		Organization organization = (Organization) yavniDao.loadDistinctEntity(Organization.class, new String[]{"organizationName"}, new String[]{organizationName});
		return organization;
	}	
	
	@Override
	public com.prapps.yavni.dto.BloodStock findBloodPacketByBatch(String batch) {
		com.prapps.yavni.dto.BloodStock bloodStock = bloodStockMapper.mapBloodStock((BloodStock)yavniDao.loadDistinctEntity(BloodStock.class, "batch", batch));
		return bloodStock;
	}
	
	@Override
	public boolean isUniqueBatch(String batch) {
		List list = yavniDao.loadEntity(BloodStock.class, new String[]{"batch"}, new String[]{batch}, new String[]{"batch"});
		return (list == null) || (list.size() == 0);
	}
}
