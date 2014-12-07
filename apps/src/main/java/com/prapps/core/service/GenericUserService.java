package com.prapps.core.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.prapps.core.vo.User;


public interface GenericUserService extends UserDetailsService {

	public User getUserByName(String username);
	
	public void printRTEContent(String content);
}
