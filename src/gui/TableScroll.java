package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;


public class TableScroll extends JPanel {
	private PanelTable table;
	private JScrollPane scrollPane; 
	/**
	 * Create the panel.
	 */
	public TableScroll(SunTime[] sunTime) {
		setLayout(new BorderLayout(0, 0));
		table = new PanelTable(sunTime);
		scrollPane = new JScrollPane(table);
			
		//setPreferredSize(new Dimension(450, 110));
		add(scrollPane, BorderLayout.CENTER);

	}
	/**
	 * @return the table
	 */
	public PanelTable getTable() {
		return table;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(PanelTable table) {
		this.table = table;
	}
	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
