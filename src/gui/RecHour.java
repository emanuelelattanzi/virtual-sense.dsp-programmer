package gui;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;


public class RecHour extends JPanel {
	private JComboBox comboHour, comboMin;

	

	/**
	 * Create the panel.
	 */
	public RecHour(String title) {
		setPreferredSize(new Dimension(142, 94));
		comboHour = new JComboBox();
		comboHour.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboHour.setToolTipText("Hours");
		
		comboMin = new JComboBox();
		comboMin.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboMin.setToolTipText("Minutes");
		

		JLabel lblHour = new JLabel("Hours");
		
		JLabel lblMinute = new JLabel("Minutes");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(comboHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHour)
							.addGap(18)
							.addComponent(lblMinute)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHour)
						.addComponent(lblMinute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder(title);
		setBorder(titleBorder);

	}
	
	public MyHour getSelHour(){
		return(new MyHour(Integer.parseInt((String) comboHour.getSelectedItem()), 
				Integer.parseInt((String) comboMin.getSelectedItem())));
	}
	/**
	 * @return the comboHour
	 */
	public JComboBox getComboHour() {
		return comboHour;
	}

	/**
	 * @param comboHour the comboHour to set
	 */
	public void setComboHour(JComboBox comboHour) {
		this.comboHour = comboHour;
	}

	/**
	 * @return the comboMin
	 */
	public JComboBox getComboMin() {
		return comboMin;
	}

	/**
	 * @param comboMin the comboMin to set
	 */
	public void setComboMin(JComboBox comboMin) {
		this.comboMin = comboMin;
	}
	

}
