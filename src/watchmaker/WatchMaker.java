package watchmaker;

import gui.StartWindow;
import gui.WindowMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.logging.Level;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WatchMaker  extends JPanel{
	
	   	private JButton createTimeFile;
	    private JTextField dayTextField;
	    private JButton getCurrentTimeButton;
	    private JTextField hoursTextField;
	    private JTextField minTextField;
	    private JTextField monthTextField;
	    private JTextField programmingStringTextField1;
	    private JTextField secDateTextField;
	    private JTextField yearTextField;
	


	/**
     * Creates new form DSPProgrammer
     */
    public WatchMaker() {
    	
    	inito();
    }


    private void inito() {
        
        getCurrentTimeButton = new JButton();
        yearTextField = new JTextField();
        monthTextField = new JTextField();
        dayTextField = new JTextField();
        hoursTextField = new JTextField();
        minTextField = new JTextField();
        secDateTextField = new JTextField();
        createTimeFile = new JButton();
        programmingStringTextField1 = new JTextField();



        getCurrentTimeButton.setText("Get current time ");
        getCurrentTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCurrentTimeButtonActionPerformed(evt);
            }
        });

        yearTextField.setText("year");
        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });

        monthTextField.setText("month");
        monthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextFieldActionPerformed(evt);
            }
        });

        dayTextField.setText("day");
        dayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTextFieldActionPerformed(evt);
            }
        });

        hoursTextField.setText("hours");
        hoursTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursTextFieldActionPerformed(evt);
            }
        });

        minTextField.setText("min");
        minTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minTextFieldActionPerformed(evt);
            }
        });

        secDateTextField.setText("sec");
        secDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDateTextFieldActionPerformed(evt);
            }
        });

        createTimeFile.setText("Update recorder datetime");
        createTimeFile.setEnabled(false);
        createTimeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTimeFileActionPerformed(evt);
            }
        });

        GroupLayout grouplayout = new GroupLayout(this);
        grouplayout.setHorizontalGroup(
            grouplayout.createParallelGroup(Alignment.LEADING)
            		.addGroup(grouplayout.createSequentialGroup()
            			.addGap(20)
                        .addComponent(getCurrentTimeButton, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(dayTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(monthTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(yearTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addGap(30)
                        .addComponent(hoursTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(minTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(secDateTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                    .addGroup(grouplayout.createSequentialGroup()
                    	.addGap(20)
                        .addComponent(createTimeFile)
                        .addGap(18)
                        .addComponent(programmingStringTextField1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
        );
        grouplayout.setVerticalGroup(
    		grouplayout.createSequentialGroup()
                .addGap(20)
                .addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(getCurrentTimeButton)
                    .addComponent(dayTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoursTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(minTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(secDateTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(51)
                .addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(createTimeFile)
                    .addComponent(programmingStringTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))

        );
        setLayout(grouplayout);

        

    }

  



    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_yearTextFieldActionPerformed

    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_monthTextFieldActionPerformed

    private void getCurrentTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCurrentTimeButtonActionPerformed
        // TODO add your handling code here:
        getCurrentTime();
    }//GEN-LAST:event_getCurrentTimeButtonActionPerformed

    private void createTimeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTimeFileActionPerformed
        // TODO add your handling code here:        
        saveTimeFile();
    }//GEN-LAST:event_createTimeFileActionPerformed

    private void dayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_dayTextFieldActionPerformed

    private void hoursTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_hoursTextFieldActionPerformed

    private void minTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_minTextFieldActionPerformed

    private void secDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDateTextFieldActionPerformed
        // TODO add your handling code here:
        generateTimeString();
    }//GEN-LAST:event_secDateTextFieldActionPerformed

   
 


   
    
    private void saveTimeFile() {
    	try {
    		JFileChooser chooser = new JFileChooser();
			
	        //chooser.setSelectedFile(new File("scheduler.bin"));
	        chooser.setDialogTitle("Open SD card");
	        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        
	        int returnVal = chooser.showOpenDialog(this);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	        	String currentDir = chooser.getSelectedFile().getAbsolutePath();
	            
            	System.out.println("path boot: " + currentDir);
            	// Check if there are boot.bin or scheduler.bin and remove it
            	File boot = new File(currentDir + "/bootimg.bin");
            	File scheduler = new File(currentDir + "/scheduler.bin");
            	File datetime = new File(currentDir + "/updatetime.bin");
            	
            	System.out.println("file bootimg.bin " + (Files.deleteIfExists(boot.toPath())?"exists and deleted":"do not exists"));
            	System.out.println("file scheduler.bin " + (Files.deleteIfExists(scheduler.toPath())?"exists and deleted":"do not exists"));
        	
            	System.out.println("URI: " + this.getClass().getResource("bootimg.bin"));
            	
            	// Copy bootimg.bin from project folder: /bootimg/bootimg.bin
            	//Files.copy(new File("bootimg/bootimg.bin").toPath(), boot.toPath());
            	Files.copy(this.getClass().getResource("/bootimg.bin").openStream(),
            			   boot.toPath());
            	System.out.println("file bootimg.bin added");
		
            	
                FileOutputStream out = new FileOutputStream(datetime);
                String hexBytes = this.programmingStringTextField1.getText().replaceAll("\\s+","");
                
                for(int i = 0; i < hexBytes.length()-1; i+=2){
                    byte b = Byte.decode("0x"+hexBytes.substring(i, i+2));
                    System.out.println("Parsing: "+hexBytes.substring(i, i+2));
                    out.write(b);
                }
                System.out.println(this.programmingStringTextField1.getText());
                out.flush();
                out.close();
                
                JOptionPane.showMessageDialog(this, 
						  					  "SD card successfully set up!     ",
						  					  "Update datetime", 
						  					  JOptionPane.INFORMATION_MESSAGE);
	        } else {
	        	JOptionPane.showMessageDialog(this, 
					  					  	  "update aborted!  ",
					  					  	  "Update datetime", 
					  					  	  JOptionPane.INFORMATION_MESSAGE);
	        }	
                
        } catch (Exception ex) {
    		java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this,
										  "Error 22. Refer to Log file.     ", 
										  "Error on update datetime",
										  JOptionPane.ERROR_MESSAGE);
			return;
        }
    }

    private void generateTimeString() {
        
        System.out.println("Creating time string");
        String programmingString = "";
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.dayTextField.getText())).toUpperCase());        
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.monthTextField.getText())).toUpperCase());
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.yearTextField.getText())-2000).toUpperCase());
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.hoursTextField.getText())).toUpperCase());
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.minTextField.getText())).toUpperCase());
        programmingString+=swapBytes(String.format("%04X ", Integer.parseInt(this.secDateTextField.getText())).toUpperCase());        
        this.programmingStringTextField1.setText(programmingString);
        
        createTimeFile.setEnabled(true);
    }
    
    
    private String swapBytes(String in) {
        String ret = "";
        ret = ""+in.charAt(2) + in.charAt(3) + in.charAt(0) + in.charAt(1)+in.charAt(4);
        return ret; 
    }

    private void getCurrentTime() {
        Calendar now = Calendar.getInstance();
        
        this.yearTextField.setText(""+now.get(Calendar.YEAR));        
        this.monthTextField.setText(""+(now.get(Calendar.MONTH)+1));        
        this.dayTextField.setText(""+now.get(Calendar.DAY_OF_MONTH));        
        this.hoursTextField.setText(""+now.get(Calendar.HOUR_OF_DAY));        
        this.minTextField.setText(""+now.get(Calendar.MINUTE));        
        this.secDateTextField.setText(""+now.get(Calendar.SECOND));    
        generateTimeString();
    }
    
}
	

