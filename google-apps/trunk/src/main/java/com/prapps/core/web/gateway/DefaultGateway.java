package com.prapps.core.web.gateway;

import org.springframework.integration.annotation.Header;

import com.prapps.core.vo.AppRequest;

public interface DefaultGateway {
	
	/*@Gateway(requestChannel="inRequest")*/
	public Object send(AppRequest appRequest, @Header("appCode") String appCode, @Header("path") String path, @Header("subpath") String subpath, @Header("action") String action);
	public Object send(AppRequest appRequest, @Header("appCode") String appCode, @Header("path") String path, @Header("action") String action);
}
