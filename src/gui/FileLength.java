package gui;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class FileLength extends JSpinner {

	/**
	 * Create the panel.
	 */
	public FileLength() {
		setPreferredSize(new Dimension(25, 15));
		setMinimumSize(new Dimension(25, 15));
		setToolTipText("Enter max length in minute of each file to be resister.");
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "File Length (sec)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setModel(new SpinnerNumberModel( 60, 1, 1000, 1));

	}

}
