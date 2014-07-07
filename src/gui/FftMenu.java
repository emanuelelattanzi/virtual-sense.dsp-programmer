package gui;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


public class FftMenu extends JComboBox {

	/**
	 * Create the panel.
	 */
	public FftMenu(){
		setModel(new DefaultComboBoxModel(new String[] {"-FFT-", "512", "1024", "2048"}));
		setSelectedIndex(0);
		TitledBorder titleBorder = new TitledBorder("Fast Fourier Transform");
		setBorder(titleBorder);
	
	}

}
