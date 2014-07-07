package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CoordinatesMenu extends JPanel {
	private JTextField txtLatitude;
	private JTextField txtName;
	private JTextField txtLongitude;
	private JLabel lblLatitude, lblLongitude, lblNewLabel, lblCity;
	private JButton buttonCoordinates;
	private Coordinates coordCity;
	
	/**
	 * Create the panel.
	 */
	public CoordinatesMenu() {
		
		coordCity = new Coordinates();
				
		txtLatitude = new JTextField();
		txtLatitude.setToolTipText("±DD.ddddddd"+" "
				+"The format of the coordinates must be in decimal degrees,"
				+ " latitude is positive for North and negative for South.");
//		txtLatitude.setText("±DD.ddddddd");
		txtLatitude.setColumns(10);
		
		txtLongitude = new JTextField();
		txtLongitude.setToolTipText("±DDD.ddddddd"+" "
				+"The format of the coordinates must be in decimal degrees,"
				+ " longitude is positive for East and negative for West.");
//		txtLongitude.setText("±DDD.ddddddd");
		txtLongitude.setColumns(10);
		
		lblLatitude = new JLabel("Latitude");
		
		lblLongitude = new JLabel("Longitude");
		
		lblNewLabel = new JLabel("<HTML>\nNOTE:\nyou can enter the coordinates manually or find them "
				+ "by entering the name of the city into the text box below if you have an internet "
				+ "connection;\n</HTML>");
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter here city's name you want to find the coordinates");
//		txtName.setText("City's name");
		txtName.setColumns(10);
		
		lblCity = new JLabel("City");
		
		buttonCoordinates = new JButton("Get coordinates");
		buttonCoordinates.setToolTipText("Click here to find coordinates after city's name entered");
		buttonCoordinates.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(txtName.getText());
				try{
					coordCity = Coordinates.getCityCoordinates(txtName.getText());
				}
				catch(Exception error){
					JOptionPane paneMexErr = new JOptionPane();
					paneMexErr.showMessageDialog(buttonCoordinates, "Error: coordinates not found\n"
							+ "Please check city's name and connection, then retry.", 
							"Error coordinates not found", JOptionPane.ERROR_MESSAGE);
					System.err.println("Errore: " + error);
				}
				
				txtLatitude.setText(Double.toString(coordCity.getLatitudeDD()));
				txtLongitude.setText(Double.toString(coordCity.getLongitudeDD()));
				coordCity.printCoordinate();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(buttonCoordinates))
						.addComponent(lblCity)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLatitude))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLongitude)
								.addComponent(txtLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLatitude)
						.addComponent(lblLongitude))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(32)
					.addComponent(lblCity)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCoordinates))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder("Coordinates");
		setBorder(titleBorder);

	}
	
	public String[] getSetting(){
		String[] s = new String[2];
		s[0] = txtLatitude.getText();
		s[1] = txtLongitude.getText();
		return s;
	}
	
	public Coordinates getCoordinates(){
		Coordinates coord = new Coordinates();
		coord.setLatitudeDD(0);
		coord.setLongitudeDD(0);
		
		try{
			coord.setLatitudeDD(Double.parseDouble(txtLatitude.getText()));
			coord.setLongitudeDD(Double.parseDouble(txtLongitude.getText()));
			if(coord.parseCoordinates() == false){
				System.out.println("Coordinate non valide!");
				coord.setLatitudeDD(0);
				coord.setLongitudeDD(0);
		}
		}catch(NumberFormatException nFE){
			JOptionPane paneMexErr = new JOptionPane();
			paneMexErr.showMessageDialog(buttonCoordinates, "Error: invalid coordinates format\n"
					+ "Please check coordinates format and retry.", 
					"Error invalid coordinates format", JOptionPane.ERROR_MESSAGE);
			System.err.println("Errore: " + nFE);
			System.out.println("Coordinate non valide!");
		}
		return coord;
		
	}

	/**
	 * @return the txtLatitude
	 */
	public JTextField getTxtLatitude() {
		return txtLatitude;
	}

	/**
	 * @param txtLatitude the txtLatitude to set
	 */
	public void setTxtLatitude(JTextField txtLatitude) {
		this.txtLatitude = txtLatitude;
	}

	/**
	 * @return the txtLongitude
	 */
	public JTextField getTxtLongitude() {
		return txtLongitude;
	}

	/**
	 * @param txtLongitude the txtLongitude to set
	 */
	public void setTxtLongitude(JTextField txtLongitude) {
		this.txtLongitude = txtLongitude;
	}
	/**
	 * @return the buttonCoordinates
	 */
	public JButton getButtonCoordinates() {
		return buttonCoordinates;
	}

	/**
	 * @param buttonCoordinates the buttonCoordinates to set
	 */
	public void setButtonCoordinates(JButton buttonCoordinates) {
		this.buttonCoordinates = buttonCoordinates;
	}

	/**
	 * @return the coordCity
	 */
	public Coordinates getCoordCity() {
		return coordCity;
	}

	/**
	 * @param coordCity the coordCity to set
	 */
	public void setCoordCity(Coordinates coordCity) {
		this.coordCity = coordCity;
	}
	
}
