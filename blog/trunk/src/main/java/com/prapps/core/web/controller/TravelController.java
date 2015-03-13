package com.prapps.core.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prapps.travel.service.TravelService;
import com.prapps.travel.vo.TravelComment;

@Controller
@RequestMapping("/travel")
public class TravelController {

	private static Logger LOG = Logger.getLogger(TravelController.class);
	
	@Autowired
	private TravelService travelService;
	
	@RequestMapping(value="/load/{blogId}", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Collection<TravelComment> getBlogComments(@PathVariable Long blogId) {
		LOG.trace("blogId: "+blogId);
		return travelService.loadAll(blogId);
	}
	
	@RequestMapping(value="/save/{blogId}", method={RequestMethod.POST})
	public @ResponseBody String saveComment(@PathVariable Long blogId, @RequestBody TravelComment travelComment) {
		LOG.trace("travelComment: "+travelComment);
		travelComment.setBlogId(blogId);
		travelService.saveComment(travelComment);
		return "success";
	}
}
