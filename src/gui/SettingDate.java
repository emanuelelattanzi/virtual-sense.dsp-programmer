package gui;

public class SettingDate{
	// ON = true & OFF = false
	private boolean recState;
	private MyTime recDate;
	private int recMod;

//	public SettingDate(boolean state, int year, int month, int day, int hour, int minute){
//		this.recDate = new MyDate(year, month, day, hour, minute);
//		this.recState = state;
//	}
//	
//	public SettingDate(boolean state, int year, int month, int day, int hour, int minutes, int seconds){
//		this.recDate = new MyDate(year, month, day, hour, minutes, seconds);
//		this.recState = state;
//	}
//	
//	public SettingDate(boolean state, MyDate date){
//		this.recDate = new MyDate(date);
//		this.recState = state;
//	}
	
//	new with rec mode
	public SettingDate(boolean state, int recMode, int year, int month, int day, int hour, int minute){
		this.recDate = new MyTime(year, month, day, hour, minute);
		this.recState = state;
		this.recMod = recMode;
	}
	
	public SettingDate(boolean state, int recMode, int year, int month, int day, int hour, int minutes, int seconds){
		this.recDate = new MyTime(year, month, day, hour, minutes, seconds);
		this.recState = state;
		this.recMod = recMode;
	}
	
	public SettingDate(boolean state, int recMode, MyTime date){
		this.recDate = new MyTime(date);
		this.recState = state;
		this.recMod = recMode;
	}
	
	public String toString(){
		return (recState + " " + recDate.toString());
	}
	
}
