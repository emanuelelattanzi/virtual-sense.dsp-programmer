package gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class WindowMenu extends JMenuBar {
	
	public static final String APPVERSION = "0.0.1 Alpha - 2 december 2014";
	public static final String BOOTIMGVERSION = "1.1.contiguous.advanced.scheduler-03-11-2014";
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnWindow;
	private JMenuItem mntmSave, mntmLoad, mntmExit, mntmHelpTopic, mntmAbout, mntmSaveAs, mntmLoadSetFile, mntmNew;

	private JFrame jframe;
	
	private JFileChooser chooserSave;
	
	/**
	 * Create the panel.
	 */
	public WindowMenu(final JFrame frame) {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		jframe = frame;
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmSave = new JMenuItem("Save session");
		mntmSaveAs = new JMenuItem("Setup SD card/s");
		mntmLoad = new JMenuItem("Load");
		mntmLoadSetFile = new JMenuItem("Load setting file");
		mntmNew = new JMenuItem("New");
		mntmExit = new JMenuItem("Exit");

		// Disable because not implemented
		mntmLoad.setEnabled(false);
		mntmLoadSetFile.setEnabled(false);
		mntmNew.setEnabled(false);
		
		// Disable only on the start
		mntmSave.setEnabled(false);
		mntmSaveAs.setEnabled(false);
		
		
		
//	trasferito nel main
		
//		mntmSave.addMouseListener(new MouseAdapter() {
//			// apre finestra di salvataggio
//			@Override
//			public void mousePressed(MouseEvent ev) {
//					chooserSave = new JFileChooser();
//					int returnF = chooserSave.showSaveDialog(frame); 
//					if (returnF == JFileChooser.APPROVE_OPTION){
//						File newFile = chooserSave.getSelectedFile();
//						try {
//							newFile.createNewFile();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						// compile file
//						PrintStream scrivi;
//						try {
//							scrivi = new PrintStream(newFile);
////							insert here the setting's string
//							scrivi.println("\nOK\n");
//							scrivi.close();
//						} catch (FileNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//			}
//		});
		
		mnFile.add(mntmNew);
		mnFile.add(mntmSave);
		mnFile.add(mntmSaveAs);
		mnFile.add(mntmLoad);
		mnFile.add(mntmLoadSetFile);
		mnFile.add(mntmExit);
		
//	trasferito nel main
		
//		mntmLoad.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				JFileChooser chooserLoad = new JFileChooser();
//				int returnF = chooserLoad.showOpenDialog(frame);
//				if (returnF == JFileChooser.APPROVE_OPTION){
//					File readFile = chooserLoad.getSelectedFile();
//					BufferedReader input;
//					try {
//						input = new BufferedReader(new FileReader(readFile));
//						StringBuffer buffer = new StringBuffer();
//						String text;
//						while ((text = input.readLine()) != null)
//						buffer.append(text + "\n");
//						input.close();
//						System.out.println(buffer.toString());
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				
//				}
//			}
//		});
		
		
		mntmExit.addMouseListener(new MouseAdapter() {
			// chiude il programma
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
				
		mnWindow = new JMenu("Help");
		mntmHelpTopic = new JMenuItem("Help Topic");
		mntmAbout = new JMenuItem("About");
		
		mntmAbout.addMouseListener(new MouseAdapter() {
			// Show version
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(jframe,
	  					  "\n  VirtualSense DSP Recorder\n\n" + 
						  "  Application Version: " + APPVERSION + "\n\n" +
						  "  Recorder firmware version: " + BOOTIMGVERSION + "          \n\n\n",
						  "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		
		
		menuBar.add(mnWindow);
		mnWindow.add(mntmHelpTopic);
		mnWindow.add(mntmAbout);
	}

	/**
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * @return the mnFile
	 */
	public JMenu getMnFile() {
		return mnFile;
	}

	/**
	 * @param mnFile the mnFile to set
	 */
	public void setMnFile(JMenu mnFile) {
		this.mnFile = mnFile;
	}

	/**
	 * @return the mnWindow
	 */
	public JMenu getMnWindow() {
		return mnWindow;
	}

	/**
	 * @param mnWindow the mnWindow to set
	 */
	public void setMnWindow(JMenu mnWindow) {
		this.mnWindow = mnWindow;
	}

	/**
	 * @return the mntmSave
	 */
	public JMenuItem getMntmSave() {
		return mntmSave;
	}

	/**
	 * @param mntmSave the mntmSave to set
	 */
	public void setMntmSave(JMenuItem mntmSave) {
		this.mntmSave = mntmSave;
	}

	/**
	 * @return the mntmLoad
	 */
	public JMenuItem getMntmLoad() {
		return mntmLoad;
	}

	/**
	 * @param mntmLoad the mntmLoad to set
	 */
	public void setMntmLoad(JMenuItem mntmLoad) {
		this.mntmLoad = mntmLoad;
	}

	/**
	 * @return the mntmExit
	 */
	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	/**
	 * @param mntmExit the mntmExit to set
	 */
	public void setMntmExit(JMenuItem mntmExit) {
		this.mntmExit = mntmExit;
	}

	/**
	 * @return the mntmHelpTopic
	 */
	public JMenuItem getMntmHelpTopic() {
		return mntmHelpTopic;
	}

	/**
	 * @param mntmHelpTopic the mntmHelpTopic to set
	 */
	public void setMntmHelpTopic(JMenuItem mntmHelpTopic) {
		this.mntmHelpTopic = mntmHelpTopic;
	}

	/**
	 * @return the mntmAbout
	 */
	public JMenuItem getMntmAbout() {
		return mntmAbout;
	}

	/**
	 * @param mntmAbout the mntmAbout to set
	 */
	public void setMntmAbout(JMenuItem mntmAbout) {
		this.mntmAbout = mntmAbout;
	}
	/**
	 * @return the mntmSaveAs
	 */
	public JMenuItem getMntmSaveAs() {
		return mntmSaveAs;
	}

	/**
	 * @return the mntmLoadSetFile
	 */
	public JMenuItem getMntmLoadSetFile() {
		return mntmLoadSetFile;
	}

	/**
	 * @param mntmLoadSetFile the mntmLoadSetFile to set
	 */
	public void setMntmLoadSetFile(JMenuItem mntmLoadSetFile) {
		this.mntmLoadSetFile = mntmLoadSetFile;
	}

	/**
	 * @return the mntmNew
	 */
	public JMenuItem getMntmNew() {
		return mntmNew;
	}

	/**
	 * @param mntmNew the mntmNew to set
	 */
	public void setMntmNew(JMenuItem mntmNew) {
		this.mntmNew = mntmNew;
	}

	/**
	 * @param mntmSaveAs the mntmSaveAs to set
	 */
	public void setMntmSaveAs(JMenuItem mntmSaveAs) {
		this.mntmSaveAs = mntmSaveAs;
	}

}
