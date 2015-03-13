package com.prapps.core.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prapps.core.dao.ConfigDao;
import com.prapps.core.domain.ClientAddrInfo;
import com.prapps.core.domain.Role;
import com.prapps.core.vo.User;


@Service("userDetailsService")
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements GenericUserService {

	private static Logger LOG = Logger.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired 
	private ConfigDao configDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.prapps.core.domain.User user = (com.prapps.core.domain.User) configDao.loadDistinctEntity(com.prapps.core.domain.User.class, new String[] {"userName"}, new String[] {username}, null, true);
		if (user == null)
		      throw new UsernameNotFoundException("user not found");
	    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	    for(Role role:user.getRoles()) {
	        authorities.add(new SimpleGrantedAuthority(role.getName()));
	    }
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(),
	            user.getPassword().toLowerCase(),
	            authorities);
	}
	
	@Override
	public User getUserByName(String username) {
		com.prapps.core.domain.User userDomain = (com.prapps.core.domain.User) configDao.loadDistinctEntity(com.prapps.core.domain.User.class, new String[] {"userName"}, new String[] {username}, null, true);
		User user = new User(userDomain);
		//BeanUtils.copyProperties(userDomain, user);
		LOG.trace("user: "+user);
		return user;
	}
	
	@Override
	public void printRTEContent(String content) {
		System.out.println("content: "+content);		
	}
	
	@Transactional
	@Override
	public void saveClientAddrInfo(ClientAddrInfo clientAddrInfo) {
		configDao.save(clientAddrInfo);
	}

}
