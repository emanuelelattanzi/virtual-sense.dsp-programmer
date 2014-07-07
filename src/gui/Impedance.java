package gui;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


public class Impedance extends JComboBox {
	
	public static String[] values = {"10", "20", "30"};

	/**
	 * Create the panel.
	 */
	public Impedance() {
		setBorder(new TitledBorder(null, "Impedence kΩ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setName("Impedence");
		setModel(new DefaultComboBoxModel(values));
		setSelectedIndex(0);

	}

}
