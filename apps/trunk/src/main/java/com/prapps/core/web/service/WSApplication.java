package com.prapps.core.web.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.prapps"})
@EnableAutoConfiguration
public class WSApplication {

	public static void main(String[] args) {
		SpringApplication.run(WSApplication.class, args);
	}

}
