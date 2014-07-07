package gui;

public class LogRecSet {
	private int mode;
	private MyDate startDate, stopDate;
	private MyHour recTime, stopTime;
	private String stringRecTime, stringStopTime;
	private PanelLogRec panelLogRec;
	private long id;
	

	public LogRecSet(int mod, MyDate startDat, MyDate stopDat, String stringRec,
			MyHour recTim, String stringStop, MyHour stopTim, long id){
		this.mode = mod;
		this.startDate = startDat;
		this.stopDate = stopDat;
		this.recTime = recTim;
		this.stopTime = stopTim;
		this.stringRecTime = stringRec;
		this.stringStopTime = stringStop;
		this.id = id;
		this.panelLogRec = new PanelLogRec(this.toString());
	}
	
	public String toString(){
		return("RecMode: " + this.mode +" "+ this.startDate +" "+
	this.stopDate +" "+ this.stringRecTime+" "+ this.recTime +" "+
				this.stringStopTime+" "+this.stopTime+" id: "+this.id );
	}

	/**
	 * @return the panelLogRec
	 */
	public PanelLogRec getPanelLogRec() {
		return panelLogRec;
	}

	/**
	 * @param panelLogRec the panelLogRec to set
	 */
	public void setPanelLogRec(PanelLogRec panelLogRec) {
		this.panelLogRec = panelLogRec;
	}

	/**
	 * @return the mode
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}

	/**
	 * @return the startDate
	 */
	public MyDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(MyDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the stopDate
	 */
	public MyDate getStopDate() {
		return stopDate;
	}

	/**
	 * @param stopDate the stopDate to set
	 */
	public void setStopDate(MyDate stopDate) {
		this.stopDate = stopDate;
	}

	/**
	 * @return the recTime
	 */
	public MyHour getRecTime() {
		return recTime;
	}

	/**
	 * @param recTime the recTime to set
	 */
	public void setRecTime(MyHour recTime) {
		this.recTime = recTime;
	}

	/**
	 * @return the stopTime
	 */
	public MyHour getStopTime() {
		return stopTime;
	}

	/**
	 * @param stopTime the stopTime to set
	 */
	public void setStopTime(MyHour stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return the stringRecTime
	 */
	public String getStringRecTime() {
		return stringRecTime;
	}

	/**
	 * @param stringRecTime the stringRecTime to set
	 */
	public void setStringRecTime(String stringRecTime) {
		this.stringRecTime = stringRecTime;
	}

	/**
	 * @return the stringStopTime
	 */
	public String getStringStopTime() {
		return stringStopTime;
	}

	/**
	 * @param stringStopTime the stringStopTime to set
	 */
	public void setStringStopTime(String stringStopTime) {
		this.stringStopTime = stringStopTime;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	public String stringForFile(){
		return (this.mode + "\t" +
		this.startDate + "\t" +
		this.stopDate + "\t" +
		this.recTime + "\t" +
		this.stopTime + "\t" +
		this.stringRecTime + "\t" +
		this.stringStopTime + "\t" +
		this.id);
	}
	

}


