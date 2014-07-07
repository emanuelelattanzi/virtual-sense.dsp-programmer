package gui;

public class Corners {
	int degrees, minutes, seconds;
	
	// builder
	public Corners(){
		
	}
	
	public Corners(int degrees, int minutes, int seconds){
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	// convert decimal corners into degrees DD-to-DMS
	public Corners convertToDegrees(double decimalDegrees){
		int degrees, minutes, seconds;
		double tmp;
		Corners corner;
		degrees = (int) Math.floor(decimalDegrees);
		tmp = 60 * (decimalDegrees - degrees);
		minutes = (int) Math.floor(tmp);
		tmp = 60 * (tmp - minutes);
		seconds = (int) Math.floor(tmp);
		corner = new Corners(degrees, minutes, seconds);
		return corner;
	}
	
	// convert degrees corners into decimal DMS-to-DD
	public double convertToDecimalDegrees(Corners corner){
		double tmp;
		tmp = Math.floor(corner.degrees);
		tmp = tmp + corner.minutes / 60.0;
		tmp += corner.seconds / 3600.0;
		return tmp;
	}
	
	// get String
	public String getString(){
		return (this.degrees+"°"+this.minutes+"'"+this.seconds+"''");
	}

}
