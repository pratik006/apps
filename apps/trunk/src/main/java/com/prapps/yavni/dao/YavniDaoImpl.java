package com.prapps.yavni.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.prapps.core.dao.AbstractAppsDao;
import com.prapps.yavni.domain.BloodStock;
import com.prapps.yavni.domain.UserBank;
import com.prapps.yavni.domain.UserBankPk;
import com.prapps.yavni.dto.BloodGroupData;
import com.prapps.yavni.dto.BloodReport;
import com.prapps.yavni.mapper.BloodGroupDataMapper;
import com.prapps.yavni.util.YavniDateUtil;
import com.prapps.yavni.util.YavniUtil;

@Service
public class YavniDaoImpl extends AbstractAppsDao implements YavniDao {

	private BloodGroupDataMapper bloodGroupDataMapper = new BloodGroupDataMapper();	
	
	@Override
	public List getBloodStockByBankId(long bankId) {
		Criteria criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.eq("verified", true))
				.add(Restrictions.eq("approved", true))
				.add(Restrictions.eq("bloodBank.bankId", bankId))
				.add(Restrictions.or(Restrictions.eq("issued", false), Restrictions.isNull("issued")));
		Projection projection = Projections.projectionList()
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.groupProperty("bloodType"), "bloodType")
				.add(Projections.rowCount(), "count")
				.add(Projections.max("receivedDate"), "recent")
				.add(Projections.min("receivedDate"), "oldest");
				
		criteria.setProjection(projection);
		criteria.addOrder(Order.asc("bloodGroup")); 
		//criteria.setResultTransformer(Transformers.aliasToBean((BloodGroupData.class)));
		criteria.setResultTransformer(new BloodGroupDataMapper());
		return criteria.list();
	}
	
	@Override
	public List getAllBloodStockByBankId(long bankId) {
		Criteria criteria = getSession().createCriteria(BloodStock.class);
		criteria.addOrder(Order.asc("receivedDate")); 
		criteria.createCriteria("bloodBank", "child", Criteria.INNER_JOIN)
			.add(Restrictions.eq("child.bankId", bankId));
		return criteria.list();
	}
	
	@Override
	public List getBloodStock() {
		Criteria criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.eq("verified", true))
				.add(Restrictions.eq("approved", true))
				.add(Restrictions.eq("issued", false));
		Projection projection = Projections.projectionList()
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.groupProperty("child.name"), "bankName")
				.add(Projections.rowCount(), "count")
				.add(Projections.max("receivedDate"), "recent")
				.add(Projections.min("receivedDate"), "oldest");
				
		criteria.setProjection(projection);
		criteria.addOrder(Order.asc("bloodGroup"))
		.createCriteria("bloodBank", "child", Criteria.INNER_JOIN); 
		criteria.setResultTransformer(bloodGroupDataMapper);
		return criteria.list();
	}
	
	@Override
	public Object getRecentBlood(String bloodGroup, String bloodType) {
		Criteria criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.eq("bloodGroup", bloodGroup))
				.add(Restrictions.eq("bloodType", bloodType))
				.add(Restrictions.eq("verified", true))
				.add(Restrictions.eq("approved", true))
				.add(Restrictions.eq("issued", false))
				.add(Restrictions.gt("expiryDate", YavniUtil.getCurrentTimestamp()))
				.addOrder(Order.desc("receivedDate"));				
		Projection projectionList = Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("batch"), "batch")
				.add(Projections.property("id"), "id")
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.property("child.name"), "bankName")
				.add(Projections.property("receivedDate"), "receivedDate");
		criteria.setProjection(projectionList);
		criteria.createCriteria("bloodBank", "child", Criteria.INNER_JOIN)
			.setResultTransformer(bloodGroupDataMapper);
		List list = criteria.list();
		if(list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	@Override
	public Object getOldestBlood(String bloodGroup, String bloodType) {
		Criteria criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.eq("bloodGroup", bloodGroup))
				.add(Restrictions.eq("bloodType", bloodType))
				.add(Restrictions.eq("verified", true))
				.add(Restrictions.eq("approved", true))
				.add(Restrictions.eq("issued", false))
				.add(Restrictions.gt("expiryDate", YavniUtil.getCurrentTimestamp()))
				.addOrder(Order.asc("receivedDate"));				
		Projection projectionList = Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("batch"), "batch")
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.property("child.name"), "bankName")
				.add(Projections.property("receivedDate"), "receivedDate");
		criteria.setProjection(projectionList);
		criteria.createCriteria("bloodBank", "child", Criteria.INNER_JOIN)
			.setResultTransformer(Transformers.aliasToBean((BloodGroupData.class)));
		List list = criteria.list();
		if(list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	@Override
	public List<BloodReport> generateBloodReport(Date date) {
		Criteria criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.eq("receivedDate", date));	
		Projection projectionList = Projections.projectionList()
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.groupProperty("bloodType"), "bloodType")
				.add(Projections.property("child.name"), "bankName")
				.add(Projections.rowCount(), "bloodInCount");
		criteria.setProjection(projectionList);
		criteria.createCriteria("bloodBank", "child", Criteria.INNER_JOIN);
		criteria.setResultTransformer(Transformers.aliasToBean((BloodReport.class)));
		List<BloodReport> list = criteria.list();
		
		Date dt2 = YavniDateUtil.addDay(date);
		criteria = getSession().createCriteria(BloodStock.class)
				.add(Restrictions.and(Restrictions.gt("receivedDate", date), Restrictions.lt("receivedDate", dt2)));	
		projectionList = Projections.projectionList()
				.add(Projections.groupProperty("bloodGroup"), "bloodGroup")
				.add(Projections.groupProperty("bloodType"), "bloodType")
				.add(Projections.property("child.name"), "bankName")
				.add(Projections.rowCount(), "bloodOutCount");
		criteria.setProjection(projectionList);
		criteria.createCriteria("bloodBank", "child", Criteria.INNER_JOIN);
		criteria.setResultTransformer(Transformers.aliasToBean((BloodReport.class)));
		list.addAll(criteria.list());
		return list;
	}
	
	@Override
	public UserBank getUserBank(Long userId) {
		return ((UserBank)getSession().createCriteria(UserBank.class)
		.add(Restrictions.eq("userBankPk.user.userId", userId)).uniqueResult());
	}
}
