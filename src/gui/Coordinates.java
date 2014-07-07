package gui;
import it.elbuild.jcoord.LatLng;
import it.elbuild.jcoord.resolver.GeoCodeResolver;


public class Coordinates {
	private int degrees, minutes, seconds;
	/**
	 * @return the degrees
	 */
	public int getDegrees() {
		return degrees;
	}

	/**
	 * @param degrees the degrees to set
	 */
	public void setDegrees(int degrees) {
		this.degrees = degrees;
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

	/**
	 * @return the latitudeDD
	 */
	public double getLatitudeDD() {
		return latitudeDD;
	}

	/**
	 * @param latitudeDD the latitudeDD to set
	 */
	public void setLatitudeDD(double latitudeDD) {
		this.latitudeDD = latitudeDD;
	}

	/**
	 * @return the longitudeDD
	 */
	public double getLongitudeDD() {
		return longitudeDD;
	}

	/**
	 * @param longitudeDD the longitudeDD to set
	 */
	public void setLongitudeDD(double longitudeDD) {
		this.longitudeDD = longitudeDD;
	}

	private double latitudeDD, longitudeDD;
	
	// builder
	public Coordinates(){
		
	}
	
	public Coordinates(double latitudeDD, double longitudeDD){
		this.latitudeDD = latitudeDD;
		this.longitudeDD = longitudeDD;
	}
	
	public Coordinates(int degrees, int minutes, int seconds){
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
	
	// parse value
	public boolean parseCoordinates(){
		boolean b = false;
		if ( this.latitudeDD <= 90.0 && this.latitudeDD >= -90.0
				&& this.longitudeDD <= 180.0 && this.latitudeDD >= -180.0 )
			b = true;
		return b;
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
	
	public void printCoordinate(){
		System.out.println("latitude: " + this.latitudeDD + "longitude: " + this.longitudeDD);
	}
	
	static public Coordinates getCityCoordinates (String city){
		
		LatLng coord = GeoCodeResolver.findCoordForAddress(city);
		
		return(new Coordinates(coord.getLat().doubleValue(),coord.getLng().doubleValue()));
	}

}
