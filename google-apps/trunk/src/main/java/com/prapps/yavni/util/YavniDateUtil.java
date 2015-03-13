package com.prapps.yavni.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class YavniDateUtil extends YavniUtil {
	
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mmaa");
	public static SimpleDateFormat jsDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);

	public static java.sql.Date toDate(String strDate) {
		java.sql.Date dt = null;
		if (isNotNull(strDate)) {
			try {
				dt = new java.sql.Date(df.parse(strDate).getTime());
			} catch (Exception e) {
				try {
					jsDateFormat.parse(strDate);
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return dt;
	}
	
	public static Timestamp toDateTime(String strDate) {
		Timestamp timestamp = null;
		if (isNotNull(strDate)) {
			try {
				timestamp = new Timestamp(df.parse(strDate).getTime());
			} catch (Exception e) {
				try {
					jsDateFormat.parse(strDate);
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return timestamp;
	}
	
	public static Timestamp toTimestamp(java.util.Date date) {
		return new Timestamp(date.getTime());
	}
	
	public static String dateToString(Timestamp timestamp) {
		if(null != timestamp) {
			return dateToString(timestamp.getTime());
		}
		return "";
	}
	
	public static String dateToString(java.sql.Date date) {
		if(null != date) {
			return dateToString(date.getTime());
		}
		return "";
	}
	
	public static String dateToString(long time) {
		return df.format(new java.util.Date(time));
	}
	
	public static Date addDay(Date dt) {
		Calendar cal =  Calendar.getInstance();
		cal.setTimeInMillis(dt.getTime());
		cal.add(Calendar.DATE, 1);
		return new Date(cal.getTimeInMillis());
	}
}
