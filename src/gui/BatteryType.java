package gui;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;


public class BatteryType extends JComboBox {

	/**
	 * Create the panel.
	 */
	public BatteryType() {
		setToolTipText("Select kind of battery");
		setModel(new DefaultComboBoxModel(new String[] {"Alkaline", "NiMH", "Custom"}));
		setSelectedIndex(0);
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Battery type", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	}

}
