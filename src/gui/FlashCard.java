package gui;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


public class FlashCard extends JComboBox {

	
	public FlashCard() {
		setBorder(new TitledBorder(null, "Flash Card Capacities", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setToolTipText("Enter flash card capacities");
		setModel(new DefaultComboBoxModel(new String[] {"1GB", "2GB", "4GB", "8GB", "16GB", "32GB", "64GB", "128GB", "256GB", "512GB"}));
		setSelectedIndex(1);
	}

}
