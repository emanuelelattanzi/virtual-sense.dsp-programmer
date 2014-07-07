package gui;
import java.util.Calendar;
import java.util.TimeZone;


public class OldMyTime {
	private int hour, minute;
	
	public OldMyTime(){
		
	}
	
	public OldMyTime(int hour, int minute){
		this.hour = hour;
		this.minute = minute;
	}
	
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	// for generate date and time for file .txt
	public static String getCurrentDateTimeForFile(){
		
		TimeZone t = TimeZone.getDefault();
		Calendar today = Calendar.getInstance(t);

		String s = "";
		String year = "" + today.get(today.YEAR);
		String month = "" + (today.get(today.MONTH)+1);
		String day = "" + today.get(today.DAY_OF_MONTH);
		String second = "" + today.get(today.SECOND);
		String minute = "" + today.get(today.MINUTE);
		String hour = "" + today.get(today.HOUR_OF_DAY);
	
		// secondi, minuti e ore con una sola cifra
		if (second.length() == 1)
			second = "0" + second;
		if (minute.length() == 1)
			minute = "0" + minute;
		if (hour.length() == 1)
			hour = "0" + hour;
	
		// final string
		s = "_" + year + "_" + month + "_" + day +"_"+ hour + "_" + minute + "_" + second;

	return s;
	}
}
