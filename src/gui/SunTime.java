package gui;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;


public class SunTime {
	
	int year, month, day, minuteRise, minuteSet, hourRise, hourSet;
	
	public SunTime(){
		
	}
	
	public SunTime(Calendar today){
		this.year = today.get(today.YEAR);
		this.month = (today.get(today.MONTH)+1);
		this.day = today.get(today.DAY_OF_MONTH);
	}
	
	public void setSet(MyHour time){
		this.hourSet = time.getHours();
		this.minuteSet = time.getMinutes();
	}
	
	public void setRise(MyHour time){
		this.hourRise = time.getHours();
		this.minuteRise = time.getMinutes();		
	}
	
	
	
	/*method that return a string with year/month/day*/
	public String printDataToString(){
		String s = this.year+"/"+this.month+"/"+this.day;
		return s;
	}
	
	/* stampa tutti i dati a schermo per verificare i risultati */
	public void printAll(){
		System.out.println(this.year+" "+this.month+" "+this.day);
		System.out.println("Sun rise: "+this.hourRise+" "+this.minuteRise);
		System.out.println("Sun set: "+this.hourSet+" "+this.minuteSet);
		}
	
	public int getHourRise(){
		return this.hourRise;
	}
	
	public int getMinuteRise(){
		return this.minuteRise;
	}
	
	public int getHourSet(){
		return this.hourSet;
	}
	
	public int getMinuteSet(){
		return this.minuteSet;
	}
	/*
	public void printOnFile(){
		try
	     {
			FileOutputStream fileText = new FileOutputStream("orari_alba_tramonto.txt");
			
			PrintStream scrivi = new PrintStream(fileText);
			scrivi.println(this.year+" "+this.month+" "+this.day+" "+
							this.hourRise+" "+this.minuteRise+" "+this.secondRise+" "+
							this.hourSet+" "+this.minuteSet+" "+this.secondSet);
	      }catch (IOException e)
	      {
	          System.out.println("Errore: " + e);
	          System.exit(1);
	      }
	}*/

}
