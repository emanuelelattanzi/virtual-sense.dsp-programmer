package gui;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;

import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;


public class TimeZoneMenu extends JPanel {
	private JComboBox comboBoxHour;
	private JComboBox comboBoxMinute;
	/**
	 * Create the panel.
	 */
	public TimeZoneMenu() {
		comboBoxHour = new JComboBox();
		comboBoxMinute = new JComboBox();
		setMaximumSize(new Dimension(300, 300));
		
		
		comboBoxHour.setModel(new DefaultComboBoxModel(new String[] {"-12", "-11", "-10", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10", "+11", "+12", "+13", "+14"}));
		comboBoxHour.setSelectedIndex(12);
		
		comboBoxMinute.setModel(new DefaultComboBoxModel(new String[] {":00", ":15", ":30", ":45"}));
		comboBoxMinute.setSelectedIndex(0);
		
		JLabel lblUtc = new JLabel("UTC");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(comboBoxHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(lblUtc)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblUtc)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		TitledBorder titleBorder = new TitledBorder("Time zone");
		setBorder(titleBorder);
	}
	
	public String[] getSetting(){
		String[] s = new String[2];
		s[0] = (String) comboBoxHour.getSelectedItem();
		s[1] = (String) comboBoxMinute.getSelectedItem();
		return s;
	}
	
	public double getSelectedValue(){
		double c = 0.0 ,d = 0.0;
		c = Double.parseDouble((String) comboBoxHour.getSelectedItem());
		switch((String) comboBoxMinute.getSelectedItem()){
		case ":15":
			d = 0.25;
		break;
		case ":30":
			d = 0.5;
		break;
		case ":45":
			d = 0.75;
		break;
		default:
			d = 0.0;		
		}
		return (c+d);
	}

	/**
	 * @return the comboBoxHour
	 */
	public JComboBox getComboBoxHour() {
		return comboBoxHour;
	}

	/**
	 * @param comboBoxHour the comboBoxHour to set
	 */
	public void setComboBoxHour(JComboBox comboBoxHour) {
		this.comboBoxHour = comboBoxHour;
	}

	/**
	 * @return the comboBoxMinute
	 */
	public JComboBox getComboBoxMinute() {
		return comboBoxMinute;
	}

	/**
	 * @param comboBoxMinute the comboBoxMinute to set
	 */
	public void setComboBoxMinute(JComboBox comboBoxMinute) {
		this.comboBoxMinute = comboBoxMinute;
	}
	
}
