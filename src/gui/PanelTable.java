package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;



public class PanelTable extends JPanel {
	static int recordNumber = 100;
	JLabel label[] = new JLabel[26];
	JLabel labelEmpty = new JLabel();
	CellTable[][] table = new CellTable[24][recordNumber];
	JLabel labelDate[] = new JLabel[recordNumber];
	
	public PanelTable(SunTime[] sunTime) {
		
		try{
		// grid row=numberOfDate+1 column=1(data)+24(hour)
		setLayout(new GridLayout(recordNumber+1, 25, 1, 1));
		// add an empty label
		add(labelEmpty,0);
		// add hour from 0:00 to 23:00
		for(int h = 0; h < 24; h++){
			label[h] = new JLabel(h+":00");
			//label[h].setSize(60, 12);
			add(label[h], h+1 );
		}
		for(int d = 0; d < recordNumber; d++){
			// add date
			labelDate[d] = new JLabel(sunTime[d].printDataToString());
			add(labelDate[d]);
			// add table
			for(int i = 0; i < 24; i++){
				table[i][d] = new CellTable();
				add(table[i][d]);
				if(i == sunTime[d].getHourRise())
					colorCell3(table[i][d], sunTime[d].getMinuteRise(), 60, 0, 0);
				else if(i > sunTime[d].getHourRise() && i < sunTime[d].getHourSet()){
					colorCell2(table[i][d], 0, 60, 0, 0);
				}
				else if(i == sunTime[d].getHourSet())
					colorCell4(table[i][d], 0, sunTime[d].getMinuteSet(), 0, 0);
				else
					colorMidRowUT2(table[i][d], 0, 0);
				
				}
			
			updateUI();
		}

		}catch(Exception e){
			System.out.println("Eccezione tabella catturata: " + e);
			
		}
		
	}
	
	//new
	public void repaintTable(SunTime[] sunTime){
		for(int d = 0; d < recordNumber; d++){
			// add date
			labelDate[d] = new JLabel(sunTime[d].printDataToString());
			add(labelDate[d]);
			// add table
			for(int i = 0; i < 24; i++){
				table[i][d] = new CellTable();
				add(table[i][d]);
				if(i == sunTime[d].hourRise)
					colorCell(table[i][d], sunTime[d].minuteRise, 60);
				if(i > sunTime[d].hourRise && i < sunTime[d].hourSet)
					colorCell(table[i][d], 0, 60);
				if(i == sunTime[d].hourSet)
					colorCell(table[i][d], 0, sunTime[d].minuteSet);	
			}
		}
		updateUI();
	}
	
	//new
	public void updatecolorTable(SunTime[] sunTime){
		for(int d = 0; d < recordNumber; d++){
			
			for(int i = 0; i < 24; i++){
				colorCell6(table[i][d],0,60,0,0);
				
				if(i == sunTime[d].hourRise)
					colorCell(table[i][d], sunTime[d].minuteRise, 60);
				else if(i > sunTime[d].hourRise && i < sunTime[d].hourSet)
					colorCell(table[i][d], 0, 60);
				else if(i == sunTime[d].hourSet)
					colorCell(table[i][d], 0, sunTime[d].minuteSet);
					
			}
		}
		updateUI();
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
	
	public void colorCell2(CellTable table, int columnSx ,int columnDx, final int columnRecSx, final int columnRecDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.YELLOW );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			}	
		updateUI();
	}
	
	public void colorCell3(CellTable table, int columnSx ,int columnDx, final int columnRecSx, final int columnRecDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.YELLOW );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			}	
		for(int c = 0; c < columnSx; c++){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.BLUE );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});		
		}
		updateUI();
	}
	public void colorCell4(CellTable table, int columnSx ,int columnDx, final int columnRecSx, final int columnRecDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.YELLOW );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			}	
		for(int c = columnDx; c < 60; c++){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.BLUE );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
		}
		updateUI();
	}
	
	public void colorCell5(CellTable table, int columnSx ,int columnDx, final int columnRecSx, final int columnRecDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.BLUE );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			}	
		for(int c = 0; c < columnSx; c++){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.YELLOW );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			
		}
		updateUI();
	}
	public void colorCell6(CellTable table, int columnSx ,int columnDx, final int columnRecSx, final int columnRecDx){
		for(int c = columnSx; c < columnDx; c++ ){
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				cell.setBackground( Color.BLUE );
				if(row == 1 && column > columnRecSx && column < columnRecDx)
					cell.setBackground(Color.BLACK);
				return cell;
				}});
			}	
		updateUI();
	}
	
	public void colorMidRowUT(CellTable table, int columnSx, int columnDx){
		
		
		
		for(int c = columnSx; c < columnDx; c++ ){
			
//			System.out.println("Number of row: " + table.getColumnCount());
			
			
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				Color color = Color.BLUE;
				
				if(row == 0 || row == 2){
					color = cell.getBackground();
					cell.setBackground( color );
//					System.out.println("Color: " + color);
				}
//				if(color == Color.YELLOW)
//					System.out.println("Sono passato qui!");
				
//				System.out.println("Colore: " + color);
				
				
				if(row == 1){
					color =  Color.BLACK;
					cell.setBackground( color );
				}
				
				
				System.out.println("Color: " + color);
				cell.setBackground( color );
				
				return cell;

				}});
			}
		
	}
	
public void colorMidRowUT2(CellTable table, int columnSx, int columnDx){
		
		
		
		for(int c = columnSx; c < columnDx; c++ ){
			
			System.out.println("Number of row: " + table.getColumnCount());
			
			
			table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
				Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
				Color color = Color.BLUE;
				
//				if(cell.getBackground() == Color.YELLOW){
//					color = Color.YELLOW;
//					System.out.println("Color: " + color);
//				}
////				
//				if(cell.getBackground() == Color.BLUE){
//					color = Color.BLUE;
//					System.out.println("Color: " + color);
//				}
//				if(color == Color.YELLOW)
//					System.out.println("Sono passato qui!");
				
//				System.out.println("Colore: " + color);
				
				
				if(row == 1)
					cell.setBackground( Color.BLACK );
				else 
					cell.setBackground( color );
				
				return cell;

				}});
			}
}

public void colorMidRowUT1(CellTable table, int columnSx, int columnDx){
	
	
	
	for(int c = columnSx; c < columnDx; c++ ){
		
		System.out.println("Number of row: " + table.getColumnCount());
		
		
		table.getColumnModel().getColumn(c).setCellRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
			{
			Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
			Color color = Color.YELLOW;
			
//			if(cell.getBackground() == Color.YELLOW){
//				color = Color.YELLOW;
//				System.out.println("Color: " + color);
//			}
////			
//			if(cell.getBackground() == Color.BLUE){
//				color = Color.BLUE;
//				System.out.println("Color: " + color);
//			}
//			if(color == Color.YELLOW)
//				System.out.println("Sono passato qui!");
			
//			System.out.println("Colore: " + color);
			
			
			if(row == 1)
				cell.setBackground( Color.BLACK );
			else 
				cell.setBackground( color );
			
			return cell;

			}});
		}
}

	
	public void colorMidRow(CellTable table, final int columnSx, final int columnDx){
		
		
//		for(int c = columnSx; c < columnDx; c++ ){
//			
//			System.out.println("Number of row: " + table.getColumnCount());
			
			table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
				private Color currentColor = Color.BLUE;
			

//		    public AlternateRowsColor() {
//		        setOpaque(true);
//		    }
//
//		    @Override
//		    public AlternateRowsColor() {
//	        setOpaque(true);
//	    }
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int col) {
		    	
		    	if (row == 1 && col > columnSx && col < columnDx) {
		            currentColor = Color.BLACK;
		        } 
		        else {
		            currentColor = Color.BLUE;
		        }
		    	
//		        super.setForeground(currentColor);
		        super.setBackground(currentColor);
		        
//		        setFont(table.getFont());
//		        setValue(value);
		        return this;
		    }
			});
			
		}
	
	public void colorRec(SunTime[] sunTime, DerivedRecSet derivedRec){
		int s = 0, f = 0;
		s = derivedRec.getStart().getDiffDate(MyTime.getCurrentTime());
//		if(derivedRec.getStart()sunTime[s].)
		
	}

	/**
	 * @return the table
	 */
	public CellTable[][] getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(CellTable[][] table) {
		this.table = table;
	}
	
		
//	}
	
}
