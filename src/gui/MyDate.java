package gui;
import java.util.Calendar;
import java.util.TimeZone;


public class MyDate {
	private int year;
	private int month;
	private int day;
	
	
	public MyDate(){
		
	}
	
	public MyDate(MyDate date){
		this.year = date.year;
		this.month = date.month;
		this.day = date.day;
		
	}
	
	public MyDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
				
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public int getDay(){
		return this.day;
	}

	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	
	public String toString(){
		
		return (this.year + "-" +  this.month + "-" + this.day);
		
	}
	
	public boolean isGreater(MyDate date){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.year, this.month, this.day);
		c2.set(date.year, date.month, date.day);
		
		b = c1.after(c2);
			
		return b;
	}
	
	public boolean isGreaterOrEquals(MyDate date){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.year, this.month, this.day);
		c2.set(date.year, date.month, date.day);
		
		b = c1.after(c2) || c1.equals(c2);
			
		return b;
	}
	
	public boolean isEquals(MyDate date){
		boolean b = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(this.year, this.month, this.day);
		c2.set(date.year, date.month, date.day);
		
		b = c1.equals(c2);
			
		return b;
	}
	
//	static public boolean isGreater(int year, int month, int day){
//		boolean b = false;
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = Calendar.getInstance();
//		
//		c1.set(this.year, this.month, this.day);
//		c2.set(year, month, day);
//		
//		b = c1.after(c2);
//			
//		return b;
//	}
	
	public boolean isGreaterZero(){
		boolean b = false;
		
		if(this.year > 0 || this.month > 0 || this.day > 0)
			b = true;
				
		return b;
	}
	
	public void incrementDate(MyDate increment){
		Calendar c = Calendar.getInstance();
		c.set(this.year, this.month-1, this.day);
		
		//x testing
		/*
		System.out.println(" "+ c.get(c.YEAR) +"/"+ (c.get(c.MONTH)+1) +"/"+ c.get(c.DAY_OF_MONTH) 
				+" "+ c.get(c.HOUR_OF_DAY) +":"+ c.get(c.MINUTE) +":"+  c.get(c.SECOND));
		*/
		
		c.add(Calendar.DAY_OF_MONTH, increment.day);
		c.add(Calendar.MONTH, increment.month);
		c.add(Calendar.YEAR, increment.year);
		
		this.year = c.get(c.YEAR);
		this.month = c.get(c.MONTH)+1;
		this.day = c.get(c.DAY_OF_MONTH);
			
	}
	
	public void decrementDate(MyDate decrement){
		Calendar c = Calendar.getInstance();
		c.set(this.year, this.month-1, this.day);
		
		//x testing
		/*
		System.out.println(" "+ c.get(c.YEAR) +"/"+ (c.get(c.MONTH)+1) +"/"+ c.get(c.DAY_OF_MONTH) 
				+" "+ c.get(c.HOUR_OF_DAY) +":"+ c.get(c.MINUTE) +":"+  c.get(c.SECOND));
		*/
		
		c.add(Calendar.DAY_OF_MONTH, -decrement.day);
		c.add(Calendar.MONTH, -decrement.month);
		c.add(Calendar.YEAR, -decrement.year);
		
		this.year = c.get(c.YEAR);
		this.month = c.get(c.MONTH)+1;
		this.day = c.get(c.DAY_OF_MONTH);
					
	}
	
	static public MyDate getCurrentDate(){
		
		TimeZone t = TimeZone.getDefault();
		Calendar today = Calendar.getInstance(t);
		
		return (new MyDate(today.get(today.YEAR), (today.get(today.MONTH)+1), today.get(today.DAY_OF_MONTH)));
	}
	

}
