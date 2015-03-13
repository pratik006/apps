package com.prapps.travel.test;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prapps.travel.service.TravelService;
import com.prapps.travel.vo.TravelComment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml", "classpath:spring-integration.xml"})
public class TravelTestClient {

	@Autowired
	private TravelService travelService;
	
	@Test
	public void testAddComment() {
		TravelComment tm = new TravelComment();
		tm.setBlogId(1L);
		tm.setEmail("pratik006@gmail.com");
		tm.setComment("test123");
		tm.setTitle("ABC");
		tm.setName("pratik");
		travelService.saveComment(tm);
	}
	
	@Test
	public void testRetrieveBlogComments() {
		Collection<TravelComment> travelComments = travelService.loadAll(1L);
		assert(travelComments.size()>1);
		for(TravelComment tm : travelComments) {
			System.out.println(tm);
		}
	}
}
