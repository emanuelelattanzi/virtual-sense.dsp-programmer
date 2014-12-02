package record;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RecAlwaysOn extends Record{
	private GregorianCalendar startRec;
	private GregorianCalendar stopRec;

	
	public RecAlwaysOn(GregorianCalendar startRec, GregorianCalendar stopRec) {
		this.startRec = startRec;
		this.stopRec = stopRec;
	}
		
	public GregorianCalendar getStart() {
		return this.startRec;
	}
	
	public GregorianCalendar getStop() {
		return this.stopRec;
	}
	
	public String toString() {
		return this.startRec.get(Calendar.YEAR) 		+ "-" +
			   (this.startRec.get(Calendar.MONTH)+1) 	+ "-" +
			   this.startRec.get(Calendar.DAY_OF_MONTH) + " " +
			   this.startRec.get(Calendar.HOUR_OF_DAY) 	+ ":" +
			   this.startRec.get(Calendar.MINUTE) 		+ ":" +
			   this.startRec.get(Calendar.SECOND)		+ " " +
			   this.stopRec.get(Calendar.YEAR) 			+ "-" +
			   (this.stopRec.get(Calendar.MONTH)+1) 	+ "-" +
			   this.stopRec.get(Calendar.DAY_OF_MONTH) 	+ " " +
			   this.stopRec.get(Calendar.HOUR_OF_DAY) 	+ ":" +
			   this.stopRec.get(Calendar.MINUTE) 		+ ":" +
			   this.stopRec.get(Calendar.SECOND);
	}
	
	public String toHexString() {
		String ret = "";
		
		ret+=Record.swapBytes(String.format("%04X ", this.startRec.get(Calendar.DAY_OF_MONTH)).toUpperCase());        
		ret+=Record.swapBytes(String.format("%04X ", (this.startRec.get(Calendar.MONTH)+1)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.startRec.get(Calendar.YEAR)-2000).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.startRec.get(Calendar.HOUR_OF_DAY)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.startRec.get(Calendar.MINUTE)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.startRec.get(Calendar.SECOND)).toUpperCase());

		ret+=Record.swapBytes(String.format("%04X ", this.stopRec.get(Calendar.DAY_OF_MONTH)).toUpperCase());        
		ret+=Record.swapBytes(String.format("%04X ", (this.stopRec.get(Calendar.MONTH)+1)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.stopRec.get(Calendar.YEAR)-2000).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.stopRec.get(Calendar.HOUR_OF_DAY)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.stopRec.get(Calendar.MINUTE)).toUpperCase());
		ret+=Record.swapBytes(String.format("%04X ", this.stopRec.get(Calendar.SECOND)).toUpperCase());
		
		return ret;
	}
}

