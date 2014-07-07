package gui;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;

import java.awt.Dimension;


public class ControlSun extends JPanel {
	private JTextField txtLatitude;
	private JTextField txtLongitude;

	/**
	 * Create the panel.
	 */
	public ControlSun() {
		setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		txtLatitude = new JTextField();
		txtLatitude.setText("insert latitude");
		add(txtLatitude, "flowx,cell 1 1,alignx left");
		txtLatitude.setColumns(10);
		
		txtLongitude = new JTextField();
		txtLongitude.setText("insert longitude");
		add(txtLongitude, "cell 1 1");
		txtLongitude.setColumns(10);
		
		
		String[] optionsZenith = {"offical (default)", "civil", "nautical", "astronomical"};
		JComboBox comboBox = new JComboBox(optionsZenith);
		comboBox.setEditable(false);
		comboBox.setName("zenith");
		add(comboBox, "cell 1 1");
		JLabel label= new JLabel("Select Zenith:");
		label.setLabelFor(comboBox);
		comboBox.add(label);
	}

}
