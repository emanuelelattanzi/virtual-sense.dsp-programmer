package gui;
import java.util.Calendar;
import java.util.TimeZone;


public class MyTime {
	MyHour hour;
	MyDate date;
	
	public MyTime(){
		
	}
	
	public MyTime(MyTime time){
		this.hour = new MyHour(time.getHour());
		this.date = new MyDate(time.getDate());
	}
	
	public MyTime(int year, int month, int day, int hours, int minutes){
		this.date = new MyDate(year, month, day);
		this.hour = new MyHour(hours, minutes);
		
	}
	
	public MyTime(int year, int month, int day, int hours, int minutes, int seconds){
		this.date = new MyDate(year, month, day);
		this.hour = new MyHour(hours, minutes, seconds);
		
	}
	
	public MyTime(MyDate date, MyHour hour){
		this.date = new MyDate(date);
		this.hour = new MyHour(hour);
		
	}
	
	public MyTime(MyDate date){
		this.date = new MyDate(date);
		this.hour = new MyHour(0,0);
	}
	
	public MyTime(MyHour hour){
		this.date = new MyDate(0,0,0);
		this.hour = new MyHour(hour);
		
	}
	
	/**
	 * @return the hour
	 */
	public MyHour getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(MyHour hour) {
		this.hour = hour;
	}

	/**
	 * @return the date
	 */
	public MyDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(MyDate date) {
		this.date = date;
	}
	

	public String toString(){
				
		return (this.date.toString() + " " + this.hour.toStringWithoutSec());
		
	}

//	da sistemare 
	public boolean isGreater(MyTime time){
		boolean b = false;
		if(this.date.isGreater(time.getDate()))
			b = true;
		else
			b = this.date.isEquals(time.getDate()) && this.hour.isGreater(time.getHour());
			
		return b;
	}
	
	public boolean isGreaterOrEquals(MyTime time){
		boolean b = false;
		if(this.date.isGreater(time.getDate()))
			b = true;
		else
			b = this.date.isEquals(time.getDate()) && this.hour.isGreaterOrEquals(time.getHour());
			
		return b;
	}
	
	public boolean isEquals(MyTime time){
		boolean b = false;
		
		b = this.date.isEquals(time.getDate()) && this.hour.isEquals(time.getHour());
			
		return b;
		
	}
		
	public boolean isGreaterZero(){
			
		return (this.date.isGreaterZero() || this.hour.isGreaterZero());
	}
	
	public void incrementTime(MyTime increment){
		
		this.date.incrementDate(increment.getDate());
		this.hour.incrementHour(increment.getHour());
			
	}
	
	public void incrementDate(MyDate increment){
		
		this.date.incrementDate(increment);
			
	}
	
	public void incrementHour(MyHour increment){
		int r = this.hour.incrementHour(increment);
		System.out.println("Resto: "+r);
		this.date.incrementDate(new MyDate(0,0,r));
			
	}
	
	public void decrementDate(MyTime decrement){
		
		this.date.decrementDate(decrement.getDate());
		this.hour.decrementHour(decrement.getHour());
			
	}
	
	public int getDiffDate(MyTime decrement){
		int numberOfDays;
		
//		this.date.decrementDate(decrement.getDate());
//		this.hour.decrementHour(decrement.getHour());
		
		numberOfDays = this.date.getDay() - decrement.getDate().getDay();
		
//				+ this.date.getMonth() * 30 + this.date.getYear() * 365;
		
		return numberOfDays;
			
	}
	
	static public MyTime getCurrentTime(){
		
		
		
		return (new MyTime(MyDate.getCurrentDate(), MyHour.getCurrentHour()));
	}
	
	public long getTotalMinutes(){
		long minutes;
		Calendar c = Calendar.getInstance();
		c.set(this.getDate().getYear(), this.getDate().getMonth()-1, this.getDate().getDay(),
				this.getHour().getHours(), this.getHour().getMinutes(), this.getHour().getSeconds());
		minutes = c.getTimeInMillis()/(1000*60);
		
		return minutes;
	}
}
