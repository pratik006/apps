package com.prapps.travel.service;

import java.util.Collection;

import com.prapps.travel.vo.TravelComment;

public interface TravelService {

	void saveComment(TravelComment travelComment);
	Collection<TravelComment> loadAll(Long blogId);
}
