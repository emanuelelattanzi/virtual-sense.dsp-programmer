package gui;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.util.GregorianCalendar;

import javax.swing.BoxLayout;

import record.RecordSession;


public class TimerMenu extends JPanel {
	private int currentRecMode;
	private JPanel panelTimer;
	private PanelTimer3 panelTimer3;
	private PanelTimer5 panelTimer5;
	private JPanel logArea;
	private JButton btnAddRec;
	private SettingDate ds1, de1, ds2, de2;
	private SettingDateVector dateVector;
	private SunTime[] sunTime;
	private SetDate setDat;
	private SetDateVector datVect;
	private AudioMenu audioMenu;
	private WindowMenu windowMenu;
	
	private ArrayList<RecordSession> sessions;
	
	
	private LogRecSet logRecSet;
	private ArrayList<LogRecSet> logArray = new ArrayList<LogRecSet>();
	private boolean selDeselAll = true;
	private PanelLogRec panelLogRec;
	private JButton btnDeleteRec;
	private JButton btnSelectAll;
	private DerivedRecSetArray derArray = new DerivedRecSetArray();
	
	private TableScroll tableScroll;
	
	private long id;
	
	/**
	 * Create the panel.
	 */
	public TimerMenu(WindowMenu wm){
		this.windowMenu = wm;
		
		inizialize();
	
	}
	
	public TimerMenu(SunTime[] sunTime){
		this.sunTime = sunTime;
		inizialize();
	}
		
	private void inizialize(){
		
		this.sessions = new ArrayList<RecordSession>();
		this.audioMenu = null;
			
		datVect = new SetDateVector();
		dateVector = new SettingDateVector();
		final TimerCombo timerCombo = new TimerCombo();
		timerCombo.setToolTipText("timerCombo");
		//add(timerCombo);
		JLabel titleRec = new JLabel("Records");
		add(titleRec);
		id = 0;
		logArea = new JPanel();
		logArea.setBackground(Color.WHITE);
		add(logArea);
		
		JScrollPane scroll = new JScrollPane (logArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		logArea.setLayout(new BoxLayout(logArea, BoxLayout.Y_AXIS));
		
		panelTimer = new JPanel();
		//currentRecMode = 0;
		// To view only one rec mode
		currentRecMode = 3;
		panelTimer3 = new PanelTimer3();
		panelTimer.add(panelTimer3);
		
		btnAddRec = new JButton("Add Rec");
		btnAddRec.setMaximumSize(new Dimension(106, 25));
		
		btnAddRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean b = false;
//				messo qua xkè sicuramente settato
				derArray.setSunTime(sunTime);
				switch(currentRecMode){
				
					case 3: {
						GregorianCalendar startTime = panelTimer3.getStartTime();
						GregorianCalendar stopTime = panelTimer3.getStopTime();
						GregorianCalendar today = (GregorianCalendar)Calendar.getInstance(TimeZone.getDefault());
						today.add(Calendar.MONTH, 1);
						int fileLength = panelTimer3.getModePanel().getFileLength();
						int fs = audioMenu.getFs();
						int gain =  audioMenu.getGain();
						int impedance = audioMenu.getImpedance();
						
						System.out.println("met-fs: " + fs);
						System.out.println("met-gain: " + gain);
						System.out.println("met-impedance: " + impedance);
						
						System.out.println("met-startTime: " + startTime);
						System.out.println("met-stopTime: " + stopTime);
						System.out.println("met-stopTime: " + today);
								
						if((stopTime.after(startTime) || stopTime.equals(startTime)) &&
						   (startTime.after(today) || startTime.equals(today))) {
							
							b = managePanel3(startTime, stopTime, fileLength, fs, gain, impedance);
						}
						/*if(panelTimer3.getStopDay().getSelectPeriod().isGreaterOrEquals(panelTimer3.getStartDay().getSelectPeriod()) 
								&& panelTimer3.getStartDay().getSelectPeriod().isGreaterOrEquals(MyDate.getCurrentDate())
								){
	
							b = managePanel3();
						}*/
					}
					break;
									
					case 5:
						if(panelTimer5.getStopDay().getSelectPeriod().isGreaterOrEquals(panelTimer5.getStartDay().getSelectPeriod())
								&& panelTimer5.getStartDay().getSelectPeriod().isGreaterOrEquals(MyDate.getCurrentDate())
								&& panelTimer5.getPauseTime().getSelectRecRange().isGreaterZero()
								&& panelTimer5.getRecTime().getSelectRecRange().isGreaterZero()){
							b = managePanel5();
						}
					break;
				
				}
				if(!b){
				JOptionPane paneMexErr = new JOptionPane();
				paneMexErr.showMessageDialog(btnAddRec, "Error: conflict in the records included\n"
						+ "Records mustn't be added.", 
						"Error conflict in the records included", JOptionPane.ERROR_MESSAGE);
				}
				else{
//					update table's color
					//updateColorTable();
					btnDeleteRec.setEnabled(true);
					btnSelectAll.setEnabled(true);
					
					windowMenu.getMntmSaveAs().setEnabled(true);
					windowMenu.getMntmSave().setEnabled(true);
				}
				repaint();
				revalidate();
				
			}
		});
		
		timerCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTimer.removeAll();
				switch((String) timerCombo.getSelectedItem()){
				
					case "Advanced":
						currentRecMode = 3;
						panelTimer3 = new PanelTimer3();
						panelTimer.add(panelTimer3);
					break;
					
					case "Daily":
						currentRecMode = 5;
						panelTimer5 = new PanelTimer5();
						panelTimer.add(panelTimer5);
					break;
					
					case "Test":
						currentRecMode = 1;
						JPanel testPane = new PanelTimer1();
						panelTimer.add(testPane);
					break;
					
					default:
						currentRecMode = 0;
					break;
				}
				
				repaint();
				revalidate();							
			}
		});
		
		btnDeleteRec = new JButton("Delete Rec");
		btnDeleteRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				deleteRec();
				
				if(sessions.size() == 0) {
					btnDeleteRec.setEnabled(false);
					btnSelectAll.setEnabled(false);
					
					windowMenu.getMntmSaveAs().setEnabled(false);
					windowMenu.getMntmSave().setEnabled(false);
					
					selDeselAll = true;
				}
				
				//tableScroll.getTable().updatecolorTable(sunTime);
				//updateColorTable();
				repaint();
				revalidate();
			}
		});
		btnDeleteRec.setMinimumSize(new Dimension(90, 25));
		btnDeleteRec.setPreferredSize(new Dimension(90, 25));
		btnDeleteRec.setEnabled(false);
		
		
		btnSelectAll = new JButton("Sel/Desel All");
		btnSelectAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*for(int index = 0; index < logArray.size(); index++)
					logArray.get(index).getPanelLogRec().getBtnDelete().setSelected(selDeselAll);
				
				selDeselAll = !selDeselAll;
				logArea.repaint();
				logArea.revalidate();*/
				for(int index = 0; index < sessions.size(); index++){
					sessions.get(index).getLogRec().getBtnDelete().setSelected(selDeselAll);
				}

				
				selDeselAll = !selDeselAll;
				repaint();
				revalidate();
			}
		});
		btnSelectAll.setEnabled(false);
		
						
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						//.addComponent(timerCombo, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addComponent(titleRec, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(13)
								.addComponent(btnDeleteRec, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSelectAll)
								.addGap(35)
								.addComponent(btnAddRec, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addComponent(scroll, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)))
					//.addGap(18)
					.addComponent(panelTimer, GroupLayout.PREFERRED_SIZE, 1100, GroupLayout.PREFERRED_SIZE)
					//.addContainerGap())
		));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTimer, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							//.addComponent(timerCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(titleRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDeleteRec, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSelectAll))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	public boolean managePanel3(GregorianCalendar startTime, GregorianCalendar stopTime, int fileLength, int fs, int gain, int impedance){

		boolean b = true;
		//int c = 0;
		
		switch(panelTimer3.getModePanel().getCurrentMod()) {
		
			case 0: {
				// ALWAYSON
				System.out.print("Alwayson: ");
				RecordSession rc = new RecordSession(RecordSession.ALWAYSON, startTime, stopTime, fileLength, fs, gain, impedance);
				sessions.add(rc);
				logArea.add(rc.getLogRec());
				//logArea.repaint();
			}
			break;
			
			case 1: {
				// PERIODICAL
				MyHour rec = panelTimer3.getModePanel().getRecTime().getSelectRecRange();
				MyHour pause = panelTimer3.getModePanel().getPauseTime().getSelectRecRange();
				
				if((rec.getHours() + pause.getHours() + rec.getMinutes() + pause.getMinutes() + rec.getSeconds() + pause.getSeconds()) > 0) {
				
					System.out.print("Periodical: ");
					System.out.println(rec.getHours() + pause.getHours() + ":" + rec.getMinutes() + pause.getMinutes() + "." + rec.getSeconds() + pause.getSeconds());
					
					RecordSession rl = new RecordSession(RecordSession.PERIODICAL, startTime, stopTime, fileLength, fs, gain, impedance,
														 rec.getSeconds() + (rec.getMinutes() * 60) + ((rec.getHours()*60)*60),
														 pause.getSeconds() + (pause.getMinutes() * 60) + ((pause.getHours()*60)*60));
					sessions.add(rl);
					logArea.add(rl.getLogRec());
					//logArea.repaint();
				}else {
					b = false;
				}
			}
			break;
		
			default:
			break;
		}
		/*
		String string1 = "", string2 = "";
		MyHour hour1 = new MyHour(0,0), 
				hour2 = new MyHour(0,0);

		switch(panelTimer3.getSetRecStartTime().getCurrentMod()){
		case 0:
			string1 = "MANUAL";
			hour1 = panelTimer3.getSetRecStartTime().getRecHour().getSelHour();
		break;
		case 1:
			string1 = "SUNRISE" + panelTimer3.getSetRecStartTime().getSunRiseOff().getSelCheck();
			hour1 = panelTimer3.getSetRecStartTime().getSunRiseOff().getOffsetTime().getSelHour();
		break;
		case 2:
			string1 = "SUNSET" + panelTimer3.getSetRecStartTime().getSunSetOff().getSelCheck();
			hour1 = panelTimer3.getSetRecStartTime().getSunSetOff().getOffsetTime().getSelHour();
		break;
		}
		
		switch(panelTimer3.getSetRecStopTime().getCurrentMod()){
		case 0:
			string2 = "MANUAL";
			hour2 = panelTimer3.getSetRecStopTime().getRecHour().getSelHour();
		break;
		case 1:
			string2 = "SUNRISE" + panelTimer3.getSetRecStopTime().getSunRiseOff().getSelCheck();
			hour2 = panelTimer3.getSetRecStopTime().getSunRiseOff().getOffsetTime().getSelHour();
		break;
		case 2:
			string2 = "SUNSET" + panelTimer3.getSetRecStopTime().getSunSetOff().getSelCheck();
			hour2 = panelTimer3.getSetRecStopTime().getSunSetOff().getOffsetTime().getSelHour();
		break;
		}
		logRecSet = new LogRecSet(currentRecMode, panelTimer3.getStartDay().getSelectPeriod(),
				panelTimer3.getStopDay().getSelectPeriod(), 
				string1,
				hour1,
				string2,
				hour2,
				id++);
		
		b = derArray.addRec(logRecSet);
		derArray.printAll();
		
		if(b){	
					logArray.add(logRecSet);
			for(int index = 0; index < logArray.size(); index++){
				System.out.println("Contenuto array: " + logArray.get(index));
				logArea.add(logArray.get(index).getPanelLogRec());
				logArea.repaint();
				logArea.revalidate();
			}
				
			
	//		da qui iniziano i casi particolare x generazione file da esportare e x colorazione
			if(panelTimer3.getSetRecStartTime().getCurrentMod() == 0 
					&& panelTimer3.getSetRecStopTime().getCurrentMod() == 0){
				setDat = new SetDate(currentRecMode, panelTimer3.getStartDay().getSelectPeriod(),
					panelTimer3.getStopDay().getSelectPeriod(), 
					panelTimer3.getSetRecStartTime().getRecHour().getSelHour(),
					panelTimer3.getSetRecStopTime().getRecHour().getSelHour());
			datVect.insertSetDate(setDat);
			}
	//		break;
	//		case 1:
			if(panelTimer3.getSetRecStartTime().getCurrentMod() == 1 
					&& panelTimer3.getSetRecStopTime().getCurrentMod() == 0){
			}
	
	//		selected: sunrise-sunrise
			if(panelTimer3.getSetRecStartTime().getCurrentMod() == 1 
					&& panelTimer3.getSetRecStopTime().getCurrentMod() == 1){
				System.out.println("Suntime: " + sunTime[0].year + " "+ sunTime[0].month +" "+ sunTime[0].day+" "
				+ sunTime[1].getHourRise() + " " + sunTime[1].getMinuteRise());
				
				int i = 0;
				MyDate sunDate;
				MyHour sunHour;
				
				
	//			find index "i" of matching date
				i = findMatchingIndex(sunTime);
				System.out.println("Indice: " + i);
	
				
				do{
					System.out.println("Dayset: " + sunTime[i].year + " "+ sunTime[i].month +" "+ sunTime[i].day + 
							" " + sunTime[i].hourRise + " "+ sunTime[i].minuteRise);
					sunDate = new MyDate(sunTime[i].year, sunTime[i].month, sunTime[i].day);
					sunHour = new MyHour(sunTime[i].hourRise, sunTime[i].minuteRise);
					i++;
					
	//				offset +
					if(panelTimer3.getSetRecStartTime().getSunRiseOff().getSelCheck() == '+'){
						System.out.println("eseguo if + : "
					+ panelTimer3.getSetRecStartTime().getSunRiseOff().getOffsetTime().getSelHour() );
						sunHour.incrementHour(panelTimer3.getSetRecStartTime().getSunRiseOff().getOffsetTime().getSelHour());
					}
	//				offset -
					else{
						System.out.println("eseguo else -");
						sunHour.decrementHour(panelTimer3.getSetRecStartTime().getSunRiseOff().getOffsetTime().getSelHour());
					}
					setDat = new SetDate(currentRecMode, sunDate, sunDate, sunHour, sunHour);
					datVect.insertSetDate(setDat);	
					
				}while((panelTimer3.getStopDay().getSelectPeriod().isGreater(sunDate))
					&& i <= CalculateSunTime.recordNumber);
				
			}
		}
		else
		
		id--;
		
		*/
		return b;
	}

public int findMatchingIndex(SunTime[]  sT){
	
	int i = 0;
	MyDate sunDate;
	
//	find index "i" of matching date
	for(sunDate = new MyDate(sT[i].year, sT[i].month, sT[i].day); 
//			(panelTimer3.getStartDay().getSelectPeriod().isGreater(sunDate))
			!(panelTimer3.getStartDay().getSelectPeriod().isEquals(sunDate))
			&& i <= CalculateSunTime.recordNumber ; 
			i++, sunDate = new MyDate(sT[i].year, sT[i].month, sT[i].day));
	
	return(i);
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

public boolean managePanel5(){
	boolean b;
//		System.out.println("Contenuto panel5: "+panelTimer5.getStartDay().getSelectPeriod()+" "
//+panelTimer5.getStopDay().getSelectPeriod()+" "+panelTimer5.getRecTime().getSelectRecRange()+" "
//				+panelTimer5.getPauseTime().getSelectRecRange())
//;
	logRecSet = new LogRecSet(currentRecMode,
			panelTimer5.getStartDay().getSelectPeriod(),
			panelTimer5.getStopDay().getSelectPeriod(),
			"REC",
			panelTimer5.getRecTime().getSelectRecRange(),
			"PAUSE",
			panelTimer5.getPauseTime().getSelectRecRange(),
			id++);
	
//	System.out.println("Contenuto log strat: "+logRecSet.getStartDate());
	b = derArray.addRec(logRecSet);
	derArray.printAll();
	
	if(b){
			logArray.add(logRecSet);
			
			
	for(int index = 0; index < logArray.size(); index++){
		System.out.println("Contenuto array: " + logArray.get(index).getStartDate());
		logArea.add(logArray.get(index).getPanelLogRec());
		logArea.repaint();
		logArea.revalidate();
	}
	}
	return b;
}

public boolean loadLogArray(LogRecSet[] logRecSet){
	boolean b = false;

for(int i = 0; i < logRecSet.length; i++){
	b = derArray.addRec(logRecSet[i]);
	
//	da rimuovere
	derArray.printAll();
	
	if(b){
			logArray.add(logRecSet[i]);
}			
			
	for(int index = 0; index < logArray.size(); index++){
//		da rimuovere
		System.out.println("Contenuto array: " + logArray.get(index).getStartDate());
		
		logArea.add(logArray.get(index).getPanelLogRec());
		logArea.repaint();
		logArea.revalidate();
	}
	}
	return b;
}

// delete selected record of log
private void deleteRec(){
	for(int i=0; i<sessions.size(); i++) {
		if(sessions.get(i).getLogRec().getBtnDelete().isSelected()) {
			RecordSession ses = sessions.get(i);
			logArea.remove(ses.getLogRec());
			sessions.remove(i);
			i--;
		}
	}
	
}
	
	/*int index = 0;
	while(index < logArray.size()){
//		x testing
		System.out.println("Dimensione array: " + logArray.size());
//		panelLogRec = new PanelLogRec(logArray.get(index).toString());
	
		if(logArray.get(index).getPanelLogRec().getBtnDelete().isSelected()){
			derArray.removeElementWithId(logArray.get(index).getId());
			logArea.remove(logArray.get(index).getPanelLogRec());
			logArray.remove(index);
//			x testing
			System.out.println("Dimensione array dopo eliminazione: " + logArray.size());
		}
		else
			index++;
		
		logArea.repaint();
		logArea.revalidate();
	}
//	x testing
	for(index = 0; index < logArray.size(); index++)
		System.out.println("Contenuto array dopo eliminazione: " + logArray.get(index));

}*/

//delete selected record of log
/*private void deleteAllRec(){
	int index = 0;
	while(index < logArray.size()){
//		x testing
		System.out.println("Dimensione array: " + logArray.size());
//		panelLogRec = new PanelLogRec(logArray.get(index).toString());
	
		if(logArray.get(index).getPanelLogRec().getBtnDelete().isSelected()){
			derArray.removeElementWithId(logArray.get(index).getId());
			logArea.remove(logArray.get(index).getPanelLogRec());
			logArray.remove(index);
//			x testing
			System.out.println("Dimensione array dopo eliminazione: " + logArray.size());
		}
		else
			index++;
		
		logArea.repaint();
		logArea.revalidate();
	}
//	x testing
	for(index = 0; index < logArray.size(); index++)
		System.out.println("Contenuto array dopo eliminazione: " + logArray.get(index));

}*/

public void holdColor(int n, int s, int i, int sx, int dx){
	
	if(n > sunTime[s].getHourRise() && n < sunTime[s].getHourSet()){
	tableScroll.getTable().colorCell2(tableScroll.getTable().table[n][s], sx, dx, sx, dx);
}
else if(n == sunTime[s].getHourSet())
	tableScroll.getTable().colorCell4(tableScroll.getTable().table[n][s], 
			sx, 
			sunTime[s].getMinuteSet(), 
			sx, 
			dx);
	
else if(n == sunTime[s].getHourRise()){
	
	tableScroll.getTable().colorCell5(tableScroll.getTable().table[n][s], 
			0, 
			sunTime[s].getMinuteRise(), 
			sx, 
			dx);
	
	tableScroll.getTable().colorCell2(tableScroll.getTable().table[n][s],
			sunTime[s].getMinuteRise(),
			dx,  
			sx, 
			dx);
}
else
	tableScroll.getTable().colorCell6(tableScroll.getTable().table[n][s], 
			sx, 
			dx, 
			sx, 
			dx);
}

public void updateColorTable(){
//	colorare tabella
	for(int i = 0; i < derArray.getRecArray().size(); i++){
		int s = 0, f = 0;
		s = derArray.getRecArray().get(i).getStart().getDiffDate(MyTime.getCurrentTime());
		if(s >= 0){
//		System.out.println("Differenza in giorni: " + s);
			f = derArray.getRecArray().get(i).getStop().getDiffDate(MyTime.getCurrentTime());
			for(int n = derArray.getRecArray().get(i).getStart().getHour().getHours(); 
					n <= derArray.getRecArray().get(i).getStop().getHour().getHours(); 
					n++){
	//			tableScroll.getTable().colorCell2(tableScroll.getTable().table[n][s], 0, 60, 50, 55);
	//			if(n == derArray.getRecArray().get(i).getStart().hour.getHours())
	//				tableScroll.getTable().colorCell3(tableScroll.getTable().table[n][s], 
	//						sunTime[s].getMinuteRise(), 
	//						60, 
	//						derArray.getRecArray().get(i).getStart().getHour().getMinutes(), 
	//						60);
	//			else 
				
	
	//			else
	//				tableScroll.getTable().colorMidRowUT2(tableScroll.getTable().table[n][s], 0, 0);
				
	//			start rec hour
				if(n == derArray.getRecArray().get(i).getStart().getHour().getHours() &&
						n == derArray.getRecArray().get(i).getStop().getHour().getHours())
					holdColor(n, s, i, 
							derArray.getRecArray().get(i).getStart().getHour().getMinutes(),
							derArray.getRecArray().get(i).getStop().getHour().getMinutes());
				else if(n == derArray.getRecArray().get(i).getStart().getHour().getHours())
					holdColor(n, s, i, derArray.getRecArray().get(i).getStart().getHour().getMinutes(), 60);
				else if(n == derArray.getRecArray().get(i).getStop().getHour().getHours())
					holdColor(n, s, i, 0, derArray.getRecArray().get(i).getStop().getHour().getMinutes());
				else
					holdColor(n, s, i, 0, 60);
			}
		}
	}
}

/**
 * @return the derArray
 */
public DerivedRecSetArray getDerArray() {
	return derArray;
}

/**
 * @param derArray the derArray to set
 */
public void setDerArray(DerivedRecSetArray derArray) {
	this.derArray = derArray;
}

/**
 * @return the logArray
 */
public ArrayList<LogRecSet> getLogArray() {
	return logArray;
}

/**
 * @param logArray the logArray to set
 */
public void setLogArray(ArrayList<LogRecSet> logArray) {
	this.logArray = logArray;
}

/**
 * @return the logArea
 */
public JPanel getLogArea() {
	return logArea;
}

/**
 * @param logArea the logArea to set
 */
public void setLogArea(JPanel logArea) {
	this.logArea = logArea;
}

/**
 * @return the tableScroll
 */
public TableScroll getTableScroll() {
	return tableScroll;
}

/**
 * @param tableScroll the tableScroll to set
 */
public void setTableScroll(TableScroll tableScroll) {
	this.tableScroll = tableScroll;
}

	public ArrayList<RecordSession> getSessions() {
		return this.sessions;
	}
	
	public void setAudioMenu(AudioMenu am) {
		this.audioMenu = am;
	}

}
