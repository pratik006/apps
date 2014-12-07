package com.prapps.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.prapps.core.dao.ConfigDao;
import com.prapps.core.vo.User;
import com.prapps.ongc.vo.Performance;
import com.prapps.yavni.domain.UserBank;
import com.prapps.yavni.dto.YavniUser;
import com.prapps.yavni.service.YavniService;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml", "classpath:spring-integration.xml"})
@Transactional*/
public class AppServiceTest {/*

	private static final Logger LOG = Logger.getLogger(AppServiceTest.class);
	
	@Autowired
	private YavniService yavniService;
	
	@Test
	public void testLoadUserBank() {
		List<UserBank> userBanks = yavniService.loadAll(UserBank.class);
		for(UserBank userBank : userBanks) {
			LOG.debug("userBank: "+userBank);
		}
	}
	
	@Test
	public void testGetYavniUser() {
		YavniUser yavniUser = yavniService.getYavniUserDetail(1006l);
		LOG.debug("yavniUser: "+yavniUser);
		assert(yavniUser.getBloodBank().getBankId()==2);
	}
	
	@Autowired 
	private ConfigDao configDao;
	
	@Test
	@Transactional
	public void testGetUserAttr() {
		com.prapps.core.domain.User user = (com.prapps.core.domain.User) configDao.loadDistinctEntity(com.prapps.core.domain.User.class, "userId", 2002l);
		assert(user.getUserAttributes().get(0).getAttributeValue()!=null);
	}
*/}
