package gui;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;


public class CellTable extends JTable {

	/**
	 * Create the panel.
	 */
	public CellTable() {
		setRowSelectionAllowed(false);
		setShowGrid(false);
		setBackground(Color.BLUE);
		setIntercellSpacing(new Dimension(0, 0));
		setRowHeight(10);
		setGridColor(Color.WHITE);
		setPreferredSize(new Dimension(60, 30));
		setPreferredScrollableViewportSize(new Dimension(60, 30));
		setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
					"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"
			}
		));
		for(int i = 0; i < this.getColumnCount(); i++ ){
		//getColumnModel().getColumn(i).setPreferredWidth(1);
		getColumnModel().getColumn(i).setMinWidth(1);
		}

	}
	//non usato
//	public void colorCell(CellTable table, int columnDx){
//		for(int c = 0; c < columnDx; c++ ){
//			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {
//
//				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
//				{
//				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
//				//if(row > 3  && row < 6)
//				cell.setBackground( Color.green );
//				//else
//				//cell.setBackground( Color.white );
//				return cell;
//
//				}});
//			}
//		
//	}
	// non usato
//	public void colorMidRow(CellTable table, int columnSx, int columnDx){
//		for(int c = columnSx; c < columnDx; c++ ){
//			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {
//
//				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
//				{
//				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
//				if(row > 3  && row < 6)
//					cell.setBackground( Color.black );
//				return cell;
//				}});
//			}
//		
//	}

}
