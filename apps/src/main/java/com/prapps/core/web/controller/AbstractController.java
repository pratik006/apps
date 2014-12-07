package com.prapps.core.web.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prapps.core.vo.AppRequest;
import com.prapps.core.web.consts.KeyConsts;
import com.prapps.core.web.gateway.DefaultGateway;

public class AbstractController {
	
	private static Logger LOG = Logger.getLogger(AbstractController.class);
	
	@Autowired
	protected DefaultGateway defaultGateway;
	@Resource(name="navigationConfig")
	protected Properties navigationConfig;
	
	@RequestMapping(value="/login", method={RequestMethod.GET})
	public ModelAndView login() {
		LOG.info("login page redirect");
		return new ModelAndView("/Login");
	}
	
	public AppRequest createAppRequest(Object object) {
		AppRequest appRequest = new AppRequest();
		appRequest.add(KeyConsts.ROOT_OBJECT.toString(), object);
		return appRequest;
	}
	
	public AppRequest createAppRequest(HttpServletRequest req, String appCode, String path, String action) {
		AppRequest appRequest = new AppRequest();
		appRequest.setAction(action);
		appRequest.setAppCode(appCode);
		appRequest.setPath(path);
		if(null != req) {
			for(Object key : req.getParameterMap().keySet()) {
				appRequest.add((String) key, req.getParameterMap().get(key));
			}
		}
		return appRequest;
	}
	
	public AppRequest createAppRequest(String appCode, String path, String action) {
		AppRequest appRequest = new AppRequest();
		appRequest.setAction(action);
		appRequest.setAppCode(appCode);
		appRequest.setPath(path);
		return appRequest;
	}
}
