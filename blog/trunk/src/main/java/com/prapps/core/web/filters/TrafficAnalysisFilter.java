package com.prapps.core.web.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.prapps.core.domain.ClientAddrInfo;
import com.prapps.core.service.GenericUserService;

/**
 * Servlet Filter implementation class TrafficAnalysisFilter
 */
@WebFilter("/*")
public class TrafficAnalysisFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(TrafficAnalysisFilter.class);
	
	private GenericUserService userDetailsService;
    /**
     * Default constructor. 
     */
    public TrafficAnalysisFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int clientipHash = request.getRemoteHost().hashCode();
		Date curDate = new Date();
		LOG.debug("clientipHash: "+clientipHash+"\tCur Date: "+curDate);
		ClientAddrInfo info = new ClientAddrInfo(clientipHash, curDate.getTime());
		userDetailsService.saveClientAddrInfo(info);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext servletContext = filterConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		userDetailsService = (GenericUserService) webApplicationContext.getBean(UserDetailsService.class);	
	}

}
