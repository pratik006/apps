package com.prapps.app.core.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prapps.app.core.dataaccess.BlogRepository;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Inject BlogRepository blogRepository;	

	@RequestMapping("/hello")
	public @ResponseBody String test() {
		return "hello world";
	}
	
	@RequestMapping("/blogs")
	public @ResponseBody Object getBlog() {
		return blogRepository.findAll();
	}
	
	@RequestMapping("/blogs/{id}")
	public @ResponseBody Object getBlog(@PathVariable("id") Long id) {
		return blogRepository.findOne(id);
	}
}
