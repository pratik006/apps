package com.prapps.ongc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prapps.core.vo.AppRequest;
import com.prapps.core.vo.User;
import com.prapps.ongc.dao.OngcDao;
import com.prapps.ongc.domain.Performance;

@Service("ongcService")
@Transactional(readOnly=true)
public class OngcServiceImpl implements OngcService {

	@Autowired
	private OngcDao ongcDao;
	@Transactional(readOnly=false)
	public com.prapps.ongc.vo.Performance addPerformance(Performance performance) {
		return new com.prapps.ongc.vo.Performance(ongcDao.addPerformance(performance));
	}
	
	@Override
	public List<com.prapps.ongc.vo.Performance> getPerformance(com.prapps.core.vo.User user) {
		List<Performance> performanceDom = ongcDao.getPerformances(user);
		List<com.prapps.ongc.vo.Performance> performances = new ArrayList<com.prapps.ongc.vo.Performance>(performanceDom.size());
		for(Performance pd : performanceDom) {
			performances.add(new com.prapps.ongc.vo.Performance(pd));
		}
		return performances;
	}
	
	public User getUserInfo(String userName) {
		return new User(ongcDao.getUserInfo(userName));
	}
	
	@Override
	public List<User> getPlayersList() {
		List<User> users = new ArrayList<User>();
		for(com.prapps.core.domain.User userDomain : ongcDao.getPlayerList()) {
			users.add(new User(userDomain));
		}
		return users;
	}
}
