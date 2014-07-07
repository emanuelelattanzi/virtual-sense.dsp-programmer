package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class ZenithMenu extends JPanel {
	private JComboBox comboBoxZen;
	/**
	 * Create the panel.
	 */
	public ZenithMenu() {
		comboBoxZen = new JComboBox();
		
		comboBoxZen.setModel(new DefaultComboBoxModel(new String[] {"official(default)", "civil", "nautical", "astronomical"}));
		comboBoxZen.setSelectedIndex(0);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBoxZen, 0, 110, Short.MAX_VALUE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(comboBoxZen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder("Zenith");
		setBorder(titleBorder);
	}
	
	public double getSelectedValue(){
		double d = 90.83333;
		switch((String) comboBoxZen.getSelectedItem()){
		case "civil":
			d = 96;
		break;
		case "nautical":
			d = 102;
		break;
		case "astronomical":
			d = 108;
		break;
		default:
			d = 90.83333;		
		}
		return d;
	}

	/**
	 * @return the comboBox
	 */
	public JComboBox getComboBoxZen() {
		return comboBoxZen;
	}

	/**
	 * @param comboBox the comboBox to set
	 */
	public void setComboBoxZen(JComboBox comboBox) {
		this.comboBoxZen = comboBox;
	}

	public String getSetting(){
		return((String) comboBoxZen.getSelectedItem());
	}
}
