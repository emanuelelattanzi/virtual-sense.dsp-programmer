package gui;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SunOffset extends JPanel {
	
	private RecHour offsetTime;
	private JRadioButton radioBN, radioBP;
	private ButtonGroup radioButtonGroup;
	/**
	 * Create the panel.
	 */
	public SunOffset(String title) {
		setPreferredSize(new Dimension(230, 110));
		
		radioBP = new JRadioButton("+");
		radioBN = new JRadioButton("-");
		offsetTime = new RecHour("offset ±");
		// group radiobutton
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(radioBN);
		radioButtonGroup.add(radioBP);
		
		radioBP.setSelected(true);
		
		TitledBorder titleBorder = new TitledBorder(title);
		setBorder(titleBorder);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(radioBN)
						.addComponent(radioBP))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(offsetTime, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(radioBP)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radioBN))
						.addComponent(offsetTime, GroupLayout.PREFERRED_SIZE, 82, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	/**
	 * @return the offsetTime
	 */
	public RecHour getOffsetTime() {
		return offsetTime;
	}
	/**
	 * @param offsetTime the offsetTime to set
	 */
	public void setOffsetTime(RecHour offsetTime) {
		this.offsetTime = offsetTime;
	}
	/**
	 * @return the radioBP
	 */
	public JRadioButton getRadioBP() {
		return radioBP;
	}
	/**
	 * @param radioBP the radioBP to set
	 */
	public void setRadioBP(JRadioButton radioBP) {
		this.radioBP = radioBP;
	}
	/**
	 * @return the radioBN
	 */
	public JRadioButton getRadioBN() {
		return radioBN;
	}
	/**
	 * @param radioBN the radioBN to set
	 */
	public void setRadioBN(JRadioButton radioBN) {
		this.radioBN = radioBN;
	}
	
	public char getSelCheck(){
		char s = '+';
		if(radioBN.isSelected() == true)
			s = '-';
		
		return s;
	}
}
