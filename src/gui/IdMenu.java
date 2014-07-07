package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;



//public class IdMenu extends JComboBox {

	/**
	 * Create the panel.
	 */
	/*public IdMenu(){
		setEditable(true);
		setModel(new DefaultComboBoxModel(new String[] {"-ID-", "00001", "00002", "00003", "00004"}));
		setSelectedIndex(0);
		TitledBorder titleBorder = new TitledBorder("ID device");
		setBorder(titleBorder);
	}
	
}*/

public class IdMenu extends JSpinner {

	/**
	 * Create the panel.
	 */
	public IdMenu() {
		setToolTipText("Enter recorder ID that you want program.");
		setBorder(new TitledBorder(null, "Choose recorder ID:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setModel(new SpinnerNumberModel(1, 1, 200, 1));

	}

}