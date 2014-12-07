package com.prapps.yavni.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prapps.core.domain.Role;
import com.prapps.core.domain.User;
import com.prapps.yavni.dao.YavniDao;
import com.prapps.yavni.domain.BloodBank;
import com.prapps.yavni.domain.BloodStock;
import com.prapps.yavni.domain.Event;
import com.prapps.yavni.domain.Organization;
import com.prapps.yavni.domain.UserBank;
import com.prapps.yavni.dto.BloodGroupData;
import com.prapps.yavni.dto.BloodReport;
import com.prapps.yavni.dto.YavniUser;
import com.prapps.yavni.exception.BusinessException;
import com.prapps.yavni.mapper.BloodStockMapper;
import com.prapps.yavni.mapper.DomainMapper;
import com.prapps.yavni.util.YavniUtil;

@Service("yavniService")
@Transactional(rollbackFor={BusinessException.class})
public class YavniServiceImpl implements YavniService {

	private static Logger LOG = Logger.getLogger(YavniService.class);
	@Autowired
	private YavniDao yavniDao;
	@Autowired
	private BloodStockMapper bloodStockMapper;
	@Autowired
	private DomainMapper domainMapper;
	
	@Override
	public User login(String uname, String password) {
		User user = (User) yavniDao.loadDistinctEntity(User.class, new String[] {"userName", "password"}, new String[] {uname,password}, new String[]{"userId", "userName", "firstName", "lastName", "roleStr", "bloodBank"}, true);
		return user;
	}
	
	@Override
	public void saveBloodBank(BloodBank bloodBank) {
		if(null != bloodBank) {
			yavniDao.save(bloodBank);
		}		
	}
	
	@Override
	public void saveCamp(Organization camp) {
		if(null != camp) {
			yavniDao.save(camp);
		}		
	}
	
	@Override
	public BloodBank getBloodBank(String bloodBankName) {
		List<BloodBank> list = yavniDao.loadEntity(BloodBank.class, "name", bloodBankName);
		if(null != list && list.size() > 0)
			return list.get(0);
		else return null;
	}
	
	@Override
	public List loadAll(Class clazz) {
		return yavniDao.loadEntity(clazz);
	}
	
	@Override
	public Collection<com.prapps.core.vo.User> loadAllUsers() {
		return domainMapper.mapUsers(yavniDao.loadEntity(User.class));
	}
	
	@Override
	public Collection<com.prapps.yavni.dto.BloodBank> loadAllBanks() {
		return domainMapper.mapBloodBanks(yavniDao.loadEntity(BloodBank.class));
	}
	
	@Override
	public Collection<com.prapps.yavni.dto.Organization> loadAllOrganizations() {
		return domainMapper.mapOrganizations(yavniDao.loadEntity(Organization.class));
	}
	
	@Override
	public User saveUser(User user) {		
		if(null != user.getRoles() && !user.getRoles().isEmpty()) {
			Set<Role> roles = new HashSet<Role>();
			for(Role temp : user.getRoles()) {
				Role role = (Role) yavniDao.loadDistinctEntity(Role.class, "id", temp.getId());
				roles.add(role);
			}				
			user.setRoles(roles);
		}		
		yavniDao.save(user);
		return (User) yavniDao.loadDistinctEntity(User.class, "userId", user.getUserId());
	}
	
	@Override
	@Transactional(propagation=Propagation.MANDATORY, readOnly=false)
	public void saveObject(Object object) {
		yavniDao.save(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.MANDATORY, readOnly=false)
	public void saveBloodStock(BloodStock bloodStock, String userName) {
		if(null == bloodStock.getIssued()) {
			bloodStock.setIssued(false);
		}
		bloodStock.setCreatedBy(userName);
		bloodStock.setUpdatedBy(userName);
		bloodStock.setCreatedTS(YavniUtil.getCurrentTimestamp());
		bloodStock.setEntryDate(YavniUtil.getCurrentTimestamp());
		yavniDao.save(bloodStock);
	}
	
	@Override
	public void deleteObject(Class clazz, String uniqueColumn, Object uniqueValue) {
		Object obj = yavniDao.loadDistinctEntity(clazz, uniqueColumn, uniqueValue);
		yavniDao.update(obj);
		//yavniDao.delete(obj);
	}
	
	public void deleteBloodStock(BloodStock bloodStock) {
		BloodStock bs = (BloodStock) yavniDao.loadDistinctEntity(BloodStock.class, "batch", bloodStock.getBatch());
		bs.setDoctorName(bloodStock.getDoctorName());
		bs.setHospitalName(bloodStock.getHospitalName());
		bs.setPatientName(bloodStock.getPatientName());
		bs.setRemarks(bloodStock.getRemarks());
		bs.setIssuedDate(bloodStock.getIssuedDate());
		yavniDao.update(bs);
	}

	@Override
	public User getUser(String userName) {
		return (User) yavniDao.loadDistinctEntity(User.class, "userName", userName);
	}
	
	@Override
	public void deleteUser(String userName) {
		User user = getUser(userName);
		yavniDao.delete(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BloodGroupData> getIssuableBloodByBankId(long bankId) {
		return yavniDao.getBloodStockByBankId(bankId);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List getBloodStock() {
		return yavniDao.getBloodStock();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<com.prapps.yavni.dto.BloodStock> loadBloodPackets() {
		return bloodStockMapper.mapBloodStock(yavniDao.loadEntity(BloodStock.class));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Object fetchOldestBlood(String bloodGroup, String bloodType) {
		return yavniDao.getOldestBlood(bloodGroup, bloodType);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Object fetchRecentBlood(String bloodGroup, String bloodType) {
		return yavniDao.getRecentBlood(bloodGroup, bloodType);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<BloodReport> generateBloodReport(Date date) {
		return yavniDao.generateBloodReport(date);
	}
	
	@Override
	public List<com.prapps.yavni.dto.BloodStock> getAllBloodStockByBankId(Long bankId) {
		return bloodStockMapper.mapBloodStock(yavniDao.getAllBloodStockByBankId(bankId));		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.prapps.yavni.dto.BloodStock> getVerifiableBloodStocks(Long bankId) {
		List<BloodStock> bss = yavniDao.loadEntity(BloodStock.class, new String[]{"bloodBank.bankId", "verified"}, new Object[]{bankId, false}, null);
		return bloodStockMapper.mapBloodStock(bss);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.prapps.yavni.dto.BloodStock> getApprovableBloodStocks(Long bankId) {
		List<BloodStock> bss = yavniDao.loadEntity(BloodStock.class, new String[]{"bloodBank.bankId", "verified", "approved", "issued"}, new Object[]{bankId, true, false, false}, null);
		return bloodStockMapper.mapBloodStock(bss);
	}
	
	@Override
	public List<com.prapps.yavni.dto.BloodStock> getIssuableBloodStocks(Long bankId) {
		List<BloodStock> bss = yavniDao.loadEntity(BloodStock.class, new String[]{"bloodBank.bankId", "verified", "approved", "issued"}, new Object[]{bankId, true, true, false}, null);
		return bloodStockMapper.mapBloodStock(bss);
	}
	
	@Override
	public void issuePacket(com.prapps.yavni.dto.BloodStock bs, com.prapps.core.vo.User user) {
		if(YavniUtil.isNotNull(bs.getBatch()) && YavniUtil.isNotNull(bs.getBloodGroup()) && YavniUtil.isNotNull(bs.getBloodType()) 
				&& YavniUtil.isNotNull(bs.getBloodBankId())) {
			BloodStock bloodStock = (BloodStock) yavniDao.findObjectById(BloodStock.class, bs.getId());
			bloodStock.setIssued(true);
			bloodStock.setPatientName(bs.getPatientName());
			bloodStock.setDoctorName(bs.getDoctorName());
			bloodStock.setHospitalName(bs.getHospitalName());
			bloodStock.setBedNumber(bs.getBedNumber());
			bloodStock.setRemarks(bs.getRemarks());
			bloodStock.setUpdatedBy(user.getUserName());
			bloodStock.setUpdatedTS(YavniUtil.getCurrentTimestamp());
			yavniDao.update(bloodStock);
		}
	}
	
	@Override
	public void updateBloodStock(List<com.prapps.yavni.dto.BloodStock> bloodStocks, String verifier) {
		for(com.prapps.yavni.dto.BloodStock bs : bloodStocks) {
			BloodStock bloodStock = (BloodStock) yavniDao.findObjectById(BloodStock.class, bs.getId());
			bloodStock.setUpdatedBy(verifier);
			bloodStock.setUpdatedTS(YavniUtil.getCurrentTimestamp());
			if("true".equals(bs.getVerified()) || "false".equals(bs.getVerified())) {
				bloodStock.setVerified(Boolean.parseBoolean(bs.getVerified()));
				bloodStock.setVerifiedBy(verifier);
				bloodStock.setVerifierRemarks(bs.getVerifierRemark());
				bloodStock.setVerifiedTS(new Timestamp(new java.util.Date().getTime()));
			}
			else if("true".equals(bs.getApproved()) || "false".equals(bs.getApproved())) {
				bloodStock.setApproved(Boolean.parseBoolean(bs.getApproved()));
				bloodStock.setApprovedBy(verifier);
				bloodStock.setApproverRemarks(bs.getApproverRemark());
				bloodStock.setApprovedTS(new Timestamp(new java.util.Date().getTime()));
			}
		}
	}
	
	@Override
	public void updateBatchTransfer(List<com.prapps.yavni.dto.BloodStock> bloodStocks) throws BusinessException {
		for(com.prapps.yavni.dto.BloodStock bloodStock : bloodStocks) {
			BloodStock bloodStockDomain =  (BloodStock) yavniDao.findObjectById(BloodStock.class, bloodStock.getId());
			if(null != bloodStockDomain) {
				bloodStockDomain.setIssued(true);
				bloodStockDomain.setIssuedDate(YavniUtil.getCurrentTimestamp());
				bloodStockDomain.getBloodBank().setBankId(bloodStock.getBloodBankId());
			}
			else {
				throw new BusinessException();
			}
		}
	}
	
	@Override
	public Long saveEvent(com.prapps.yavni.dto.Event event) {
		com.prapps.yavni.domain.Event eventDomain = domainMapper.mapEvent(event);
		yavniDao.save(eventDomain);
		return eventDomain.getEventId();
	}
	
	@Override
	public com.prapps.yavni.dto.Event findEvent(Long eventId) {
		return domainMapper.mapEvent((Event) yavniDao.findObjectById(Event.class, eventId));
	}
	
	@Override
	public YavniUser getYavniUserDetail(Long userId) {
		UserBank user = yavniDao.getUserBank(userId);
		com.prapps.yavni.dto.BloodBank bloodBank = new com.prapps.yavni.dto.BloodBank();
		BeanUtils.copyProperties(user.getBloodBank(), bloodBank);
		YavniUser yavniUser = new YavniUser();
		BeanUtils.copyProperties(user.getUser(), yavniUser);
		LOG.trace(yavniUser);
		return yavniUser;
	}
}
