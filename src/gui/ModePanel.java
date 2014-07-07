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


public class ModePanel extends JPanel {

	private FileLength fileLength;
	private ButtonGroup radioButtonGroup;
	private JRadioButton rdbtnAlwaysOn, rdbtnPeriodical;
	private RecRange pauseTime, recTime;
	private JPanel pausePanel;
	private JPanel recPanel;
	private int currentMod = 0;
	
	private ItemListener itemListener;
	//private ActionListener actionListener;
	/**
	 * Create the panel.
	 */
	public ModePanel(String title) {
		setPreferredSize(new Dimension(500, 150));
		
		itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateCurrentMod();
				update();
			}
		};
		
		
		rdbtnAlwaysOn = new JRadioButton("Always on");
		rdbtnAlwaysOn.addItemListener(itemListener);
		rdbtnPeriodical = new JRadioButton("Periodical");
		rdbtnPeriodical.addItemListener(itemListener);
		radioButtonGroup = new ButtonGroup();
		
		pausePanel = new JPanel();
		recPanel = new JPanel();
		
		radioButtonGroup.add(rdbtnAlwaysOn);
		radioButtonGroup.add(rdbtnPeriodical);
		
		rdbtnAlwaysOn.setSelected(true);
		
		TitledBorder titleBorder = new TitledBorder(title);
		setBorder(titleBorder);
		
		fileLength = new FileLength();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(fileLength, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
				.addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(rdbtnAlwaysOn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(rdbtnPeriodical, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(5)
				.addComponent(pausePanel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
				.addComponent(recPanel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(		
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(fileLength, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(rdbtnAlwaysOn)
					.addComponent(rdbtnPeriodical))
				.addComponent(pausePanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
				.addComponent(recPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);
		

	}
	
	public void update(){
		
		pausePanel.removeAll();
		recPanel.removeAll();
		
		switch(this.currentMod){
		
		case 1:
			pauseTime = new RecRange("Pause Time");
			recTime = new RecRange("Recording Time");
			pausePanel.add(pauseTime);
			recPanel.add(recTime);
		break;
		
		default:
			/*recHour = new RecHour("Time");
			recHour.getComboHour().addActionListener(actionListener);
			recHour.getComboMin().addActionListener(actionListener);
			modPanel.add(recHour);*/
		break;
		}
		
		pausePanel.repaint();
		recPanel.repaint();
		pausePanel.revalidate();
		recPanel.revalidate();		
}


public void updateCurrentMod(){
		if(rdbtnAlwaysOn.isSelected())
			this.currentMod = 0;
		
		if(rdbtnPeriodical.isSelected())
			this.currentMod = 1;
	}

/**
 * @return the pauseTime
 */
public RecRange getPauseTime() {
	return pauseTime;
}
/**
 * @param pauseTime the pauseTime to set
 */
public void setPauseTime(RecRange pauseTime) {
	this.pauseTime = pauseTime;
}
/**
 * @return the recTime
 */
public RecRange getRecTime() {
	return recTime;
}
/**
 * @param recTime the recTime to set
 */
public void setRecTime(RecRange recTime) {
	this.recTime = recTime;
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

public int getFileLength()
{
	return (Integer)this.fileLength.getValue();
}

}
