package gui;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;


public class SensorsMenu extends JPanel {
	private JRadioButton rdbtnOff;
	private JRadioButton rdbtnOn;
	private JLabel lblTemperature;
	private ButtonGroup buttonGroup;

	/**
	 * Create the panel.
	 */
	public SensorsMenu() {
		
		rdbtnOn = new JRadioButton("On");
		rdbtnOff = new JRadioButton("Off");
		rdbtnOff.setSelected(true);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnOff);
		buttonGroup.add(rdbtnOn);
		
		lblTemperature = new JLabel("Temperature");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(rdbtnOn)
							.addGap(35)
							.addComponent(rdbtnOff))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblTemperature)))
					.addContainerGap(302, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblTemperature)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnOn)
						.addComponent(rdbtnOff))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public String getSetting(){
		String s;
		s = (rdbtnOn.isSelected() ? "ON" : "OFF"); 
		return s;
	}
}
