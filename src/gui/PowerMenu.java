package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class PowerMenu extends JPanel {
	private PowerSource powerS;
	private BatteryType batteryT;
	private JTextField textAmper;
	/**
	 * Create the panel.
	 */
	public PowerMenu() {
		powerS = new PowerSource();
		batteryT = new BatteryType();
		
		textAmper = new JTextField();
		textAmper.setToolTipText("Insert manually battery's capacities in mAh");
		textAmper.setBorder(new TitledBorder(null, "mAh Capacities", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textAmper.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(powerS, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(batteryT, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textAmper, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(powerS, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(batteryT, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAmper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(242, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public String[] getSetting(){
		String[] s = new String[3];
		s[0] = (String) powerS.getSelectedItem();
		s[1] = (String) batteryT.getSelectedItem();
		s[3] = textAmper.getText();
		return s;
	}

}
