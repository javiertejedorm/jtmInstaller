package com.jtmproject.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class gets and compare dates
 * @author Javier Tejedor
 * @thanks http://www.mkyong.com/java/how-to-compare-dates-in-java/
 */
public class DatesUtils {

	/**
	 * returns a string with today
	 * @return
	 */
	public String getToday(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * this method returns true if the difference between the date passed by parameters is equals or higher than the parameter "daysGone"
	 * @param date
	 * @param days
	 * @return
	 */
	public boolean temporalFolderMustBeCleaned(String date, long days){
		boolean ret = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dateBefore = sdf.parse(date);
			Date today = sdf.parse(getToday());
			
			long d = getDateDiff(dateBefore, today);
			System.out.println(d);
			if(d >= days){
				ret = true;
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * returns the difference in hours between two dates
	 * @param dateBefore
	 * @param dateAfter
	 * @return
	 */
	private long getDateDiff(Date dateBefore, Date dateAfter) {
	    long diffInMillies = dateBefore.getTime() - dateAfter.getTime();
	    //it gets total hours and divides for getting the days.
	    long days  = ((diffInMillies / (1000*60*60)) / 24);
	    return days;
	}
}
