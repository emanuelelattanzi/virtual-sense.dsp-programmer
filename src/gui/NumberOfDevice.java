package gui;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;


public class NumberOfDevice extends JSpinner {

	/**
	 * Create the panel.
	 */
	public NumberOfDevice() {
		setToolTipText("Enter the number of device  you want to load the same program registration");
		setBorder(new TitledBorder(null, "Number of device", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setModel(new SpinnerNumberModel(1, 1, 200, 1));

	}

}
