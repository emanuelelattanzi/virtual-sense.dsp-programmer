package gui;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;


public class PanelTimer2 extends JPanel {
	private RecDate startRec;
	private RecDate stopRec;
	private RecRange pauseTime;
	private RecRange recTime;
	
	/**
	 * Create the panel.
	 */
	public PanelTimer2() {
		setOpaque(false);
		startRec = new RecDate("Start");
		stopRec = new RecDate("Stop");
		pauseTime = new RecRange("Pause Time");
		recTime = new RecRange("Recording Time");
		add(pauseTime);
		add(recTime);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(startRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stopRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(recTime, GroupLayout.PREFERRED_SIZE, 356, Short.MAX_VALUE)
						.addComponent(pauseTime, GroupLayout.PREFERRED_SIZE, 356, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(startRec, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(recTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stopRec, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(pauseTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder("Rec Mode 2");
		setBorder(titleBorder);
	}
	
	public RecDate getStartRec(){
		return this.startRec;
	}
	
	public RecDate getStopRec(){
		return this.stopRec;
	}
	
	public RecRange getRecTime(){
		return this.recTime;
	}
	
	public RecRange getPauseTime(){
		return this.pauseTime;
	}

}
