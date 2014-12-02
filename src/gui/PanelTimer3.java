package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class PanelTimer3 extends JPanel {
	private SetRecTime setRecStartTime, setRecStopTime;
	private SetPeriod startDay, stopDay;
	private RecHour startHour, stopHour;
	private ModePanel modePanel;
	/**
	 * Create the panel.
	 */
	public PanelTimer3() {
		//setPreferredSize(new Dimension(800, 329));
		setRecStartTime = new SetRecTime("Start rec"); 
		setRecStartTime.setPreferredSize(new Dimension(500, 280));
		setRecStopTime = new SetRecTime("Stop rec");
		setRecStopTime.setPreferredSize(new Dimension(500, 280));
		startDay = new SetPeriod("Start day");
		stopDay = new SetPeriod("Stop day");
		startHour = new RecHour("Start hour");
		stopHour = new RecHour("Stop hour");
		
		modePanel = new ModePanel("Rec mode");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					//.addContainerGap()
					.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(startHour, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(stopDay, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(stopHour, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addComponent(modePanel, GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(setRecStartTime, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(setRecStopTime, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
				
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)	
					.addComponent(startHour, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(stopDay, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)	
					.addComponent(stopHour, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))	
				.addComponent(modePanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)		
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(setRecStartTime, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addComponent(setRecStopTime, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))	
		);
		setLayout(groupLayout);

	}
	/**
	 * @return the setRecStartTime
	 */
	public SetRecTime getSetRecStartTime() {
		return setRecStartTime;
	}
	/**
	 * @param setRecStartTime the setRecStartTime to set
	 */
	public void setSetRecStartTime(SetRecTime setRecStartTime) {
		this.setRecStartTime = setRecStartTime;
	}
	/**
	 * @return the setRecStopTime
	 */
	public SetRecTime getSetRecStopTime() {
		return setRecStopTime;
	}
	/**
	 * @param setRecStopTime the setRecStopTime to set
	 */
	public void setSetRecStopTime(SetRecTime setRecStopTime) {
		this.setRecStopTime = setRecStopTime;
	}
	/**
	 * @return the startDay
	 */
	public SetPeriod getStartDay() {
		return startDay;
	}
	/**
	 * @param startDay the startDay to set
	 */
	public void setStartDay(SetPeriod startDay) {
		this.startDay = startDay;
	}
	/**
	 * @return the stopDay
	 */
	public SetPeriod getStopDay() {
		return stopDay;
	}
	/**
	 * @param stopDay the stopDay to set
	 */
	public void setStopDay(SetPeriod stopDay) {
		this.stopDay = stopDay;
	}
	
	public GregorianCalendar getStartTime()
	{  	
		GregorianCalendar startTime = new GregorianCalendar(startDay.getSelectPeriod().getYear(),
															startDay.getSelectPeriod().getMonth() - 1,
															startDay.getSelectPeriod().getDay(),
															startHour.getSelHour().getHours(),
															startHour.getSelHour().getMinutes(),
															0);

		return startTime;
	}
	
	public GregorianCalendar getStopTime()
	{
		
		
		GregorianCalendar stopTime = new GregorianCalendar(stopDay.getSelectPeriod().getYear(),
														   stopDay.getSelectPeriod().getMonth() - 1,
														   stopDay.getSelectPeriod().getDay(),
														   stopHour.getSelHour().getHours(),
														   stopHour.getSelHour().getMinutes(),
														   0);

		return stopTime;
	}
	
	public ModePanel getModePanel()
	{
		return modePanel;
	}
}
