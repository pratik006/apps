package com.prapps.yavni.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

public class YavniUtil {
	
	public static Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("Asia/Calcutta"));

	public static Map<String, String> toMap(HttpServletRequest request) {
		Map<String, String> context = new HashMap<String, String>();
		String key = null;
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			context.put(key, request.getParameter(key));
		}
		return context;
	}

	public static Timestamp getExpiryDate(Timestamp dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DAY_OF_YEAR, 40);
		return new Timestamp(cal.getTimeInMillis());
	}

	

	public static boolean isNotNull(Map<String, String> map, String key) {
		return map.containsKey(key) && (null != map.get(key)) && (!map.get(key).isEmpty());
	}
	
	public static boolean isNotNull(String str) {
		return (null != str) && (!str.isEmpty());
	}
	
	public static boolean isNotNull(Object str) {
		return (null != str);
	}
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(new java.util.Date().getTime());
	}
	
	public static Date getCurrentDate() {
		return cal.getTime();
	}
}
