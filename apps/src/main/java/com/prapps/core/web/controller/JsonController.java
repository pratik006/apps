package com.prapps.core.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prapps.core.vo.AppRequest;
import com.prapps.core.vo.User;
import com.prapps.core.vo.Wrapper;

@Controller
@RequestMapping("/json")
@SessionAttributes(value="user")
/*@Transactional*/
public class JsonController extends AbstractController {

	private static Logger LOG = Logger.getLogger(JsonController.class);
	
	@RequestMapping(value="/{appCode}/{path}/{subpath}", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Object handleJsonRequest3(@PathVariable String appCode, @PathVariable String path, @PathVariable String subpath, @RequestParam(value="action",required=false) String action, HttpServletRequest req, @ModelAttribute User user) {
		LOG.info("appCode: "+appCode+"\tPath: "+path+"\tsubpath: "+subpath);
		LOG.info("user: "+user);
		AppRequest appRequest = createAppRequest(appCode, path, subpath);
		appRequest.setUser(user);
		Object response = null;
		try {
			response = defaultGateway.send(appRequest, path, subpath, appCode, "DEFAULT_ACTION");
			return response;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		LOG.debug("response: "+response);
		return new Wrapper();
	}
	
	@RequestMapping(value="/{appCode}/*action*", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Object handleJsonRequest(@PathVariable String appCode, @RequestParam("action") String action, HttpServletRequest req) {
		LOG.info("action: "+action+"\tappCode: "+appCode);
		AppRequest appRequest = createAppRequest(req, appCode, null, action);
		Object response = defaultGateway.send(appRequest, null, appCode, action);
		LOG.debug("response: "+response);
		return response;
	}
	
	@RequestMapping(value="/{appCode}/{path}", method={RequestMethod.GET, RequestMethod.POST}, params="action!= null")
	public @ResponseBody Object handleJsonRequest(@PathVariable String appCode, @PathVariable String path, @RequestParam(value="action", required=true) String action, HttpServletRequest req,@ModelAttribute("user") User user, @RequestBody String body) {
		LOG.info("action: "+action+"\tappCode: "+appCode+"\tPath: "+path);
		AppRequest appRequest = createAppRequest(req, appCode, path, action);
		appRequest.add("body", body);
		appRequest.setUser(user);
		Object response = null;
		try {
			response = defaultGateway.send(appRequest, appCode, path, action);
			if(List.class.isAssignableFrom(response.getClass())) {
				return new Wrapper((List)response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		LOG.debug("response: "+response);
		return response;
	}
	
	@RequestMapping(value="/{appCode}/{path}", method={RequestMethod.GET, RequestMethod.POST}, params="action==null", consumes={"text/json"})
	public @ResponseBody Object handleJsonRequest2(@PathVariable String appCode, @PathVariable String path, HttpServletRequest req,@ModelAttribute("user") User user, @RequestBody String body) {
		LOG.info("\tappCode: "+appCode+"\tPath: "+path);
		AppRequest appRequest = createAppRequest(req, appCode, path, "DEFAULT_ACTION");
		appRequest.setUser(user);
		appRequest.add("body", body);
		appRequest = (AppRequest) defaultGateway.send(appRequest, path, appCode, "DEFAULT_ACTION");
		Object response = defaultGateway.send(appRequest, appCode, path, "DEFAULT_ACTION");
		LOG.debug("response: "+response);
		return response;
	}
	
	@RequestMapping(value="/{appCode}/getUserInfo", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody User getUserInfo(@ModelAttribute("user") User user) {
		return user;
	}
	
	@RequestMapping(value="/cs/ip", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String handleCSRequest(HttpServletRequest req, @RequestParam("action") String action, @RequestParam(value="ip", required=false) String ip) {
		LOG.debug("handle for Chess Server");
		if("set".equals(action)) {
			req.getSession().getServletContext().setAttribute("ip", ip);
		}
		else {
			return (String)req.getSession().getServletContext().getAttribute("ip");
		}
		return ip;
	}
}
