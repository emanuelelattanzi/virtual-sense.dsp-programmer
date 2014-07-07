package record;


import gui.FckMenu;
import gui.Impedance;
import gui.PanelLogRec;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;



public class RecordSession {
	// Modes
	public static final int ALWAYSON = 0;
	public static final int PERIODICAL = 1;
	
	private int mode;
	private GregorianCalendar startSes;
	private GregorianCalendar stopSes;
	private ArrayList<Record> records;
	
	private int pausePeriod;
	private int RecPeriod;
	
	private int fileLength;
	private int fs;
	private int gain;
	private int impedance;
	
	private PanelLogRec logRec;
	
	public RecordSession(int mode, GregorianCalendar start, GregorianCalendar stop,
						 int fileLength, int fs, int gain, int impedance) {
		this.mode = mode;
		
		this.startSes = start;
		this.stopSes = stop;
		this.fileLength = fileLength;
		this.fs = fs;
		this.gain = gain;
		this.impedance = impedance;
		
		this.records = new ArrayList<Record>();
		this.fillAlwaysOn();
		
		this.pausePeriod = 0;
		this.RecPeriod = 0;
		
		this.logRec = new PanelLogRec(this.toString());
	}
	
	public RecordSession(int mode, GregorianCalendar start, GregorianCalendar stop,
			 int fileLength, int fs, int gain, int impedance, int recPeriod, int pausePeriod) {
		this.mode = mode;
		
		this.startSes = start;
		this.stopSes = stop;
		this.fileLength = fileLength;
		this.fs = fs;
		this.gain = gain;
		this.impedance = impedance;
		
		this.pausePeriod = pausePeriod;
		this.RecPeriod = recPeriod;
		
		this.records = new ArrayList<Record>();
		this.fillPeriodical(recPeriod, pausePeriod);
		
		this.logRec = new PanelLogRec(this.toString());
	}

	
	public GregorianCalendar getStart() {
		return this.startSes;
	}
	
	public GregorianCalendar getStop() {
		return this.stopSes;
	}
	
	public int getMode(){
		return this.mode;
	}
	
	public int getFs(){
		return this.fs;
	}
	
	public int getImpedance(){
		return this.impedance;
	}
	
	public int getGain(){
		return this.gain;
	}
	
	public int getFileLength() {
		return this.fileLength;
	}
	
	public String toString() {
		return "mode: " + this.mode + ", " 
			   + "start: " + this.startSes.get(Calendar.YEAR) 	+ "-"
			   + this.startSes.get(Calendar.MONTH) 				+ "-"
			   + this.startSes.get(Calendar.DAY_OF_MONTH) 		+ " "
			   + this.startSes.get(Calendar.HOUR_OF_DAY) 		+ ":"
			   + this.startSes.get(Calendar.MINUTE) 			+ ":"
			   + this.startSes.get(Calendar.SECOND) 			+ ", " 
			   + "stop: " + this.stopSes.get(Calendar.YEAR) 	+ "-"
		  	   + this.stopSes.get(Calendar.MONTH) 				+ "-"
			   + this.stopSes.get(Calendar.DAY_OF_MONTH) 		+ " "
		   	   + this.stopSes.get(Calendar.HOUR_OF_DAY) 		+ ":"
		  	   + this.stopSes.get(Calendar.MINUTE) 				+ ":"
		   	   + this.stopSes.get(Calendar.SECOND)				+ ", "
		   	   + "len: " + this.fileLength						+ ", "
		   	   + "fs: " + FckMenu.values[this.fs]				+ ", "
		   	   + "gain: " + this.gain							+ ", "
		   	   + "imp: " + Impedance.values[this.impedance];
	}
	
	public String[] toStrings() {
		String[] ret = new String[this.records.size()];
		
		for(int i=0; i<this.records.size(); i++) {
			ret[i] = mode 							+ " " +
					 this.records.get(i).toString()	+ " " +
					 this.fileLength 				+ " " +
					 this.fs						+ " " +
					 this.gain						+ " " +
					 this.impedance;
		}
		
		return ret;
	}
	
	public String[] toHexStrings(){
		String[] ret = new String[this.records.size()];
		
		for(int i=0; i<this.records.size(); i++) {
			ret[i]="";
			ret[i]+=String.format("%02X ",this.mode+1).toUpperCase();							// Mode
			ret[i]+=this.records.get(i).toHexString();											// Record
			ret[i]+=Record.swapBytes(String.format("%04X ", this.fileLength).toUpperCase());	// File length (sec)
			ret[i]+=String.format("%02X ", this.fs+1).toUpperCase();							// Fs
			ret[i]+=String.format("%02X ", this.gain).toUpperCase();							// Gain
			ret[i]+=String.format("%02X ", this.impedance+1).toUpperCase();						// Impedance
		}
		
		return ret;
	}
	
	public PanelLogRec getLogRec() {
		return this.logRec;
	}
	
	private void fillPeriodical(int recPeriod, int pausePeriod) {
		GregorianCalendar increment = (GregorianCalendar)this.startSes.clone();
			
		do {
			this.records.add(new RecPeriodical((GregorianCalendar)increment.clone(), recPeriod));
			
			System.out.print("------ ");
			System.out.print(increment.get(Calendar.YEAR) + "-"
					   	   + increment.get(Calendar.MONTH) + "-"
					   	   + increment.get(Calendar.DAY_OF_MONTH) + " "
					   	   + increment.get(Calendar.HOUR_OF_DAY) + ":"
					   	   + increment.get(Calendar.MINUTE) + ":"
					   	   + increment.get(Calendar.SECOND));
			System.out.println(" (" + recPeriod + ")");
			
			increment.add(Calendar.SECOND, recPeriod + pausePeriod);
			
		}while(increment.before(this.stopSes));
	}
	
	private void fillAlwaysOn() {
	
			this.records.add(new RecAlwaysOn((GregorianCalendar)this.startSes.clone(), (GregorianCalendar)this.stopSes.clone()));
			
			System.out.print("------ ");
			System.out.print(this.startSes.get(Calendar.YEAR) + "-"
					   	   + this.startSes.get(Calendar.MONTH) + "-"
					   	   + this.startSes.get(Calendar.DAY_OF_MONTH) + " "
					   	   + this.startSes.get(Calendar.HOUR_OF_DAY) + ":"
					   	   + this.startSes.get(Calendar.MINUTE) + ":"
					   	   + this.startSes.get(Calendar.SECOND));
			
			System.out.println(" " + this.stopSes.get(Calendar.YEAR) + "-"
				   	   + this.stopSes.get(Calendar.MONTH) + "-"
				   	   + this.stopSes.get(Calendar.DAY_OF_MONTH) + " "
				   	   + this.stopSes.get(Calendar.HOUR_OF_DAY) + ":"
				   	   + this.stopSes.get(Calendar.MINUTE) + ":"
				   	   + this.stopSes.get(Calendar.SECOND));
	}
	
}
