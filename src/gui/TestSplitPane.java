package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;


public class TestSplitPane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSplitPane frame = new TestSplitPane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestSplitPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, "name_4050688857301");
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JLabel lblNewLabel = new JLabel("New label 1");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New 2");
		panel_1.add(lblNewLabel_1);
	}

}
