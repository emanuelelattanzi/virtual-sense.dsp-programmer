package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;


public class FckMenu extends JComboBox {
//	x test
	public static String selectedItem = "Stringa statica! OK";
	public static String[] values = {"16000", "22050", "44100", "96000", "192000"};
	/**
	 * Create the panel.
	 */
	public FckMenu(){
		
		setModel(new DefaultComboBoxModel(values));
		setSelectedIndex(0);
		setEditable(false);
		//selectedItem = (String) this.getSelectedItem();
		TitledBorder titleBorder = new TitledBorder("Sample rate");
		setBorder(titleBorder);
	}
}
