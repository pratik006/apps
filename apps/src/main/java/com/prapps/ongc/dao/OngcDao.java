package com.prapps.ongc.dao;

import java.util.List;

import com.prapps.core.domain.User;
import com.prapps.ongc.domain.Performance;

public interface OngcDao {

	Performance addPerformance(Performance performance);


	List<Performance> getPerformances(com.prapps.core.vo.User user);


	User getUserInfo(String userName);


	List<User> getPlayerList();
}
