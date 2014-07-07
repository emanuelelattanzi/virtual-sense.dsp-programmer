package gui;
import java.util.ArrayList;


public class LogRecSetArray {
	private ArrayList <LogRecSet> logArray = new ArrayList();
	
	public String[] stringForFile(){
		String[] string = new String[(logArray.size()+1)];
		
		string[0] = new String("StartSetting");
		
		for(int index = 0; index < logArray.size(); index++){
			
			string[index+1]= new String(logArray.get(index).stringForFile());
		}
		return string;
	}
}
