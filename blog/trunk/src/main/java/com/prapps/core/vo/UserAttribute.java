package com.prapps.core.vo;

import java.io.Serializable;

public class UserAttribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2095196151953935424L;
	private long attributeId;
	private String attributeName;
	private String attributeValue;
	
	public UserAttribute() {
		// TODO Auto-generated constructor stub
	}
	
	public UserAttribute(com.prapps.core.domain.UserAttribute userAttribute) {
		attributeId = userAttribute.getAttributeId();
		attributeName = userAttribute.getAttributeName();
		attributeValue = userAttribute.getAttributeValue();
	}
	
	public long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public boolean equals(Object object) {
		if(object != null && object instanceof UserAttribute) {
			UserAttribute userAttribute = (UserAttribute) object;
			if(null != userAttribute.getAttributeName()) {
				if(userAttribute.getAttributeName().equals(getAttributeName())) {
					if(userAttribute.getAttributeValue().equals(getAttributeValue())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int hashCode() {
		return attributeName.hashCode();
	}
}
