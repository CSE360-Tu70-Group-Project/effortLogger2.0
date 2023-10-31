/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;

public class editConsoleInputMonitorHelper {
	private int  years, months, days, hrs, min, sec;
	private boolean out;
	final int dateLength = 10, timeLength = 8;
	
	//default constructor
	public editConsoleInputMonitorHelper() {
		years = 0;
		months = 0;
		days = 0;
		hrs = 0;
		min = 0;
		sec = 0;
	}
	//check if input of date yyyy-mm-dd is valid
	public boolean checkInvalidDate(String dateIn) {
		out = true;
		
		if(dateIn.length() != dateLength) {
			return out;
		}
		try {
			years = Integer.parseInt(dateIn.substring(0,4));
			months = Integer.parseInt(dateIn.substring(5,7));
			days = Integer.parseInt(dateIn.substring(8,10));
			if(months > 0 && months <= 12 && days > 0 && days <= 31) { //check if days/months are valid
				out = false;
			}
		} catch (Exception e) {
			return out;
		}
		
		return out;
	}
	//check if input of start time hh:mm:ss is valid
	public boolean checkInvalidStart(String startIn) {
		out = true;
		if(startIn.length() != timeLength) {
			return out;
		}
		try {
			hrs = Integer.parseInt(startIn.substring(0,2));
			min = Integer.parseInt(startIn.substring(3,5));
			sec = Integer.parseInt(startIn.substring(6,8));
			if(hrs > 0 && hrs < 24 && sec > 0 && sec < 60 && min > 0 && min < 60) { //check if time is valid
				out = false;
			}
		} catch (Exception e) {
			return out;
		}
		
		return out;
	}
	//check if input of end time hh:mm:ss is valid
	public boolean checkInvalidEnd(String endIn) {
		out = true;
		if(endIn.length() != timeLength) {
			return out;
		}
		try {
			hrs = Integer.parseInt(endIn.substring(0,2));
			min = Integer.parseInt(endIn.substring(3,5));
			sec = Integer.parseInt(endIn.substring(6,8));
			if(hrs > 0 && hrs < 24 && sec > 0 && sec < 60 && min > 0 && min < 60) { //check if time is valid
				out = false;
			}
		} catch (Exception e) {
			return out;
		}
		
		return out;
	}
	
}
