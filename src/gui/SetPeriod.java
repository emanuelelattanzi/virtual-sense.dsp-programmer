package gui;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class SetPeriod extends JPanel {
	private JTextField textSelDate;
	private JButton btnSelect;
	private Cal cal;
	private String name;
	/**
	 * Create the panel.
	 */
	public SetPeriod(String title) {
		cal = new Cal();
		name = new String(title);
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSelect = new JButton("Select day");
		btnSelect.setMaximumSize(new Dimension(150, 25));
		btnSelect.setMinimumSize(new Dimension(150, 25));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cal = new Cal();
				int reply;
				reply = JOptionPane.showConfirmDialog(btnSelect, cal, "Select " + name, JOptionPane.OK_CANCEL_OPTION);
				
				if(reply == 0){
//					textSelDate.setText(cal.getCurSel());
					textSelDate.setText(new String(cal.getSelDay() + "-" + cal.getSelMonth() + "-" + cal.getSelYear() ));
//					textSelDate.setText(new String(cal.getYy() + "-" + cal.getMm() + "-" + cal.getDd() ));
				}
//				if(OK)->reply == 0
//				dialog.add(cal);
			}
		});
		btnSelect.setSize(new Dimension(150, 20));
		btnSelect.setPreferredSize(new Dimension(120, 25));
		add(btnSelect);
		
		textSelDate = new JTextField();
		textSelDate.setHorizontalAlignment(SwingConstants.CENTER);
		textSelDate.setEditable(false);
		add(textSelDate);
		textSelDate.setColumns(10);

	}
	
//	get period
    public MyDate getSelectPeriod(){
//    	MyDate d = new MyDate(	cal.getYy(), cal.getMm(), cal.getDd());
    	MyDate d = new MyDate(	cal.getSelYear(), cal.getSelMonth(), cal.getSelDay());
    	return(d);
    	
    }
	
	/**
	 * @return the textSelDate
	 */
	public JTextField getTextSelDate() {
		return textSelDate;
	}
	/**
	 * @param textSelDate the textSelDate to set
	 */
	public void setTextSelDate(JTextField textSelDate) {
		this.textSelDate = textSelDate;
	}
	/**
	 * @return the btnSelect
	 */
	public JButton getBtnSelect() {
		return btnSelect;
	}
	/**
	 * @param btnSelect the btnSelect to set
	 */
	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}
	/**
	 * @return the cal
	 */
	public Cal getCal() {
		return cal;
	}
	/**
	 * @param cal the cal to set
	 */
	public void setCal(Cal cal) {
		this.cal = cal;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
