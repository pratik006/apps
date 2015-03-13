package com.prapps.yavni.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.prapps.yavni.domain.UserBank;
import com.prapps.yavni.dto.BloodReport;

public interface YavniDao {

	List getBloodStockByBankId(long bankId);

	List getBloodStock();

	Object getRecentBlood(String bloodGroup, String bloodType);

	List<BloodReport> generateBloodReport(Date date);

	Object getOldestBlood(String bloodGroup, String bloodType);

	List getAllBloodStockByBankId(long bankId);
	
	
	// to be deleted
	public List loadEntity(Class clazz);
	
	public List loadEntity(Class clazz, String filterColumn, Object filterValue);
	
	public Object loadDistinctEntity(Class clazz, String filterColumn, Object filterValue);
	
	public Object loadDistinctEntity(Class clazz, String[] filterColumns, Object[] filterValues);
	
	public Object loadDistinctEntity(Class clazz, String[] filterColumns, Object[] filterValues, String[] selectedColumns, boolean unique);
	
	public List loadEntity(Class clazz, String[] filterColumns, Object[] filterValues, String[] selectedColumns);
	
	public void save(Object object);
	
	public void delete(Object object);
		
	public Object findObjectById(Class clazz, long id);
		
	public void update(Object object);

	UserBank getUserBank(Long userId);
}
