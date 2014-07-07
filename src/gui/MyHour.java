package gui;
import java.util.Calendar;
import java.util.TimeZone;


public class MyHour {
	private int hours, minutes, seconds;
	
	public MyHour(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public MyHour(int hours, int minutes){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = 0;
	}
	
	public MyHour(MyHour myH){
		this.hours = myH.hours;
		this.minutes = myH.minutes;
		this.seconds = myH.seconds;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public String toString(){
		String h, m, s, string;
		
		s = this.seconds + "";
		m = this.minutes + "";
		h = this.hours + "";
		
		if (m.length() == 1)
			m = "0" + m;
		if (h.length() == 1)
			h = "0" + h;
		if (s.length() == 1)
			s = "0" + s;
		
			string = h + ":" + m + ":" + s;
		
		return (string);
		
	}
	
	public String toStringWithoutSec(){
		String h, m, string;
		
		m = this.minutes + "";
		h = this.hours + "";
		
		if (m.length() == 1)
			m = "0" + m;
		if (h.length() == 1)
			h = "0" + h;
		
			string = h + ":" + m;
		
		return (string);
		
	}

	
	public boolean isGreater(MyHour hour){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.hours, this.minutes, this.seconds);
		c2.set(hour.hours, hour.minutes, hour.seconds);
		
		b = c1.after(c2);
			
		return b;
	}
	
	public boolean isGreaterZero(){
		boolean b = false;
		
		if( this.hours > 0 || this.minutes > 0 || this.seconds > 0 )
			b = true;
				
		return b;
	}

	public boolean isGreaterOrEquals(MyHour hour){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.hours, this.minutes, this.seconds);
		c2.set(hour.hours, hour.minutes, hour.seconds);
		
		b = c1.after(c2) || c1.equals(c2);
			
		return b;
	}
	
	public boolean isEquals(MyHour hour){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.hours, this.minutes, this.seconds);
		c2.set(hour.hours, hour.minutes, hour.seconds);
		
		b = c1.equals(c2);
			
		return b;
	}
	
	public int incrementHour(MyHour increment){
		Calendar c = Calendar.getInstance();
		c.set(0,1,1,this.hours, this.minutes, this.seconds);
		
		c.add(Calendar.HOUR_OF_DAY, increment.hours);
		c.add(Calendar.MINUTE, increment.minutes);
		c.add(Calendar.SECOND, increment.seconds);
		
		this.hours = c.get(c.HOUR_OF_DAY);
		this.minutes = c.get(c.MINUTE);
		this.seconds = c.get(c.SECOND);
		
		return(c.get(c.DAY_OF_MONTH)-1);
			
	}
	
	public int decrementHour(MyHour decrement){
		Calendar c = Calendar.getInstance();
		c.set(0,1,2,this.hours, this.minutes, this.seconds);
		
		c.add(Calendar.HOUR_OF_DAY, -(decrement.hours));
		c.add(Calendar.MINUTE, (-decrement.minutes));
		c.add(Calendar.SECOND, (-decrement.seconds));
		
		this.hours = c.get(c.HOUR_OF_DAY);
		this.minutes = c.get(c.MINUTE);
		this.seconds = c.get(c.SECOND);
		
		return (((c.get(c.DAY_OF_MONTH)-1 == 1) ? -1 : 0));
			
	}
	
	static public MyHour getCurrentHour(){
		
		TimeZone t = TimeZone.getDefault();
		Calendar today = Calendar.getInstance(t);
			
		return (new MyHour(today.get(today.HOUR_OF_DAY), today.get(today.MINUTE)));
	}
}
