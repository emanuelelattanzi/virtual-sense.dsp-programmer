package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelTimer1 extends JPanel {
	private SetRecTime setRecStartTime, setRecStopTime;
	private SetPeriod startDay, stopDay;

	/**
	 * Create the panel.
	 */
	public PanelTimer1() {
		setPreferredSize(new Dimension(872, 329));
		setRecStartTime = new SetRecTime("Start rec"); 
		setRecStartTime.setPreferredSize(new Dimension(400, 280));
		setRecStopTime = new SetRecTime("Stop rec");
		setRecStopTime.setPreferredSize(new Dimension(400, 280));
		startDay = new SetPeriod("Start day");
		stopDay = new SetPeriod("Stop day");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(stopDay, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(setRecStartTime, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(setRecStopTime, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(setRecStartTime, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
							.addComponent(setRecStopTime, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stopDay, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(52, Short.MAX_VALUE))
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
}
