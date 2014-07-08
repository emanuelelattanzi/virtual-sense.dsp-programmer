package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

import record.Record;
import record.RecordSession;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.awt.BorderLayout;



public class StartWindow {
	
	private SunTime[] sT;
	private JFrame frmLcrSetup;
	MenuTabbed menuTabbed;
	WindowMenu windowMenu;
	
	double zenith, timeZone, defaultLongitude, defaultLatitude;
	CalculateSunTime sunTime;
	TableScroll tableScroll; 
	JSplitPane splitPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("VirtualSense DSP Programmer version: " + WindowMenu.APPVERSION + " (firmware version: " + WindowMenu.BOOTIMGVERSION + ")");
		System.out.println("For use external bootimg.bin, create file named 'boot.path' in the same folder of jar file.\nThis file must be contain only the absolute path of file.");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
					window.frmLcrSetup.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		defaultLongitude = 0;//12.4825199; 
		defaultLatitude =  0;//41.8929163;
		
		frmLcrSetup = new JFrame();
		frmLcrSetup.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmLcrSetup.getContentPane().setBackground(Color.WHITE);
		frmLcrSetup.setBackground(Color.WHITE);
		frmLcrSetup.setForeground(Color.BLACK);
		frmLcrSetup.setTitle("VirtualSense DSP-Programmer");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
				
		frmLcrSetup.setBounds(0, 0, d.width-80, d.height-50);
		frmLcrSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//insert menu
		windowMenu = new WindowMenu(frmLcrSetup);
		frmLcrSetup.getContentPane().setLayout(new BorderLayout(0, 0));
		
//		splitPane.add(menuTabbed);
		//insert tabbeb		
//		frmLcrSetup.add(menuTabbed);
			
		// run 1 time for default
		// take default value
		menuTabbed = new MenuTabbed(windowMenu);
		
		zenith = menuTabbed.getLocationMenu().getZenithMenu().getSelectedValue();
		timeZone = menuTabbed.getLocationMenu().getTimeZoneMenu().getSelectedValue();
		
		// da rimuovere usato solo x test
		System.out.println(zenith+" "+timeZone);
		
//		41.8929163, 12.4825199
		sunTime = new CalculateSunTime(defaultLongitude, defaultLatitude, zenith, timeZone);
		sT = sunTime.calculateSun();
		tableScroll = new TableScroll(sT);
		menuTabbed.setSunTime(sT);
		tableScroll.setMinimumSize(new Dimension(0, 0));
		menuTabbed.setMinimumSize(new Dimension(0, 0));
		
		menuTabbed.getTimerMenu().setTableScroll(tableScroll);
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, menuTabbed, tableScroll);
		splitPane.setPreferredSize(frmLcrSetup.getSize());
		splitPane.setDividerLocation(0.5);
//		for same size
		splitPane.setResizeWeight(0.5);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
		
//		splitPane.setDividerLocation(600);
		frmLcrSetup.getContentPane().add(splitPane);
		
//		splitPane.add(tableScroll);
		
//		frmLcrSetup.add(tableScroll);
	
		
		// x test variabile statica
		menuTabbed.getSetting();
			
		
		menuTabbed.getLocationMenu().getBtnCalculate().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				splitPane.remove(tableScroll);
				zenith = menuTabbed.getLocationMenu().getZenithMenu().getSelectedValue();
				timeZone = menuTabbed.getLocationMenu().getTimeZoneMenu().getSelectedValue();
				Coordinates cord = new Coordinates();
				cord.setLatitudeDD(menuTabbed.getLocationMenu().getCoordinatesMenu().getCoordinates().getLatitudeDD());
				cord.setLongitudeDD(menuTabbed.getLocationMenu().getCoordinatesMenu().getCoordinates().getLongitudeDD());
				sunTime = new CalculateSunTime(cord.getLongitudeDD(), cord.getLatitudeDD(), zenith, timeZone);
				System.out.println(cord.getLatitudeDD()+" "+cord.getLongitudeDD()+" "+zenith+" "+timeZone);
				sT = sunTime.calculateSun();
				tableScroll = new TableScroll(sT);
				menuTabbed.setSunTime(sT);
				splitPane.add(tableScroll);
				tableScroll.repaint();
				tableScroll.revalidate();
//				update table's colors
//				tableScroll.getTable().updatecolorTable(sT);
//				menuTabbed.getTimerMenu().updateColorTable();
				
				
			}
		});

//		save the setting
		windowMenu.getMntmSave().addMouseListener(new MouseAdapter() {
			// open save window
			@Override
			public void mousePressed(MouseEvent ev) {
				JFileChooser chooserSave = new JFileChooser();
				//chooserSave.setFileFilter(new LcrFileFilter());

				int returnF = chooserSave.showSaveDialog(frmLcrSetup); 
				if (returnF == JFileChooser.APPROVE_OPTION){
					//File newFile = chooserSave.getSelectedFile();
					String path = chooserSave.getSelectedFile().getAbsolutePath();
					//File lcrFile = chooserSave.getSelectedFile();
					File newFile = null;
					try {
						System.out.println("abs path: " + path);
						System.out.println("sep: " + File.separatorChar);
						
						newFile = new File(path + ".txt");
						newFile.createNewFile();
						//lcrFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// compile file
					PrintStream setStream;
					try {
						setStream = new PrintStream(newFile);
						ArrayList<RecordSession> sessions = menuTabbed.getTimerMenu().getSessions();
						
						for(int i=0; i<sessions.size(); i++) {
							String[] ses = sessions.get(i).toStrings();
							setStream.println("--- sessions[" + i + "] ---");
							
							for(int j=0; j<ses.length; j++) {
								setStream.println(ses[j].replace(' ', '\t'));
							}
							
							setStream.println("\n");
							
							setStream.flush();		
						}
						
						
						setStream.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		});	
				
				/*
					JFileChooser chooserSave = new JFileChooser();
					chooserSave.setFileFilter(new SetFileFilter());
					
					int returnF = chooserSave.showSaveDialog(frmLcrSetup); 
					if (returnF == JFileChooser.APPROVE_OPTION){
						File newFile = chooserSave.getSelectedFile();
						try {
							newFile.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// compile file
						PrintStream scrivi;
						try {
							scrivi = new PrintStream(newFile + ".set");
//							insert here the setting's string
							for(int n = 0; n < menuTabbed.getSetting().length; n++)
								scrivi.println(menuTabbed.getSetting()[n]);
							scrivi.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});*/
		
//		export setting file
		windowMenu.getMntmSaveAs().addMouseListener(new MouseAdapter() {
			// open save window
			@Override
			public void mousePressed(MouseEvent evs) {
				int recorderId = menuTabbed.getDeviceMenu().getCurrentId();
				int numDevice = menuTabbed.getDeviceMenu().getNumberDev();
				boolean nextDev = false;
				
				try {
					System.out.println("URI sd: " + this.getClass().getResource("/sd.png"));
					
					JOptionPane.showMessageDialog(frmLcrSetup,
							  					  "\n  INFO\n  For configure VirtualSense DSP recorder:\n\n" + 
					  							  "  - Insert please the recorder SD card on PC and click OK.             \n" +
					  							  "  - Select the path of SD card to be configured on\n    directory chooser.\n\n" +
					  							  "  The selected SD card will be set up with current recording\n  session.\n\n\n",
					  							  "Configure recorder:", JOptionPane.INFORMATION_MESSAGE,
					  							  //new ImageIcon("img/sd.png"));
					  							  new ImageIcon(this.getClass().getResource("/sd.png")));
					
					// For each recorder selected
					do {
						JFileChooser chooser = new JFileChooser();
						
				        //chooser.setSelectedFile(new File("scheduler.bin"));
				        chooser.setDialogTitle("Open SD card (recorder ID: " + recorderId + ")");
				        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				        
				        int returnVal = chooser.showOpenDialog(frmLcrSetup);
				        if(returnVal == JFileChooser.APPROVE_OPTION) {
				        	String currentDir = chooser.getSelectedFile().getAbsolutePath();
				            try {
				            	System.out.println("path boot: " + currentDir);
				            	// Check if there are boot.bin or scheduler.bin and remove it
				            	File boot = new File(currentDir + "/bootimg.bin");
				            	File scheduler = new File(currentDir + "/scheduler.bin");
				            	File datetime = new File(currentDir + "/updatetime.bin");
				            	System.out.println("file bootimg.bin " + (Files.deleteIfExists(boot.toPath())?"exists and deleted":"do not exists"));
				            	System.out.println("file scheduler.bin " + (Files.deleteIfExists(scheduler.toPath())?"exists and deleted":"do not exists"));
				            	System.out.println("file updatetime.bin " + (Files.deleteIfExists(datetime.toPath())?"exists and deleted":"do not exists"));
				            	
				            	/*System.out.println("URI: " + this.getClass().getResource("/bootimg.bin"));
				            	
				            	// Copy bootimg.bin from project folder: /bootimg/bootimg.bin
				            	//Files.copy(new File("bootimg/bootimg.bin").toPath(), boot.toPath());
				            	Files.copy(this.getClass().getResource("/bootimg.bin").openStream(),
				            			   boot.toPath());
				            	System.out.println("file bootimg.bin added");*/
				            	
				            	// Check if exist boot.pat
				            	Files.copy(getBootStream(),
				            			   boot.toPath());
				            	System.out.println("file bootimg.bin added");		
				            	
				                FileOutputStream out = new FileOutputStream(scheduler);
				                
				                // write program counter and id
				                String head = "";
				                head+=Record.swapBytes(String.format("%04X ", 1).toUpperCase());			// Program counter
				                head+=Record.swapBytes(String.format("%04X ", recorderId).toUpperCase());	// Device id
				                
				                System.out.println("Start write hex file! (head: " + head + ")");
				                String hexhead = head.replaceAll("\\s+","");
					            // Write bites on file
								for(int t = 0; t < hexhead.length()-1; t+=2){
				                    byte b = Byte.decode("0x"+hexhead.substring(t, t+2));
				                    System.out.println("Parsing: "+hexhead.substring(t, t+2));
				                    out.write(b);
					            }
					            out.flush();
				                
				                // Get record sessions
			                	ArrayList<RecordSession> sessions = menuTabbed.getTimerMenu().getSessions();
								
			                	// get hexadecimal format of each session of sessions
								for(int i=0; i<sessions.size(); i++) {
									String[] hexSes = sessions.get(i).toHexStrings();
									System.out.println("Record session: " + i + " (" + sessions.size() + ")");
									
									// For each reord of this session
									for(int j=0; j<hexSes.length; j++) {
										
										System.out.println("String[" + j + "] " + hexSes[j]);
										String hexBytes = hexSes[j].replaceAll("\\s+","");
										
										// Write bites on file
										for(int y = 0; y < hexBytes.length()-1; y+=2){
						                    byte b = Byte.decode("0x"+hexBytes.substring(y, y+2));
						                    System.out.println("Parsing: "+hexBytes.substring(y, y+2));
						                    out.write(b);
						                }
						                out.flush();
									}
									System.out.println("\n");
								}
				                out.close();
			            	} catch (FileNotFoundException ex) {
			            		java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     				JOptionPane.showMessageDialog(frmLcrSetup,
			     											  "Error 19. Refer to Log file.     ", 
			     											  "Error on setup SD card",
			     											  JOptionPane.ERROR_MESSAGE);
			     				return;
			     				
				            } catch (IOException exx) {
				            	java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, exx);
			     				JOptionPane.showMessageDialog(frmLcrSetup,
										  "Error 20. Refer to Log file.     ", 
										  "Error on setup SD card",
										  JOptionPane.ERROR_MESSAGE);
			     				return;
				            }
				            
				            // Check if there are many recorder to be setup
					        if(numDevice > 1) {
					        	
					        	int n = JOptionPane.showConfirmDialog(frmLcrSetup,
					        										  "\nSD card successfully set up! (recorder ID: " + recorderId + ")\n \nOn current session the number of device to be setup is greater than one.     \n\nDo you want setup the next one (recorder ID: " + (recorderId+1) + ")?\n",
					        										  "Configure recorder",
					        										  JOptionPane.YES_NO_OPTION);
					        	if(n == 0) {
					        		nextDev = true;
					        		recorderId++;
					        		numDevice--;
					        	}
					        	else
					        		nextDev = false;
					        } else {
					        	nextDev = false;
					        	JOptionPane.showMessageDialog(frmLcrSetup, 
					        								  "SD card successfully set up! (recorder ID: " + recorderId + ")     ",
					        								  "Configure recorder", 
					        								  JOptionPane.INFORMATION_MESSAGE);
					        }
				        } else {
				        	JOptionPane.showMessageDialog(frmLcrSetup, 
									  					  "Set up aborted!  ",
									  					  "Configure recorder", 
									  					  JOptionPane.INFORMATION_MESSAGE);
				        }		        
					} while(nextDev);
					
				}catch (NullPointerException exxx) {
	            	java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, exxx);
     				JOptionPane.showMessageDialog(frmLcrSetup,
							  "Error 21. Refer to Log file.     ", 
							  "Error on setup SD card",
							  JOptionPane.ERROR_MESSAGE);
     				return;
				}
			}       
		});
					/*JFileChooser chooserSave = new JFileChooser();
					//chooserSave.setFileFilter(new LcrFileFilter());

					int returnF = chooserSave.showSaveDialog(frmLcrSetup); 
					if (returnF == JFileChooser.APPROVE_OPTION){
						File newFile = chooserSave.getSelectedFile();
						//File lcrFile = chooserSave.getSelectedFile();
						try {
							newFile.createNewFile();
							//lcrFile.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// compile file
						PrintStream setStream;
						try {
							setStream = new PrintStream(newFile + ".txt");
							lcrStream = new PrintStream(lcrFile + ".lcr");
							
							
							
//							insert here the setting's string
							

//								
//								string = new String("0:00" + ((recArray.size() > 0) ? recArray.get(0).getStart().toString() : "END"));
//								
//								for(int index = 0; index < recArray.size(); index++){
//									string[index]= new String( (recArray.get(index).getStop().getTotalMinutes()-recArray.get(index).getStart().getTotalMinutes()) 
//											+ (((index+1) < recArray.size()) ? recArray.get(index+1).getStart().toString() : "END"));
//								}
//								return string;
//							}
							
//							scrivi.println("0:00" 
//							+ ((menuTabbed.getTimerMenu().getDerArray().getRecArray().size() > 0) ?
//									menuTabbed.getTimerMenu().getDerArray().getRecArray().get(0).getStart().toString()
//									: "END"));
							for(int i = 0; i < menuTabbed.getTimerMenu().getLogArray().size(); i++)
								lcrStream.println(menuTabbed.getTimerMenu().getLogArray().get(i).stringForFile());
							lcrStream.close();
							
							for(int i = 0; i < menuTabbed.getTimerMenu().getDerArray().stringForFile().length; i++)
								setStream.println(menuTabbed.getTimerMenu().getDerArray().stringForFile()[i]);
							
							setStream.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});*/
		
		
//		load setting file
		windowMenu.getMntmLoad().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser chooserLoad = new JFileChooser();
				chooserLoad.setFileFilter(new SetFileFilter());
				String[] settingLoad = null;
				
				int returnF = chooserLoad.showOpenDialog(frmLcrSetup);
				if (returnF == JFileChooser.APPROVE_OPTION){
					File readFile = chooserLoad.getSelectedFile();
					BufferedReader input;
					
					try {
						input = new BufferedReader(new FileReader(readFile));
						StringBuffer buffer = new StringBuffer();
						String text;
						while ((text = input.readLine()) != null)
							buffer.append(text + "\n");
						input.close();
//						sistemare lunghezza
						settingLoad = new String[100];
						settingLoad = buffer.toString().split("\n");
						for(int i = 0; i < settingLoad.length;i++)
							System.out.println(settingLoad[i]);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					menuTabbed.setLoadSetting(settingLoad);
				
				}
			}
		});
		
//		load setting file
		windowMenu.getMntmLoadSetFile().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser chooserLoad = new JFileChooser();
				chooserLoad.setFileFilter(new LcrFileFilter());

				int returnF = chooserLoad.showOpenDialog(frmLcrSetup);
				if (returnF == JFileChooser.APPROVE_OPTION){
					File readFile = chooserLoad.getSelectedFile();
					BufferedReader input;
					try {
						
						System.out.println("giorno sunrise: "+sT[0].day+" " + sT[0].month+" "+sT[0].year);
						menuTabbed.getTimerMenu().getDerArray().setSunTime(sT);
						
						input = new BufferedReader(new FileReader(readFile));
						StringBuffer buffer = new StringBuffer();
						String text;
						while ((text = input.readLine()) != null){
							buffer.append(text + "\n");
							String[] string = text.split("\t");
							
							String[] stringStart = string[1].split("-"); 
							String[] stringStop = string[2].split("-");
							String[] stringRec = string[3].split(":");
							String[] stringEnd = string[4].split(":");
							
						
							LogRecSet logRec = new LogRecSet(Integer.parseInt(string[0]),
									new MyDate(Integer.parseInt(stringStart[0]), Integer.parseInt(stringStart[1]), Integer.parseInt(stringStart[2])),
									new MyDate(Integer.parseInt(stringStop[0]), Integer.parseInt(stringStop[1]), Integer.parseInt(stringStop[2])),
									string[5],
									new MyHour(Integer.parseInt(stringRec[0]), Integer.parseInt(stringRec[1]),Integer.parseInt(stringRec[2])),
									string[6],
									new MyHour(Integer.parseInt(stringEnd[0]), Integer.parseInt(stringEnd[1]),Integer.parseInt(stringEnd[2])),
									Integer.parseInt(string[7]));
							System.out.println("logrec: " + logRec);
							boolean b = menuTabbed.getTimerMenu().getDerArray().addRec(logRec);
							System.out.println("Valore bool: " + b);
							menuTabbed.getTimerMenu().getDerArray().printAll();
						if(b){	
							menuTabbed.getTimerMenu().getLogArray().add(logRec);
							for(int index = 0; index < menuTabbed.getTimerMenu().getLogArray().size(); index++){
								System.out.println("Contenuto array: " + menuTabbed.getTimerMenu().getLogArray().get(index));
								menuTabbed.getTimerMenu().getLogArea().add(menuTabbed.getTimerMenu().getLogArray().get(index).getPanelLogRec());
								menuTabbed.getTimerMenu().getLogArea().repaint();
								menuTabbed.getTimerMenu().getLogArea().revalidate();
							}
						}
						}
						input.close();
//						update table's colors
						tableScroll.getTable().updatecolorTable(sT);
						menuTabbed.getTimerMenu().updateColorTable();
//						settingLoad = buffer.toString();
//						System.out.println(settingLoad);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		
//		new record setting
		windowMenu.getMntmNew().addMouseListener(new MouseAdapter() {
			// reset all
			@Override
			public void mousePressed(MouseEvent ev) {
				
				menuTabbed.getTimerMenu().setDerArray(new DerivedRecSetArray());
				menuTabbed.getTimerMenu().setLogArray(new ArrayList<LogRecSet>());
				tableScroll.getTable().updatecolorTable(sT);
				menuTabbed.getTimerMenu().updateColorTable();
			}
		});
		
		
//		x test getSetting
//		for(int i = 0; i < menuTabbed.getSetting().length; i++)
//			System.out.println(menuTabbed.getSetting()[i]);
		
//		menuTabbed.getAudioMenu().getFckMenu().setSelectedItem("96000");
	
		
//		menuTabbed.timerMenu.btnAddRec.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("Tasto premuto eccezione catturata dal main");
//			}
//		}
		
		
		// x test
//		MyTime time = new MyTime();
//		System.out.println(time.getCurrentDateTimeForFile());*/
//		SettingFileTxt settingFile = new SettingFileTxt();
//		settingFile.saveSettingFile("setting.txt", menuTabbed.getSetting());
//		
		
		// x test
		
//		longitude = 12.4825199;
//		latitude = 41.8929163;
//		zenith = 90.83333;
	
	}
	
	 private class LcrFileFilter extends FileFilter {

		    public boolean accept(File file) {
		      if (file.isDirectory()) return true;
		        String fname = file.getName().toLowerCase();
		        return fname.endsWith("lcr");
		    }

		    public String getDescription() {
		      return "Rec file";
		    }
		  }
	 
	 private class SetFileFilter extends FileFilter {

		    public boolean accept(File file) {
		      if (file.isDirectory()) 
		    	  return true;
		        String fname = file.getName().toLowerCase();
		        return fname.endsWith("set");
		    }

		    public String getDescription() {
		      return "Setting file";
		    }
		  		 
	 }
	 
	 private InputStream getBootStream() throws IOException
	 {
		 File pathBoot = new File("boot.path");
		 System.out.println("Search boot.path on: " + pathBoot.getAbsolutePath());
		 
		 InputStream retStream = null;
		 
		 if(pathBoot.exists()) {
			 
			 BufferedReader reader = new BufferedReader(new FileReader(pathBoot));
		     
		     File boot = new File(reader.readLine());
		     if(boot.isFile())
		     {
		    	 System.out.println("External boot path exist and is a file!");
		    	 System.out.println("URI bootimg.bin: " + boot.getAbsolutePath());
		    	 retStream = (InputStream)(new FileInputStream(boot));
		     }
		 }
		 
		 if(retStream == null) {
			 System.out.println("External boot path do not exist! use bootimg on jar file.");
			 System.out.println("URI bootimg.bin: " + this.getClass().getResource("/bootimg.bin"));
			 
			 retStream = this.getClass().getResource("/bootimg.bin").openStream();
		 }
			 
		 return retStream;
	 }
	 
	 
}