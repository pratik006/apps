package com.prapps.ongc.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prapps.core.vo.User;
import com.prapps.ongc.service.OngcService;
import com.prapps.ongc.vo.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml", "classpath:spring-integration.xml"})
public class OngcServiceTester {

	@Autowired
	private OngcService ongcService;
	
	@Test
	public void testAddPerformance() {
		Performance performance =  new Performance();
		performance.setRank("1");
		performance.setRemarks("test");
		performance.setScore("9/10");
		performance.setTmtDate(new Date());
		performance.setTmtName("abc");
		performance.setVenue("Kolkata");
		User user = new User();
		user.setUserId(2002);
		/*performance.setUser(user);
		performance = ongcService.addPerformance(performance);*/
		System.out.println(performance);
	}
	
	@Test
	public void testGetPerformance() {
		User user = new User();
		user.setUserId(2002);		
		List<Performance> performances = ongcService.getPerformance(user);
		System.out.println(performances);
	}
}
