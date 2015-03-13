package com.prapps.travel.service;

import java.util.Collection;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.prapps.core.service.AbstractPersistenceService;
import com.prapps.travel.vo.TravelComment;

@Service("travelService")
public class TravelServiceImpl extends AbstractPersistenceService implements TravelService {

	//private static final String TRAVEL_COLLECTION = "travel";
	
	@Override
	public void saveComment(TravelComment travelComment) {
		save(travelComment);
	}

	@Override
	public Collection<TravelComment> loadAll(Long blogId) {
		return findByCriteria(TravelComment.class, Criteria.where("blogId").in(1L));
	}

}
