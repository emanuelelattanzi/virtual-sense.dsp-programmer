package gui;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelLogRec extends JPanel {
	private JTextField txtRec;
	private JCheckBox btnDelete;

	/**
	 * Create the panel.
	 */
	public PanelLogRec(String text) {
		setBackground(Color.WHITE);
		
		btnDelete = new JCheckBox("");
		
		
		txtRec = new JTextField();
		txtRec.setText(text);
		txtRec.setHorizontalAlignment(JTextField.LEFT);
		txtRec.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			//groupLayout.createParallelGroup(Alignment.LEADING)
				//.addGroup(groupLayout.createSequentialGroup()
			groupLayout.createSequentialGroup()
				.addGap(2)
				.addComponent(btnDelete)
				//.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtRec, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete)
						.addComponent(txtRec, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					//.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	/**
	 * @return the btnDelete
	 */
	public JCheckBox getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JCheckBox btnDelete) {
		this.btnDelete = btnDelete;
	}

}
