package com.prapps.ongc.service;

import java.util.List;

import com.prapps.core.vo.AppRequest;
import com.prapps.core.vo.User;
import com.prapps.ongc.domain.Performance;

public interface OngcService {

	com.prapps.ongc.vo.Performance addPerformance(Performance performance);

	List<com.prapps.ongc.vo.Performance> getPerformance(com.prapps.core.vo.User user);

	List<User> getPlayersList(); 
}
