package com.prapps.core.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/*@Configuration*/
public class WebConfig extends WebMvcConfigurationSupport {

	@Bean
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
		System.out.println(handlerMapping +"\torder"+handlerMapping.getOrder());
		handlerMapping.setOrder(10);
		return handlerMapping;
	}
}
