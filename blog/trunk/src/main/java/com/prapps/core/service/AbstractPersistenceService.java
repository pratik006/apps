package com.prapps.core.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class AbstractPersistenceService {

	@Autowired private MongoTemplate mongoTemplate;
	
	protected <T> void save(T t) {
		mongoTemplate.save(t);
	}

	protected <T> T findById(Class<T> clazz, String key) {
		return (T) mongoTemplate.findById(key, clazz);
	}

	protected <T> Collection<T> findByCriteria(Class<T> clazz,Criteria criteria) {
		Query query = new Query();
		query.addCriteria(criteria);
		return (Collection<T>) mongoTemplate.find(query, clazz);
	}

}
