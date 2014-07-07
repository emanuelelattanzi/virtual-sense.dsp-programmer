package gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DeviceMenu extends JPanel {
	private IdMenu idMenu;
	private JLabel info;
	private NumberOfDevice numberDev;
	/**
	 * @return the idMenu
	 */
	public IdMenu getIdMenu() {
		return idMenu;
	}

	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(IdMenu idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * Create the panel.
	 */
	public DeviceMenu() {
		info = new JLabel("INFO: The recorders will be set up sequentially starting from ID = 1.");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setVisible(false);
		
		idMenu = new IdMenu();

		
		numberDev = new NumberOfDevice();
		add(numberDev);		
		numberDev.addChangeListener(new ChangeListener() {//new MouseAdapter() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if((Integer)numberDev.getValue() > 1) {
					idMenu.setVisible(false);
					info.setVisible(true);
				}
				else {
					idMenu.setVisible(true);
					info.setVisible(false);
				}
				
			}});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)	
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(numberDev, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addGap(39)
						.addComponent(idMenu, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
				)
				.addComponent(info, GroupLayout.DEFAULT_SIZE, 515,  GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(numberDev, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50,  GroupLayout.PREFERRED_SIZE)
						.addComponent(idMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50,  GroupLayout.PREFERRED_SIZE)
				)
				.addComponent(info, GroupLayout.DEFAULT_SIZE, 50,  GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);
		
	}
	
	/*public String[] getSettng(){
		String[] s = new String[2];
		
		s[0] = (String) idMenu.getSelectedItem();
		s[1] = (String) Integer.toString((Integer) numberDev.getValue());
		
		return s;
		}*/

	/*public void setSetting(String[] s){
		
		idMenu.setSelectedItem(s[0]);
		numberDev.setValue(Integer.parseInt(s[1]));
	}*/
	
	/**
	 * @return the numberDev
	 */
	public int getNumberDev() {
		return (Integer)numberDev.getValue();
	}
	
	public int getCurrentId() {
		return (Integer)idMenu.getValue();
	}
	

	/**
	 * @param numberDev the numberDev to set
	 */
	/*public void setNumberDev(NumberOfDevice numberDev) {
		this.numberDev = numberDev;
	}*/
}
