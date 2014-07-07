package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class CapacityMenu extends JPanel {
	private FlashCard flashC;
	private JTextField txtOtherVal;
	private JCheckBox chckbxOtherVal;
	/**
	 * Create the panel.
	 */
	public CapacityMenu() {
		flashC = new FlashCard();
		
		txtOtherVal = new JTextField();
		txtOtherVal.setToolTipText("Insert here the flash card capacities in MB");
		txtOtherVal.setOpaque(false);
		txtOtherVal.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Memory Capacities", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtOtherVal.setColumns(10);
		
		JLabel lblMb = new JLabel("MB");
		
		chckbxOtherVal = new JCheckBox("Other value");
		
		chckbxOtherVal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (chckbxOtherVal.isSelected()){
					txtOtherVal.setOpaque(true);
					txtOtherVal.repaint();
				}
				else{
					txtOtherVal.setOpaque(false);
					txtOtherVal.repaint();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxOtherVal)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtOtherVal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMb, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(flashC, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(flashC, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(chckbxOtherVal)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOtherVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMb))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public String[] getSetting(){
		String[] s = new String[3];
		s[0] = (String) flashC.getSelectedItem();
		s[1] = (chckbxOtherVal.isSelected() ? txtOtherVal.getText() : " ");
		return s;
	}
}
