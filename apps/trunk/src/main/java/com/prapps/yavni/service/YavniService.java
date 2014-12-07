package com.prapps.yavni.service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.prapps.core.domain.User;
import com.prapps.yavni.domain.BloodBank;
import com.prapps.yavni.domain.BloodStock;
import com.prapps.yavni.domain.Organization;
import com.prapps.yavni.dto.BloodReport;
import com.prapps.yavni.dto.Event;
import com.prapps.yavni.dto.YavniUser;
import com.prapps.yavni.exception.BusinessException;

public interface YavniService {

	void saveBloodBank(BloodBank bloodBank);
	List loadAll(Class clazz);
	BloodBank getBloodBank(String bloodBankName);
	void saveCamp(Organization camp);
	User login(String uname, String password);
	User saveUser(User user);
	User getUser(String userName);
	void deleteUser(String userName);
	void saveObject(Object object);
	List getIssuableBloodByBankId(long bankId);
	void deleteObject(Class clazz, String uniqueColumn, Object uniqueValue);
	List<com.prapps.yavni.dto.BloodStock> loadBloodPackets();
	List getBloodStock();
	Object fetchRecentBlood(String bloodGroup, String bloodType);
	List<BloodReport> generateBloodReport(Date date);
	Object fetchOldestBlood(String bloodGroup, String bloodType);
	List<com.prapps.yavni.dto.BloodStock> getAllBloodStockByBankId(Long bankId);
	Collection<com.prapps.yavni.dto.Organization> loadAllOrganizations();
	
	List<com.prapps.yavni.dto.BloodStock> getVerifiableBloodStocks(Long bankId);
	List<com.prapps.yavni.dto.BloodStock> getApprovableBloodStocks(Long bankId);
	Collection<com.prapps.core.vo.User> loadAllUsers();
	Collection<com.prapps.yavni.dto.BloodBank> loadAllBanks();
	void updateBloodStock(List<com.prapps.yavni.dto.BloodStock> bloodStocks, String verifier);
	void saveBloodStock(BloodStock bloodStock, String userName);
	void issuePacket(com.prapps.yavni.dto.BloodStock bs, com.prapps.core.vo.User user);
	List<com.prapps.yavni.dto.BloodStock> getIssuableBloodStocks(Long bankId);
	void updateBatchTransfer(List<com.prapps.yavni.dto.BloodStock> bloodStocks) throws BusinessException;
	Long saveEvent(Event event);
	Event findEvent(Long eventId);
	YavniUser getYavniUserDetail(Long userId);
}
