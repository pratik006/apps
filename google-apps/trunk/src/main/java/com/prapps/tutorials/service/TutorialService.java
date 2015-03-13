package com.prapps.tutorials.service;

import org.springframework.stereotype.Service;

import com.prapps.core.vo.AppRequest;

@Service
public class TutorialService {

	public Object createPage(AppRequest appRequest) {
		return appRequest;
	}
}
