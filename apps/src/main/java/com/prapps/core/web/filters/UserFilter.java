package com.prapps.core.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.prapps.core.service.GenericUserService;
import com.prapps.core.vo.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName="userFilter", urlPatterns={"/*"})
public class UserFilter implements Filter {
	
	private GenericUserService userDetailsService;
	
    /**
     * Default constructor. 
     */
    public UserFilter() {
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
		if(request instanceof HttpServletRequest) {
			if(null == ((HttpServletRequest) request).getSession().getAttribute("user")) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				
				if (!(auth instanceof AnonymousAuthenticationToken) && null != SecurityContextHolder.getContext().getAuthentication()) {
					UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					User user = userDetailsService.getUserByName(userDetails.getUsername());
					httpServletRequest.getSession().setAttribute("user", user);
				}
				/*else {
					User user = new User();
					user.setFirstName("guest");
					httpServletRequest.getSession().setAttribute("user", user);
				}*/
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext servletContext = filterConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		userDetailsService = (GenericUserService) webApplicationContext.getBean(UserDetailsService.class);		
		/*AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "userDetailsService");*/

	}

}
