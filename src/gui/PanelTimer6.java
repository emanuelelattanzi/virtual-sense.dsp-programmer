package gui;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;


public class PanelTimer6 extends JPanel {
	private RecDate startRec;
	private RecDate stopRec;
	private ButtonGroup radioButtonGroup;
	private JRadioButton rdbtnDay;
	private JRadioButton rdbtnNight;
	/**
	 * Create the panel.
	 */
	public PanelTimer6() {
		startRec = new RecDate("Start");
		stopRec = new RecDate("Stop");
		
		rdbtnDay = new JRadioButton("Day");
		rdbtnDay.setSelected(true);
		rdbtnNight = new JRadioButton("Night");
		
		// group radiobutton
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rdbtnDay);
		radioButtonGroup.add(rdbtnNight);
				
		JLabel lblRecOnly = new JLabel("Rec mode");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(stopRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(startRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(rdbtnDay)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNight)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblRecOnly)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(startRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stopRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblRecOnly)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNight)
								.addComponent(rdbtnDay))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder("Rec Mode 6");
		setBorder(titleBorder);
	}
	
	public boolean RecOnDay(){
		return (this.rdbtnDay.isSelected());
	}
	
	public RecDate getStartRec(){
		return this.startRec;
	}
	
	public RecDate getStopRec(){
		return this.stopRec;
	}
}
