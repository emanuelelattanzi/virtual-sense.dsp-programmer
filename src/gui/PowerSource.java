package gui;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


public class PowerSource extends JComboBox {

	/**
	 * Create the panel.
	 */
	public PowerSource() {
		setBorder(new TitledBorder(null, "Power source", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setToolTipText("Select power source");
		setModel(new DefaultComboBoxModel(new String[] {"Internal", "Esternal"}));
		setSelectedIndex(0);

	}

}
