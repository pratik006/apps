package com.prapps.core.vo;

import java.io.Serializable;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5127905511221471032L;
	private Integer id;
	private String name;
	
	public Role() {}
	public Role(com.prapps.core.domain.Role roleDomain) {
		id = roleDomain.getId();
		name = roleDomain.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
