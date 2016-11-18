package spiderhub.web.controller;

import java.text.ParseException;
import java.util.Date;

public class TimeDateFormat {

	private static String DATE_PART = "yyyy/dd/mm";
	private static String HOUR_PART = "HH:mm a";
	private static java.text.DateFormat FORMAT = new java.text.SimpleDateFormat(DATE_PART + " " + HOUR_PART);
	private static java.text.DateFormat HOUR_FORMAT = new java.text.SimpleDateFormat(HOUR_PART);
	private static java.text.DateFormat DATE_FORMAT = new java.text.SimpleDateFormat(DATE_PART);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "2014/04/05";
		String time = "03:05 am";
		java.util.Date dt = fromStrings(date, time);
		System.out.println(dt);
		System.out.println(DATE_FORMAT.format(dt));
		System.out.println(HOUR_FORMAT.format(dt));

	}

	public static Date fromStrings(String date, String time) {
		StringBuilder sb = new StringBuilder(date);
		sb.append(" ").append(time);
		try {
			return FORMAT.parse(sb.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
