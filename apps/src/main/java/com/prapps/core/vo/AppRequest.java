package com.prapps.core.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.prapps.core.web.consts.KeyConsts;

public class AppRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2631644792667382819L;
	private String appCode;
	private String path;
	private String action;
	private User user;
	private Map<String,Object> context;
	
	public AppRequest() {
		context = new HashMap<String, Object>();
	}
	
	public AppRequest(Object object) {
		this();
		add(KeyConsts.ROOT_OBJECT.toString(), object);
	}
	
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void add(String key, Object value) {
		context.put(key, value);
	}
	
	public Object remove(String key) {
		return context.remove(key);
	}
	
	public Object get(String key) {
		if(null != key && context.containsKey(key)) {
			return context.get(key);
		}
		return null;
	}

	public Map<String, Object> getContext() {
		return context;
	}

	@Override
	public String toString() {
		return "AppRequest [appCode=" + appCode + ", path=" + path + ", action=" + action + ", user=" + user + ", context=" + context + "]";
	}
	
}
