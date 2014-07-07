package gui;
import java.util.Calendar;
import java.util.TimeZone;


public class CalculateSunTime {
	static int recordNumber = 100;
	TimeZone t = TimeZone.getDefault();
	Calendar today;
	// algorithm for calculate sunrise and sunset times 
	private SunAlgorithm s;
	private double longitude, latitude, zenith, timeZoneOffset;
	private SunTime[] sunTime = new SunTime[recordNumber];
	
	// constructor
	public CalculateSunTime(double longitude, double latitude, double zenith, double timeZoneOffset){
		today = Calendar.getInstance(t);
		this.longitude = longitude;
		this.latitude = latitude;
		this.zenith = zenith;
		this.timeZoneOffset = timeZoneOffset;		
	}
	
	// calculate sunrise and sunset times of specificied days
	public SunTime[] calculateSun(){
		for(int i = 0; i < recordNumber; i++){
			
			sunTime[i] = new SunTime(today);
			s = new SunAlgorithm(this.longitude, this.latitude, this.zenith,
					sunTime[i].year, sunTime[i].month, sunTime[i].day, this.timeZoneOffset);
			
			sunTime[i].setRise(s.getSunRise());
			sunTime[i].setSet(s.getSunSet());
			// print all sunrise sunset
			sunTime[i].printAll();
			// increment date
			today.add(Calendar.DAY_OF_MONTH, 1);
		}
	return sunTime;		
	}

	/**
	 * @return the s
	 */
	public SunAlgorithm getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(SunAlgorithm s) {
		this.s = s;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the zenith
	 */
	public double getZenith() {
		return zenith;
	}

	/**
	 * @param zenith the zenith to set
	 */
	public void setZenith(double zenith) {
		this.zenith = zenith;
	}

	/**
	 * @return the timeZoneOffset
	 */
	public double getTimeZoneOffset() {
		return timeZoneOffset;
	}

	/**
	 * @param timeZoneOffset the timeZoneOffset to set
	 */
	public void setTimeZoneOffset(double timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}

	/**
	 * @return the sunTime
	 */
	public SunTime[] getSunTime() {
		return sunTime;
	}

	/**
	 * @param sunTime the sunTime to set
	 */
	public void setSunTime(SunTime[] sunTime) {
		this.sunTime = sunTime;
	}
}
