package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.ScrollPane;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Table extends JTable {
	ScrollPane scrollPane;
	static int recordNumber = 100;
	String tabHead[] = new String[25];
//	JLabel labelEmpty = new JLabel();
	CellTable[][] table = new CellTable[24][recordNumber];
	JLabel labelDate[] = new JLabel[recordNumber];

	/**
	 * Create the panel.
	 */
	public Table(SunTime[] sunTime) {
		scrollPane = new ScrollPane();
		scrollPane.add(this);
		for(int h = 0; h < 24; h++)
			tabHead[h] = new String(h+":00");

		setModel(new DefaultTableModel(
			table,
			tabHead
		));
	
		for(int d = 0; d < recordNumber; d++){
			// add date
			labelDate[d] = new JLabel(sunTime[d].printDataToString());
			add(labelDate[d]);
			// add table
			for(int i = 0; i < 24; i++){
				table[i][d] = new CellTable();
				add(table[i][d]);
				if(i == sunTime[d].getHourRise())
					colorCell(table[i][d], sunTime[d].minuteRise, 60);
				if(i > sunTime[d].getHourRise() && i < sunTime[d].getHourSet())
					colorCell(table[i][d], 0, 60);
				if(i == sunTime[d].getHourSet())
					colorCell(table[i][d], 0, sunTime[d].getMinuteSet());
				}
		}
	}
	public void colorCell(CellTable table, int columnSx ,int columnDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.YELLOW );
				return cell;
				}});
			}		
	}
	
	public void colorMidRow(CellTable table, int columnSx, int columnDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				if(row == 2 )
					cell.setBackground( Color.BLACK );
				return cell;

				}});
			}
	}

}
