package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecDate extends JPanel {
	static int numberOfYears = 100;
	private int selectYear, selectMonth, selectDay, selectHour, selectMinutes;
	private MyDate date;
	private String[] d;
	private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4;
	
	/**
	 * Create the panel.
	 */
	public RecDate(String title) {
		
		date = new MyDate();
		date.getCurrentDate();
		
		String[] s = new String[numberOfYears];
		for (int i = 0; i < numberOfYears; i++){
			s[i] = date.getYear() + i + "";
		}
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(s));
		comboBox.setToolTipText("Years");
		comboBox.setSelectedIndex(0);
			
		comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Months");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setSelectedItem(date.getMonth()+"");
		
		// generate the correct days in accord whit year and month
		d = new String[31];
		for (int i = 1; i <= getLastDayOfMonth(Integer.parseInt( (String) comboBox.getSelectedItem()), 
				Integer.parseInt ( (String) comboBox_1.getSelectedItem())); i++){
			d[i-1] = i + "";
		}
		
		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Days");
		comboBox_2.setModel(new DefaultComboBoxModel(d));
		comboBox_2.setSelectedItem(date.getDay()+"");
		
/*
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				d = new String[31];
				for (int i = 1; i <= getLastDayOfMonth(Integer.parseInt( (String) comboBox.getSelectedItem()), 
						Integer.parseInt ( (String) comboBox_1.getSelectedItem())); i++){
					d[i-1] = i + "";
				}
				
				comboBox_2 = new JComboBox();
				comboBox_2.setToolTipText("Days");
				comboBox_2.setModel(new DefaultComboBoxModel(d));
				comboBox_2.setSelectedIndex(-1);
				comboBox_2.repaint();
				comboBox_2.revalidate();
				repaint();
				revalidate();
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				d = new String[31];
				for (int i = 1; i <= getLastDayOfMonth(Integer.parseInt( (String) comboBox.getSelectedItem()), 
						Integer.parseInt ( (String) comboBox_1.getSelectedItem())); i++){
					d[i-1] = i + "";
				}
				
				comboBox_2 = new JComboBox();
				comboBox_2.setToolTipText("Days");
				comboBox_2.setModel(new DefaultComboBoxModel(d));
				comboBox_2.setSelectedIndex(-1);
				comboBox_2.repaint();
				comboBox_2.revalidate();
				repaint();
				revalidate();
				
			}
		});
		
		*/
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_3.setToolTipText("Hours");
		//comboBox_3.setSelectedItem(date.getHour()+"");
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_4.setToolTipText("Minutes");
		
		JLabel lblYear = new JLabel("Years");
		
		JLabel lblMonth = new JLabel("Months");
		
		JLabel lblDay = new JLabel("Days");
		
		JLabel lblHour = new JLabel("Hours");
		
		JLabel lblMinute = new JLabel("Minutes");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYear)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMonth)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDay))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHour)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMinute)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear)
						.addComponent(lblMonth)
						.addComponent(lblDay)
						.addComponent(lblMinute)
						.addComponent(lblHour))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
		TitledBorder titleBorder = new TitledBorder(title);
		setBorder(titleBorder);

	}
	
    private int getLastDayOfMonth(int year, int month) {
        if (month == 1 ||
            month == 3 ||
            month == 5 ||
            month == 7 ||
            month == 8 ||
            month == 10 ||
            month == 12) {
            return 31;
        }
        if (month == 4 ||
            month == 6 ||
            month == 9 ||
            month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public MyTime getSelectRecDate(){
    	MyTime d = new MyTime(Integer.parseInt ( (String) comboBox.getSelectedItem()),
    			Integer.parseInt ( (String) comboBox_1.getSelectedItem()),
    			Integer.parseInt ( (String) comboBox_2.getSelectedItem()),
    			Integer.parseInt ( (String) comboBox_3.getSelectedItem()),
    			Integer.parseInt ( (String) comboBox_4.getSelectedItem()));
    	return(d);
    	
    }

	/**
	 * @return the date
	 */
	public MyDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(MyDate date) {
		this.date = date;
	}

	/**
	 * @return the d
	 */
	public String[] getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(String[] d) {
		this.d = d;
	}
    
   
    
}
