package com.prapps.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractAppsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List loadEntity(Class clazz) {
		return getSession().createCriteria(clazz).list();
	}
	
	public Object loadDistinctEntity(Class clazz, Serializable id) {
		return getSession().load(clazz, id);
	}
	
	public List loadEntity(Class clazz, String filterColumn, Object filterValue) {
		return getSession().createCriteria(clazz).add(Restrictions.eq(filterColumn, filterValue)).list();
	}
	
	public Object loadDistinctEntity(Class clazz, String filterColumn, Object filterValue) {
		return getSession().createCriteria(clazz).add(Restrictions.eq(filterColumn, filterValue)).uniqueResult();
	}
	
	public Object loadDistinctEntity(Class clazz, String[] filterColumns, Object[] filterValues) {
		Criteria criteria = getSession().createCriteria(clazz);
		for(int i=0;i<filterColumns.length;i++) {
			criteria.add(Restrictions.eq(filterColumns[i], filterValues[i]));
		}
		return criteria.uniqueResult();
	}
	
	public Object loadDistinctEntity(Class clazz, String[] filterColumns, Object[] filterValues, String[] selectedColumns, boolean unique) {
		Criteria criteria = getSession().createCriteria(clazz);
		for(int i=0;i<filterColumns.length;i++) {
			if(null != filterValues[i]) {
				criteria.add(Restrictions.eq(filterColumns[i], filterValues[i]));
			}
			else {
				criteria.add(Restrictions.isNull(filterColumns[i]));
			}
		}
		
		if(selectedColumns != null && selectedColumns.length > 0) {
			ProjectionList projectionList = Projections.projectionList();
			for(String column : selectedColumns) {
				 projectionList.add( Projections.property(column), column);
			}
			criteria.setProjection(projectionList);
			criteria.setResultTransformer(Transformers.aliasToBean((clazz)));
		}
		return criteria.uniqueResult();
	}
	
	public List loadEntity(Class clazz, String[] filterColumns, Object[] filterValues, String[] selectedColumns) {
		Criteria criteria = getSession().createCriteria(clazz);
		if(null != filterColumns && filterColumns.length > 0) {
			for(int i=0;i<filterColumns.length;i++) {
				if(filterValues[i] instanceof String) {
					if(null != filterValues[i]) {
						criteria.add(Restrictions.like(filterColumns[i], filterValues[i]));
					}
					else {
						criteria.add(Restrictions.isNull(filterColumns[i]));
					}
				}
				else {
					if(null != filterValues[i]) {
						criteria.add(Restrictions.eq(filterColumns[i], filterValues[i]));
					}
					else {
						criteria.add(Restrictions.isNull(filterColumns[i]));
					}
				}
			}
		}
		
		if(selectedColumns != null && selectedColumns.length > 0) {
			ProjectionList projectionList = Projections.projectionList();
			for(String column : selectedColumns) {
				 projectionList.add( Projections.property(column), column);
			}
			criteria.setProjection(projectionList);
		}
		return criteria.list();
	}
	
	public void save(Object object) {
		getSession().saveOrUpdate(object);		
	}
	
	public void delete(Object object) {
		getSession().delete(object);		
	}
		
	public Object findObjectById(Class clazz, long id) {
		return getSession().load(clazz, id);
	}
		
	public void update(Object object) {
		getSession().update(object);
	}
}
