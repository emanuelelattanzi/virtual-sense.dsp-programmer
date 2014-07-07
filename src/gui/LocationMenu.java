package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;



public class LocationMenu extends JPanel {
	private ZenithMenu zenithMenu;
	private CoordinatesMenu coordinatesMenu;
	private TimeZoneMenu timeZoneMenu;
	private JButton btnCalculate;
	/**
	 * Create the panel.
	 */
	public LocationMenu() {
		zenithMenu = new ZenithMenu();
		coordinatesMenu = new CoordinatesMenu();
		timeZoneMenu = new TimeZoneMenu();
		btnCalculate = new JButton("Calculate");
		
		coordinatesMenu.setIgnoreRepaint(true);		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(coordinatesMenu, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(timeZoneMenu, 0, 0, Short.MAX_VALUE)
							.addComponent(zenithMenu, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addComponent(btnCalculate))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(coordinatesMenu, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(timeZoneMenu, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(zenithMenu, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCalculate)))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	/**
	 * @return the zenithMenu
	 */
	public ZenithMenu getZenithMenu() {
		return zenithMenu;
	}

	/**
	 * @param zenithMenu the zenithMenu to set
	 */
	public void setZenithMenu(ZenithMenu zenithMenu) {
		this.zenithMenu = zenithMenu;
	}

	/**
	 * @return the coordinatesMenu
	 */
	public CoordinatesMenu getCoordinatesMenu() {
		return coordinatesMenu;
	}

	/**
	 * @param coordinatesMenu the coordinatesMenu to set
	 */
	public void setCoordinatesMenu(CoordinatesMenu coordinatesMenu) {
		this.coordinatesMenu = coordinatesMenu;
	}

	/**
	 * @return the timeZoneMenu
	 */
	public TimeZoneMenu getTimeZoneMenu() {
		return timeZoneMenu;
	}

	/**
	 * @param timeZoneMenu the timeZoneMenu to set
	 */
	public void setTimeZoneMenu(TimeZoneMenu timeZoneMenu) {
		this.timeZoneMenu = timeZoneMenu;
	}

	/**
	 * @return the btnCalculate
	 */
	public JButton getBtnCalculate() {
		return btnCalculate;
	}

	/**
	 * @param btnCalculate the btnCalculate to set
	 */
	public void setBtnCalculate(JButton btnCalculate) {
		this.btnCalculate = btnCalculate;
	}

//	public String getSetting(){
//		String s = "";
//		s += timeZoneMenu.getSetting() + " ";
//		s += zenithMenu.getSetting()+ " ";
//		s += coordinatesMenu.getSetting();
//	return s;
//	}
}
