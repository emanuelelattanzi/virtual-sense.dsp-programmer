package gui;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TimerCombo extends JComboBox {
	/**
	 * Create the panel.
	 */
	public TimerCombo() {
		setModel(new DefaultComboBoxModel(new String[] {"-REC MODE-", "Advanced", "Daily", "Test"}));
		setSelectedIndex(0);
		TitledBorder titleBorder = new TitledBorder("Rec Mode");
		setBorder(titleBorder);
	}

}
