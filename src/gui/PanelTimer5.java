package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelTimer5 extends JPanel {
	private SetPeriod startDay, stopDay;
	private RecRange pauseTime, recTime;
	/**
	 * Create the panel.
	 */
	public PanelTimer5() {
		startDay = new SetPeriod("Start day");
		stopDay = new SetPeriod("Stop day");
		pauseTime = new RecRange("Pause Time");
		recTime = new RecRange("Recording Time");
		add(pauseTime);
		add(recTime);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(stopDay, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pauseTime, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(recTime, 0, 0, Short.MAX_VALUE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(startDay, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(recTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stopDay, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(pauseTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

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
	/**
	 * @return the pauseTime
	 */
	public RecRange getPauseTime() {
		return pauseTime;
	}
	/**
	 * @param pauseTime the pauseTime to set
	 */
	public void setPauseTime(RecRange pauseTime) {
		this.pauseTime = pauseTime;
	}
	/**
	 * @return the recTime
	 */
	public RecRange getRecTime() {
		return recTime;
	}
	/**
	 * @param recTime the recTime to set
	 */
	public void setRecTime(RecRange recTime) {
		this.recTime = recTime;
	}

}
