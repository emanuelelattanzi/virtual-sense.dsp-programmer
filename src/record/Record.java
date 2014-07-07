package record;

import java.util.GregorianCalendar;

public abstract class Record {
	public abstract GregorianCalendar getStart();
	
	public abstract GregorianCalendar getStop();
	
	public abstract String toString();
	
	public abstract String toHexString();
	
	public static String swapBytes(String in) {
        String ret = "";
        ret = ""+in.charAt(2) + in.charAt(3) + in.charAt(0) + in.charAt(1)+in.charAt(4);
        return ret; 
    }
}
