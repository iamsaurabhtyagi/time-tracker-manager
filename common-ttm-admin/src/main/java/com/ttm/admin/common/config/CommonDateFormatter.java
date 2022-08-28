package com.ttm.admin.common.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommonDateFormatter {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static SimpleDateFormat dateTimeZoneFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss'Z'");
	
	
	public static String dateFormatterToString(Date date) {
		return dateFormat.format(date);
	}
	
	public static String dateTimeFormatterToString(Date date) {
		return dateTimeFormat.format(date);
	}
	
	public static String dateTimeZoneFormatterToString(Date date) {
		dateTimeZoneFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return dateTimeZoneFormat.format(date);
	}

}
