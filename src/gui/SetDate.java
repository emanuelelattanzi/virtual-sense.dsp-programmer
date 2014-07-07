package gui;

public class SetDate {
	int recMode;
	MyDate startDay, stopDay;
	MyHour startRec, stopRec;
	
	SetDate(int recMod, MyDate startDay, MyDate stopDay, MyHour startRec, MyHour stopRec){
		this.recMode = recMod;
		this.startDay = startDay;
		this.stopDay = stopDay;
		this.startRec = startRec;
		this.stopRec = stopRec;
	}
	
	public String toString(){
		
		return(this.recMode + " " + this.startDay + " " + this.stopDay + " " + this.startRec 
				+ " " + this.stopRec);
		
	}
}
