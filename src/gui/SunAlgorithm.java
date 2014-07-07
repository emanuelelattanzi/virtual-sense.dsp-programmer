package gui;

public class SunAlgorithm {
	private double longitude, latitude, zenith, timeZoneOffset;
	private int year, month, day;
	
	// builder
	public SunAlgorithm(double longitude, double latitude, double zenith, int year, int month, int day, double timeZoneOffset){
		this.longitude = longitude;
		this.latitude = latitude;
		this.zenith = zenith;
		this.year = year;
		this.month = month;
		this.day = day;
		this.timeZoneOffset = timeZoneOffset;
	}
	
	public SunAlgorithm() {
		
	}

	// calculate sunrise time
	public MyHour getSunRise(){
		double n1, n2, n3, n, lngHour, t, m, l, ra, raQuadrant, lQuadrant, sinDec, cosDec, h, cosH, tm, ut, localTime;
		// calculate the day of the year
		n1 = Math.floor(275 * month / 9);
		n2 = Math.floor((month + 9) / 12);
		n3 = (1 + Math.floor((year - 4 * Math.floor(year / 4) + 2) / 3));
		n = n1 - (n2 * n3) + day - 30;
		// convert the longitude to hour value 
		lngHour = longitude / 15;
		// calculate an approximate time
		t = n + ((6 - lngHour) / 24);
		// calculate the Sun's mean anomaly
		m = (0.9856 * t) - 3.289;
		// calculate the Sun's true longitude
		l = m + (1.916 * Math.sin(Math.toRadians(m))) + (0.020 * Math.sin(2 * Math.toRadians(m))) + 282.634; 
		// l must be into the range [0,360) by adding/subtracting 360
		while(l < 0)
			l = l + 360;
		l = l % 360;
		// calculate the Sun's right ascension		
		ra = Math.atan(0.91764 * Math.tan(Math.toRadians(l)));
		ra = Math.toDegrees(ra);
		// ra must be into the range [0,360) by adding/subtracting 360
		while(ra < 0)
			ra = ra + 360;
		ra = ra % 360;
		// right ascension value needs to be in the same quadrant as L
		lQuadrant  = (Math.floor(l / 90)) * 90;
		raQuadrant = (Math.floor(ra / 90)) * 90;
		ra = ra + (lQuadrant - raQuadrant);
		// right ascension value needs to be converted into hours
		ra = ra / 15;
		// calculate the Sun's declination
		sinDec = 0.39782 * Math.sin(Math.toRadians(l));
		cosDec = Math.cos(Math.asin(Math.toRadians(sinDec)));
		// calculate the Sun's local hour angle
		// if (cosH >  1)  the sun never rises on this location (on the specified date)
		// if (cosH < -1) the sun never sets on this location (on the specified date)
		cosH = (Math.cos(Math.toRadians(zenith)) - (sinDec * Math.sin(Math.toRadians(latitude)))) / (cosDec * Math.cos(Math.toRadians(latitude)));
		// calculate the value of h
		h = 360 - Math.acos(cosH)*180/3.14;
		// convert into hour
		h = h / 15;
		// calculate local mean time of rising/setting
		tm = h + ra - (0.06571 * t) - 6.622;
		// adjust back to UTC
		ut = tm - lngHour;
		// ut must be into the range [0,24) by adding/subtracting 24
		while(ut < 0)
			ut = ut + 24;
		ut = ut % 24;
		//calculate local time
		localTime = (ut + timeZoneOffset) % 24;
		return convertDecHour(localTime);
	}
	
	//calculate sunset time
	public MyHour getSunSet(){
		double n1, n2, n3, n, lngHour, t, m, l, ra, raQuadrant, lQuadrant, sinDec, cosDec, h, cosH, tm, ut, localTime;
		// calculate the day of the year
		n1 = Math.floor(275 * month / 9);
		n2 = Math.floor((month + 9) / 12);
		n3 = (1 + Math.floor((year - 4 * Math.floor(year / 4) + 2) / 3));
		n = n1 - (n2 * n3) + day - 30;
		
		// convert the longitude to hour value 
		lngHour = longitude / 15;
		// calculate an approximate time
		t = n + ((18 - lngHour) / 24);
		// calculate the Sun's mean anomaly
		m = (0.9856 * t) - 3.289;
		// calculate the Sun's true longitude
		l = m + (1.916 * Math.sin(Math.toRadians(m))) + (0.020 * Math.sin(2 * Math.toRadians(m))) + 282.634; 
		// l must be into the range [0,360) by adding/subtracting 360
		while(l < 0)
			l = l + 360;
		l = l % 360;
		// calculate the Sun's right ascension	
		ra = Math.atan(0.91764 * Math.tan(Math.toRadians(l)));
		ra = Math.toDegrees(ra);
		// ra must be into the range [0,360) by adding/subtracting 360
		while(ra < 0)
			ra = ra + 360;
		ra = ra % 360;
		// right ascension value needs to be in the same quadrant as L
		lQuadrant  = (Math.floor(l / 90)) * 90;
		raQuadrant = (Math.floor(ra / 90)) * 90;
		ra = ra + (lQuadrant - raQuadrant);
		// right ascension value needs to be converted into hours
		ra = ra / 15;
		// calculate the Sun's declination
		sinDec = 0.39782 * Math.sin(Math.toRadians(l));
		cosDec = Math.cos(Math.asin(Math.toRadians(sinDec)));
		// calculate the Sun's local hour angle
		// if (cosH >  1)  the sun never rises on this location (on the specified date)
		// if (cosH < -1) the sun never sets on this location (on the specified date)
		cosH = (Math.cos(Math.toRadians(zenith)) - (sinDec * Math.sin(Math.toRadians(latitude)))) / (cosDec * Math.cos(Math.toRadians(latitude)));
		// calculate the value of h
		h = Math.acos(cosH)*180/3.14;
		h = h / 15;
		// calculate local mean time of rising/setting
		tm = h + ra - (0.06571 * t) - 6.622;
		// adjust back to UTC
		ut = tm - lngHour;
		// ut must be into the range [0,24) by adding/subtracting 24
				while(ut < 0)
					ut = ut + 24;
				ut = ut % 24;
		//calculate local time
		localTime = (ut + timeZoneOffset) % 24;
		return convertDecHour(localTime);
	}

	public MyHour convertDecHour(double hourToConvert){
		MyHour time;
		int h, m, s;
		double tmp;
		h = (int) Math.floor(hourToConvert);
		tmp = ((hourToConvert - h) * 60);
		m = (int) Math.floor(tmp);
		tmp = (tmp - m) * 60;
		s = (int) Math.floor(tmp);
		if(s >= 30)
			m++;
		if(m >= 60){
			m = 0;
			h++;
		}
		time = new MyHour(h, m);
		return time;
	}
	
	
}
