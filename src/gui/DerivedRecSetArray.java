package gui;
import java.util.ArrayList;
import java.lang.Byte;


public class DerivedRecSetArray {
	private ArrayList<DerivedRecSet> recArray = new ArrayList<DerivedRecSet>();
	private SunTime[] sunTime;
	private int indexStart, indexStop;
	
	
	public DerivedRecSetArray(){
	}
	
	public boolean addDerivedRec(DerivedRecSet derivedRec){
		boolean b = false;
//		prima di inserire controllare gli altri elementi della lista
//		e inserire in modo ordinato
//		aggiungere opportuna funzione
		
//		empty list
		if(recArray.size() == 0 ){
			b = recArray.add(derivedRec);
		}
			

//		not empty list
		else{
//			first element
			if(recArray.get(0).getStart().isGreater(derivedRec.getStop()) && !b){
				recArray.add(0, derivedRec);
				b = true;
			}
//			last element
			else if(derivedRec.getStart().isGreater(recArray.get(recArray.size()-1).getStop()) && !b){
				recArray.add(derivedRec);
				b = true;
			}
//			<element<
			else if(!b){
			for(int index = 0; 
					index < recArray.size() && !b; 
					index++){
				if(derivedRec.getStart().isGreater(recArray.get(index).getStop()) 
						&& recArray.get(index+1) != null 
						&& recArray.get(index+1).getStart().isGreater(derivedRec.getStop())){
					recArray.add(index+1, derivedRec);
					b = true;
					}
			}
			}
			
		}
		return b;
	}
	
	
	
	public boolean addRec(LogRecSet logRec){
		boolean b = false;

		b = manageAddRec(logRec);
		
		return b;
	}

	public boolean manageAddRec(LogRecSet logRec){
		boolean b = false;
		
//		oppure logRec.getMode() == 5
		if(logRec.getStringRecTime() == "REC" && logRec.getStringStopTime() == "PAUSE"){
			MyTime startTime, endTime;
			for(MyTime time = new MyTime(logRec.getStartDate()); 
					!time.getDate().isGreater(logRec.getStopDate()); 
					time.incrementHour(logRec.getStopTime())){
				MyTime dat = new MyTime(time);
				System.out.println("Data: "+time.toString());
				startTime = new MyTime(dat);
				time.incrementHour(logRec.getRecTime());
				dat = new MyTime(time);
				endTime = new MyTime(dat);
				b = addDerivedRec(new DerivedRecSet(logRec.getId(), startTime, endTime));
			}
			
		}
		
		
	if(logRec.getMode() == 3){	
		this.indexStart = findMatchingIndex(logRec.getStartDate(), sunTime);
		this.indexStop = findMatchingIndex(logRec.getStopDate(), sunTime);
		
		for(MyDate date = new MyDate(logRec.getStartDate()); 
				!date.isGreater(logRec.getStopDate()); 
				date.incrementDate(new MyDate(0,0,1))){
			
			MyDate dat = new MyDate(date);
			MyHour startHour, stopHour;
			MyTime startTime, endTime;
			startHour = new MyHour(getStartHour(logRec));
			System.out.println("starthour: " + startHour);
			startTime = new MyTime(dat, startHour);
			stopHour = new MyHour(getStopHour(logRec));
			endTime = new MyTime(dat,stopHour);	
			
			System.out.println("Valori " + startHour +" "+ stopHour);
			
			if(endTime.isGreater(startTime))
				b = addDerivedRec(new DerivedRecSet(logRec.getId(), startTime, endTime));
			else {
				b = false;
				System.out.println("Eseguo ramo else" + startTime +" "+ endTime);
			}
		}
	}	

	return b;
	}
	
	public void printAll(){
		for(int i = 0; i < recArray.size(); i++)
		System.out.println("Contenuto lista ordinata: " + recArray.get(i).toString());
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
	
	public MyHour getStartHour(LogRecSet logRec){
		MyHour hour = new MyHour(0,0);
		System.out.println("Valori " + logRec.getStringRecTime()+ " "+logRec.getRecTime());
		if(logRec.getStringRecTime().equals("MANUAL")){
			System.out.println("Passo qui!");
			hour = new MyHour(logRec.getRecTime());
			System.out.println("Ora " + hour);
		}
		if(logRec.getStringRecTime().contains("SUNRISE")){
			hour = new MyHour(sunTime[this.indexStart].hourRise, sunTime[this.indexStart].minuteRise);
			if(logRec.getStringRecTime().contains("-"))
				hour.decrementHour(logRec.getRecTime());
			else
				hour.incrementHour(logRec.getRecTime());
			this.indexStart++;
		}
		if(logRec.getStringRecTime().contains("SUNSET")){
			hour = new MyHour(sunTime[this.indexStart].hourSet, sunTime[this.indexStart].minuteSet);
			if(logRec.getStringRecTime().contains("-"))
				hour.decrementHour(logRec.getRecTime());
			else
				hour.incrementHour(logRec.getRecTime());
			this.indexStart++;
		}
		return hour;
	}
	
	public MyHour getStopHour(LogRecSet logRec){
		MyHour hour = new MyHour(0,0);
		if(logRec.getStringStopTime().equals("MANUAL"))
			hour = new MyHour(logRec.getStopTime());
		if(logRec.getStringStopTime().contains("SUNRISE")){
			hour = new MyHour(sunTime[this.indexStop].hourRise, sunTime[this.indexStop].minuteRise);
			if(logRec.getStringStopTime().contains("-"))
				hour.decrementHour(logRec.getStopTime());
			else
				hour.incrementHour(logRec.getStopTime());
			this.indexStop++;
		}
		if(logRec.getStringStopTime().contains("SUNSET")){
			hour = new MyHour(sunTime[this.indexStop].hourSet, sunTime[this.indexStop].minuteSet);
			if(logRec.getStringStopTime().contains("-"))
				hour.decrementHour(logRec.getStopTime());
			else
				hour.incrementHour(logRec.getStopTime());
			this.indexStop++;
		}
		return hour;
	}
	

	public int findMatchingIndex(MyDate date, SunTime[]  sT){
		
		int i = 0;
		MyDate sunDate;
	
//		find index "i" of matching date
		for(sunDate = new MyDate(sT[i].year, sT[i].month, sT[i].day); 
//				sT[i+1] != null && 
				!(date.isEquals(sunDate))
				&& i < CalculateSunTime.recordNumber ; 
				i++)
			 sunDate = new MyDate(sT[i].year, sT[i].month, sT[i].day);
		return(i);
	}
	
	public boolean removeElementWithId(long id){
		boolean b = false;
		
		for(int index = 0; index < recArray.size();){
			if(recArray.get(index).getId() == id){
				recArray.remove(index);
				b = true;
			}
			else
				index++;
		}
		
		return b;
	}

	
public String[] stringForFile(){
	
	String[] string = new String[(recArray.size()+1)];
	
	string[0] = new String("0" + "\t" + ((recArray.size() > 0) ? recArray.get(0).getStart().toString() : "END"));
	
	for(int index = 0; index < recArray.size(); index++){
		string[index+1] = 
				new String( (recArray.get(index).getStop().getTotalMinutes()-recArray.get(index).getStart().getTotalMinutes()) 
				+ "\t" + (((index+1) < recArray.size()) ? recArray.get(index+1).getStart().toString() : "END"));
	}
	
	
	
	return string;
}
	
	/**
	 * @return the recArray
	 */
	public ArrayList<DerivedRecSet> getRecArray() {
		return recArray;
	}

	/**
	 * @param recArray the recArray to set
	 */
	public void setRecArray(ArrayList<DerivedRecSet> recArray) {
		this.recArray = recArray;
	}
	
	
}
