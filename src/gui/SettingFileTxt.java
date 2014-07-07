package gui;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class SettingFileTxt {
		
	// constructor of class
	public SettingFileTxt(){
		
	}
	public SettingFileTxt(String id){
		createFile(generateName(id));
		
	}
	

	// generate name of file
	public String generateName(String id){
		String name = "";
		
//		MyTime dateTimeFile = new MyTime();
//		name = "LCR" + id + dateTimeFile.getCurrentDateTimeForFile();
		return name;
	}
	
	// generate file .txt with correct name
	public static void createFile(String nameFile) {
		
		try
	     {
			FileOutputStream fileText = new FileOutputStream(nameFile); 
	      }catch (IOException e)
	      {
	          System.out.println("Errore: " + e);
	          System.exit(1);
	      }
	}
	
	// compile file
	public void compileFile(String id, String fck, String fft, String timeZone, String zenith, String Latitude, String Longitude){
		
	}
	
	// save setting file
	public void saveSettingFile(String fileName, String stringToWrite){
		try
	     {
			FileOutputStream fileText = new FileOutputStream(fileName);
			// compile file
			PrintStream scrivi = new PrintStream(fileText);
			scrivi.println(stringToWrite);
			scrivi.close();
	      }catch (IOException e)
	      {
	          System.out.println("Errore: " + e);
	          System.exit(1);
	      }

	}
	
	public void loadSettingFile(String fileName){
		//idMenu.getSelectedItem();
	}
}
