package gui;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class AudioMenu extends JPanel {
	private FckMenu fckMenu;
	private Gain gain;
	private Impedance impedance;
	private ButtonGroup aciBG;
	private JRadioButton radioYes;
	private JRadioButton radioNo;
	private JLabel lblAci;
	private AciParameters aciPane;
	
//	aggiungere gain 
//	aggiungere impedenza
//	risoluzione 8/16 bit
//	Aci yes/no + sottomenu
	
	public FckMenu getFckMenu() {
		return fckMenu;
	}

	public void setFckMenu(FckMenu fckMenu) {
		this.fckMenu = fckMenu;
	}
	
	/**
	 * Create the panel.
	 */
	public AudioMenu() {
		setBorder(new TitledBorder(null, "Audio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fckMenu = new FckMenu();
		gain = new Gain();
		impedance = new Impedance();
		aciBG = new ButtonGroup();
		radioYes = new JRadioButton("Yes");		
		
		radioYes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(radioYes.isSelected())
					aciPane.setVisible(true);
				else
					aciPane.setVisible(false);
			}
		});
		radioNo = new JRadioButton("No");		
		radioNo.setSelected(true);
		lblAci = new JLabel("ACI");
		aciPane = new AciParameters();
		aciPane.setVisible(false);
		add(aciPane);
		
		aciBG.add(radioYes);
		aciBG.add(radioNo);
		
		gain.setSize(new Dimension(100, 50));
		gain.setPreferredSize(new Dimension(100, 50));
		
		add(fckMenu);
		add(gain);
		add(impedance);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(impedance, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(gain, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(fckMenu, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(radioYes)
									.addGap(18)
									.addComponent(radioNo))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addComponent(lblAci, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(aciPane, GroupLayout.PREFERRED_SIZE, 722, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblAci)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(radioYes)
										.addComponent(radioNo)))
								.addComponent(fckMenu, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(impedance, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(aciPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
					.addGap(111))
		);
		setLayout(groupLayout);
	}
	
	public String[] getSetting(){
		String s[] = new String[11];
		
		s[0] = (String) fckMenu.getSelectedItem();
		s[1] = (String) Integer.toString((Integer) gain.getValue());
		s[2] = (String) impedance.getSelectedItem();
		s[3] = (radioNo.isSelected() ? "No" : "Yes");
		
		if(s[3] == "Yes"){
			s[4] = (String) aciPane.getFftMenu().getSelectedItem();
			s[5] = (String) aciPane.getComboBoxWindow().getSelectedItem();		
			s[6] = (String) Integer.toString((Integer) aciPane.getSpinnerNoiseFilter().getValue());
			s[7] = (String) Integer.toString((Integer) aciPane.getSpinnerNoiseFilterH().getValue());
			s[8] = (String) Integer.toString((Integer) aciPane.getSpinnerScaling().getValue());
			s[9] = (String) Integer.toString((Integer) aciPane.getSpinnerClumping().getValue());
			s[10] =	(String) Integer.toString((Integer) aciPane.getSpinnerLowFreq().getValue());
		}
		else{
			for(int i = 5; i < s.length; i++)
				s[i] = "*";
			
		}
		
		return s;
		}
	
	public int getFs() {
		return fckMenu.getSelectedIndex();
	}
	
	public int getGain() {
		return (Integer)gain.getValue();
	}
	
	public int getImpedance() {
		return impedance.getSelectedIndex();
	}
}
