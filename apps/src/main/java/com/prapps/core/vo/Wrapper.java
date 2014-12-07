package com.prapps.core.vo;

import java.util.ArrayList;
import java.util.Collection;

public class Wrapper {

	private boolean success;
	private String msg;
	private int iTotalRecords;
	private int iTotalDisplayRecords;
	private int sEcho;
	
	public Wrapper() {
		
	}
	
	public Wrapper(boolean success) {
		this.success = success;
	}
	
	public Wrapper(String errorMsg) {
		this.msg = errorMsg;
	}
	
	public Wrapper(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public Wrapper(Collection list) {
		this.aaData = list;
		this.iTotalRecords = list.size();
		this.iTotalDisplayRecords = list.size();
	}
	
	public Wrapper(Collection list, int sEcho) {
		this.aaData = list;
		this.iTotalRecords = list.size();
		this.iTotalDisplayRecords = list.size();
		this.sEcho = sEcho;
	}
	
	private Collection aaData;

	public Collection getAaData() {
		if(null == aaData) {
			aaData = new ArrayList();
		}
		return aaData;
	}

	public void setAaData(Collection aaData) {
		this.aaData = aaData;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String errorMsg) {
		this.msg = errorMsg;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	
}
