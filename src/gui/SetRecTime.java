package gui;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.util.EventListener;


public class SetRecTime extends JPanel {
	private RecHour recHour;
	private ButtonGroup radioButtonGroup;
	private JRadioButton rdbtnSunSet, rdbtnSunRise, rdbtnManual;
	private SunOffset sunRiseOff, sunSetOff;
	private JPanel modPanel;
	private int currentMod = 0;
	private JTextField textCurSel;
	private ItemListener itemListener;
	private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public SetRecTime(String title) {
		setPreferredSize(new Dimension(350, 150));
		itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateCurrentMod();
				update();
				setTextCurSel();
			}
		};

//		event for update textCurSel on parameters change
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextCurSel();
			}
		};
		
		
		textCurSel = new JTextField();
		rdbtnSunRise = new JRadioButton("Sun rise time");
		rdbtnSunRise.addItemListener(itemListener);
		rdbtnSunSet = new JRadioButton("Sun set time");
		rdbtnSunSet.addItemListener(itemListener);
		rdbtnManual = new JRadioButton("Set manual");
		rdbtnManual.addItemListener(itemListener);
		radioButtonGroup = new ButtonGroup();
//		recHour = new RecHour("Time");
		modPanel = new JPanel();
		
		radioButtonGroup.add(rdbtnSunSet);
		radioButtonGroup.add(rdbtnSunRise);
		radioButtonGroup.add(rdbtnManual);
		
		rdbtnManual.setSelected(true);
		
		TitledBorder titleBorder = new TitledBorder(title);
		setBorder(titleBorder);
		
		
		
		
		textCurSel.setHorizontalAlignment(SwingConstants.CENTER);
		textCurSel.setEditable(false);
		textCurSel.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(rdbtnSunRise, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(rdbtnSunSet)
					.addComponent(rdbtnManual)
					.addComponent(textCurSel))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(modPanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
		));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(textCurSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(rdbtnSunRise)
					.addComponent(rdbtnSunSet)
					.addComponent(rdbtnManual))
				.addComponent(modPanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		

	}
	
	public void update(){
		
		modPanel.removeAll();
		
		switch(this.currentMod){
		
		case 1:
			sunRiseOff = new SunOffset("Sunrise");
			sunRiseOff.getOffsetTime().getComboHour().addActionListener(actionListener);
			sunRiseOff.getOffsetTime().getComboMin().addActionListener(actionListener);
			sunRiseOff.getRadioBP().addActionListener(actionListener);
			sunRiseOff.getRadioBN().addActionListener(actionListener);
			modPanel.add(sunRiseOff);
		break;
		
		case 2:
			sunSetOff = new SunOffset("Sunset");
			sunSetOff.getOffsetTime().getComboHour().addActionListener(actionListener);
			sunSetOff.getOffsetTime().getComboMin().addActionListener(actionListener);
			sunSetOff.getRadioBP().addActionListener(actionListener);
			sunSetOff.getRadioBN().addActionListener(actionListener);
			modPanel.add(sunSetOff);
		break;
		
		default:
			recHour = new RecHour("Time");
			recHour.getComboHour().addActionListener(actionListener);
			recHour.getComboMin().addActionListener(actionListener);
			modPanel.add(recHour);
		break;
		}
		
		modPanel.repaint();
		modPanel.revalidate();
				
}

public void setTextCurSel(){
	String s = new String();
	
	switch(this.currentMod){
	
	case 1:
		s = "SunRise" + sunRiseOff.getSelCheck() + sunRiseOff.getOffsetTime().getComboHour().getSelectedItem()
				+ ":" + (sunRiseOff.getOffsetTime().getComboMin().getSelectedItem().toString().length() < 2 ? 
							"0" + sunRiseOff.getOffsetTime().getComboMin().getSelectedItem() :
							sunRiseOff.getOffsetTime().getComboMin().getSelectedItem());
	break;
	
	case 2:
		s = "SunSet" + sunSetOff.getSelCheck() + sunSetOff.getOffsetTime().getComboHour().getSelectedItem() 
			+ ":" + (sunSetOff.getOffsetTime().getComboMin().getSelectedItem().toString().length() < 2 ?
						"0" + sunSetOff.getOffsetTime().getComboMin().getSelectedItem():
						sunSetOff.getOffsetTime().getComboMin().getSelectedItem());
	break;
	
	default:
		s = "Time: " + recHour.getComboHour().getSelectedItem() + ":" 
				+ (recHour.getComboMin().getSelectedItem().toString().length() < 2 ?
						"0" + recHour.getComboMin().getSelectedItem(): 
						recHour.getComboMin().getSelectedItem());
//				+ recHour.getComboMin().getSelectedItem() ;
	break;
	}
	
	textCurSel.setText(s);
}

public void updateCurrentMod(){
		if(rdbtnManual.isSelected())
			this.currentMod = 0;
		
		if(rdbtnSunRise.isSelected())
			this.currentMod = 1;
		
		if(rdbtnSunSet.isSelected())
			this.currentMod = 2;
		
	}

/**
 * @return the recHour
 */
public RecHour getRecHour() {
	return recHour;
}

/**
 * @param recHour the recHour to set
 */
public void setRecHour(RecHour recHour) {
	this.recHour = recHour;
}

/**
 * @return the sunRiseOff
 */
public SunOffset getSunRiseOff() {
	return sunRiseOff;
}

/**
 * @param sunRiseOff the sunRiseOff to set
 */
public void setSunRiseOff(SunOffset sunRiseOff) {
	this.sunRiseOff = sunRiseOff;
}

/**
 * @return the sunSetOff
 */
public SunOffset getSunSetOff() {
	return sunSetOff;
}

/**
 * @param sunSetOff the sunSetOff to set
 */
public void setSunSetOff(SunOffset sunSetOff) {
	this.sunSetOff = sunSetOff;
}

/**
 * @return the currentMod
 */
public int getCurrentMod() {
	return currentMod;
}

/**
 * @param currentMod the currentMod to set
 */
public void setCurrentMod(int currentMod) {
	this.currentMod = currentMod;
}



/*public MyHour getTime() {
	MyHour time = null;
	
	switch(currentMod){
		case 0:
			//MANUAL
			time = recHour.getSelHour();
		break;
		case 1:
			//SUNRISE
			time = sunRiseOff.     hour2 = panelTimer3.getSetRecStopTime().getSunRiseOff().getOffsetTime().getSelHour();
		break;
		case 2:
			//SUNSET
			hour2 = panelTimer3.getSetRecStopTime().getSunSetOff().getOffsetTime().getSelHour();
		break;
	}
	
	return time;
}*/


}



