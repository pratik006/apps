package com.prapps.core.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = -6424000687609067729L;
	private long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String appCode;
	private Set<Role> roles;
	private Map<String,String> attributes;
	private String roleStr;
	
	public User() {}
	
	public User(com.prapps.core.domain.User userDomain) {
		userId = userDomain.getUserId();
		userName = userDomain.getUserName();
		firstName = userDomain.getFirstName();
		lastName = userDomain.getLastName();
		appCode = userDomain.getAppCode();
		roles = new HashSet<Role>();
		for(com.prapps.core.domain.Role role : userDomain.getRoles()) {
			roles.add(new Role(role));
			if(null == roleStr) {
				roleStr = role.getName();
			}
			else {
				roleStr = roleStr + ", " +role.getName();
			}
		}
		if(userDomain.getUserAttributes() != null && userDomain.getUserAttributes().size() > 0) {
			attributes = new HashMap<String,String>();
			for(com.prapps.core.domain.UserAttribute userAttribute : userDomain.getUserAttributes()) {
				attributes.put(userAttribute.getAttributeName() ,userAttribute.getAttributeValue());
			}
		}
		
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getRoleStr() {
		return roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public boolean hasRole(String findRole) {
		for(Role role : roles) {
			if(findRole.trim().equalsIgnoreCase(role.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles
				+ ", roleStr=" + roleStr +"]";
	}
}
