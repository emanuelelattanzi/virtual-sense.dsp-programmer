package gui;

import watchmaker.WatchMaker;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MenuTabbed extends JTabbedPane {

	private JScrollPane scrollTimer, scrollAudio, scrollDevice, scrollPower; 
	private JScrollPane	scrollSensors, scrollCapacity, scrollLocation, scrollWatchMaker;
	private TimerMenu timerMenu;
	private AudioMenu audioMenu;
	private DeviceMenu deviceMenu;
	private LocationMenu locationMenu;
	private SensorsMenu sensorsMenu;
	private CapacityMenu capacityMenu;
	private PowerMenu powerMenu;
	private SunTime[] sunTime;
	
	private WatchMaker watchMakerMenu;
	
	
	/**
	 * Create the panel.
	 */
	public MenuTabbed(WindowMenu wm) {
		
		timerMenu = new TimerMenu(wm);
		scrollTimer = new JScrollPane(timerMenu);
		addTab("Rec Mode", scrollTimer);
		setSelectedIndex(0);
		
		inizialize();
		
		}
	
	public MenuTabbed(SunTime[] sunTime) {
		this.sunTime = sunTime;
		inizialize();
		
		}
	
		private void inizialize(){
		
			
			audioMenu = new AudioMenu(); 
			scrollAudio = new JScrollPane(audioMenu);
			addTab("Audio", scrollAudio);
			timerMenu.setAudioMenu(audioMenu);
			
			deviceMenu = new DeviceMenu();
			scrollDevice = new JScrollPane(deviceMenu);
			addTab("Device", scrollDevice);
			
			locationMenu = new LocationMenu();
			scrollLocation = new JScrollPane(locationMenu);
			addTab("Location",scrollLocation);
			
			capacityMenu = new CapacityMenu();
			scrollCapacity = new JScrollPane(capacityMenu);
			addTab("Capacity", scrollCapacity);
			
			powerMenu = new PowerMenu();
			scrollPower = new JScrollPane(powerMenu);
			add("Power", scrollPower);
			
			sensorsMenu = new SensorsMenu();
			scrollSensors = new JScrollPane(sensorsMenu);
			addTab("Sensors", scrollSensors);
			
			watchMakerMenu = new WatchMaker();
			scrollWatchMaker = new JScrollPane(watchMakerMenu);
			addTab("Watch Maker", scrollWatchMaker);
						
		}
		
		public String[] getSetting(){
			int n, i;
			String[] s = new String [100];
			
			i = 0;
			
//			device setting
			//for(n = 0; n < deviceMenu.getSetting().length; n++)
				//s [i++] = deviceMenu.getSetting()[n];
//			audio setting
			for(n = 0; n < audioMenu.getSetting().length; n++)
				s[i++] = audioMenu.getSetting()[n];
//			coordinates setting
			for(n = 0; n < locationMenu.getCoordinatesMenu().getSetting().length; n++)
				s[i++] = locationMenu.getCoordinatesMenu().getSetting()[n];
//			UTC setting
			for(n = 0; n < locationMenu.getTimeZoneMenu().getSetting().length; n++)
				s[i++] = locationMenu.getTimeZoneMenu().getSetting()[n];
//			zenith setting
			s[i++] = locationMenu.getZenithMenu().getSetting();
			
			return s;
		}

		
		/**
		 * @return the timerMenu
		 */
		public TimerMenu getTimerMenu() {
			return timerMenu;
		}

		/**
		 * @param timerMenu the timerMenu to set
		 */
		public void setTimerMenu(TimerMenu timerMenu) {
			this.timerMenu = timerMenu;
		}

		/**
		 * @return the audioMenu
		 */
		public AudioMenu getAudioMenu() {
			return audioMenu;
		}

		/**
		 * @param audioMenu the audioMenu to set
		 */
		public void setAudioMenu(AudioMenu audioMenu) {
			this.audioMenu = audioMenu;
		}

		/**
		 * @return the deviceMenu
		 */
		public DeviceMenu getDeviceMenu() {
			return deviceMenu;
		}

		/**
		 * @param deviceMenu the deviceMenu to set
		 */
		public void setDeviceMenu(DeviceMenu deviceMenu) {
			this.deviceMenu = deviceMenu;
		}

		/**
		 * @return the locationMenu
		 */
		public LocationMenu getLocationMenu() {
			return locationMenu;
		}

		/**
		 * @param locationMenu the locationMenu to set
		 */
		public void setLocationMenu(LocationMenu locationMenu) {
			this.locationMenu = locationMenu;
		}
		
//		gestire il caso non vada a buon fine
		
		public boolean setLoadSetting(String[] s){
			boolean bol = true;
			//deviceMenu.setSetting(s);
//			String token [] = setting.split(" ");
//			deviceMenu.getIdMenu().setSelectedItem(token[0]);
//			audioMenu.getFckMenu().setSelectedItem(token[1]);
////			audioMenu.getFftMenu().setSelectedItem(token[2]);
//			locationMenu.getTimeZoneMenu().getComboBoxHour().setSelectedItem(token[3]);
//			locationMenu.getTimeZoneMenu().getComboBoxMinute().setSelectedItem(token[4]);
//			locationMenu.getZenithMenu().getComboBoxZen().setSelectedItem(token[5]);
//			locationMenu.getCoordinatesMenu().getTxtLatitude().setText(token[6]);
//			locationMenu.getCoordinatesMenu().getTxtLongitude().setText(token[7]);
//			x test
//			System.out.println("Token: ");
//			 for (int i = 0; i < token.length; i++)
//			System.out.println(token[i]);
			
			return bol;
		}

		/**
		 * @return the sunTime
		 */
		public SunTime[] getSunTime() {
			return sunTime;
		}

		/**
		 * @param sunTime the sunTime to set
		 */
		public void setSunTime(SunTime[] sunTime) {
			this.sunTime = sunTime;
			this.timerMenu.setSunTime(sunTime);
		}
			
}
