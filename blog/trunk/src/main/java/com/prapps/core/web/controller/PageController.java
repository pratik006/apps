package com.prapps.core.web.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.prapps.core.vo.AppRequest;
import com.prapps.core.vo.User;

@Controller
@RequestMapping("/page")
@SessionAttributes("user")
public class PageController extends AbstractController {

	private static Logger LOG = Logger.getLogger(PageController.class);
	
	@Resource(name="navigationConfig")
	private Properties navigationConfig;
	
	@RequestMapping(value="/loginSuccess", method={RequestMethod.GET})
	public String handleRequest(@ModelAttribute User user) {
		String viewName = navigationConfig.getProperty(user.getAppCode());
		return "redirect:"+viewName;
	}
	
	@RequestMapping(value="/{appCode}", method={RequestMethod.GET})
	public ModelAndView handleRequest(@PathVariable String appCode, Authentication auth1, @ModelAttribute User user) {
		LOG.info("\tappCode: "+appCode);
		return new ModelAndView(appCode+navigationConfig.getProperty("home"));
	}
	
	@RequestMapping(value="/{appCode}/login", method={RequestMethod.GET})
	public ModelAndView handleRequestLogin(@PathVariable String appCode, @RequestParam(value="error", required=false) Boolean error) {
		LOG.info("\tin appCode: "+appCode);
		ModelAndView mv = new ModelAndView("/Login");
		mv.addObject("error", error);
		return mv;
	}
	
	@RequestMapping(value="/{appCode}/{page}", method={RequestMethod.GET})
	public ModelAndView handleRequest(@PathVariable String appCode, @PathVariable("page") String page, @RequestParam(value="action", required=false) String action, HttpServletRequest req, @ModelAttribute User user, @RequestBody String body) {
		LOG.info("\tappCode: "+appCode+"\tPage: "+page);
		LOG.debug("navigationConfig: "+appCode+navigationConfig.getProperty(page));
		ModelAndView mv = new ModelAndView(appCode+navigationConfig.getProperty(page));
		
		if(action != null) {
			AppRequest appRequest = createAppRequest(req, appCode, page, action);
			appRequest.add("body", body);
			appRequest.setUser(user);
			Object response = null;
			try {
				response = defaultGateway.send(appRequest, appCode, page, action);
				LOG.debug("response: "+response);
				mv.addObject("response", response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return mv;
	}
	
	@RequestMapping(value="/*.jsp", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		LOG.debug("handleRequest");
		return new ModelAndView("LoadCities.jsp");
	}
}
