package gui;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Point;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;


public class AciParameters extends JPanel {
	private FftMenu fftMenu;
	private JComboBox comboBoxWindow;
	private JSpinner spinnerNoiseFilter;
	private JSpinner spinnerNoiseFilterH;
	private JSpinner spinnerScaling;
	private JSpinner spinnerClumping;
	private JSpinner spinnerLowFreq;
	/**
	 * Create the panel.
	 */
	public AciParameters() {
		setBorder(new TitledBorder(null, "Aci Setting", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FftMenu fftMenu = new FftMenu();
		fftMenu.setLocation(new Point(100, 100));
		add(fftMenu);
		
		comboBoxWindow = new JComboBox();
		comboBoxWindow.setModel(new DefaultComboBoxModel(new String[] {"512", "1024", "2048"}));
		comboBoxWindow.setSelectedIndex(1);
		comboBoxWindow.setBorder(new TitledBorder(null, "Window", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		spinnerClumping = new JSpinner();
		spinnerClumping.setPreferredSize(new Dimension(72, 46));
		spinnerClumping.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		spinnerClumping.setBorder(new TitledBorder(null, "Clumping", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		spinnerLowFreq = new JSpinner();
		spinnerLowFreq.setModel(new SpinnerNumberModel(0, 0, 100000, 1));
		spinnerLowFreq.setBorder(new TitledBorder(null, "Lowest Frequency", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		spinnerNoiseFilter = new JSpinner();
		spinnerNoiseFilter.setModel(new SpinnerNumberModel(0, 0, 9000000, 1));
		spinnerNoiseFilter.setBorder(new TitledBorder(null, "Noise Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		spinnerNoiseFilterH = new JSpinner();
		spinnerNoiseFilterH.setBorder(new TitledBorder(null, "Noise Filter High", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		spinnerNoiseFilterH.setModel(new SpinnerNumberModel(0, 0, 9000000, 1));
		
		spinnerScaling = new JSpinner();
		spinnerScaling.setBorder(new TitledBorder(null, "Scaling", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		spinnerScaling.setModel(new SpinnerNumberModel(1, 1, 2500, 1));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxWindow, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(fftMenu, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinnerNoiseFilter)
						.addComponent(spinnerNoiseFilterH, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinnerScaling, Alignment.TRAILING)
						.addComponent(spinnerClumping, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spinnerLowFreq, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fftMenu, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerNoiseFilter, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxWindow, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerNoiseFilterH, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerClumping, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(118))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinnerScaling, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerLowFreq, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(182))
		);
		setLayout(groupLayout);
		

	}
	/**
	 * @return the fftMenu
	 */
	public FftMenu getFftMenu() {
		return fftMenu;
	}
	/**
	 * @param fftMenu the fftMenu to set
	 */
	public void setFftMenu(FftMenu fftMenu) {
		this.fftMenu = fftMenu;
	}
	/**
	 * @return the comboBoxWindow
	 */
	public JComboBox getComboBoxWindow() {
		return comboBoxWindow;
	}
	/**
	 * @param comboBoxWindow the comboBoxWindow to set
	 */
	public void setComboBoxWindow(JComboBox comboBoxWindow) {
		this.comboBoxWindow = comboBoxWindow;
	}
	/**
	 * @return the spinnerNoiseFilter
	 */
	public JSpinner getSpinnerNoiseFilter() {
		return spinnerNoiseFilter;
	}
	/**
	 * @param spinnerNoiseFilter the spinnerNoiseFilter to set
	 */
	public void setSpinnerNoiseFilter(JSpinner spinnerNoiseFilter) {
		this.spinnerNoiseFilter = spinnerNoiseFilter;
	}
	/**
	 * @return the spinnerNoiseFilterH
	 */
	public JSpinner getSpinnerNoiseFilterH() {
		return spinnerNoiseFilterH;
	}
	/**
	 * @param spinnerNoiseFilterH the spinnerNoiseFilterH to set
	 */
	public void setSpinnerNoiseFilterH(JSpinner spinnerNoiseFilterH) {
		this.spinnerNoiseFilterH = spinnerNoiseFilterH;
	}
	/**
	 * @return the spinnerScaling
	 */
	public JSpinner getSpinnerScaling() {
		return spinnerScaling;
	}
	/**
	 * @param spinnerScaling the spinnerScaling to set
	 */
	public void setSpinnerScaling(JSpinner spinnerScaling) {
		this.spinnerScaling = spinnerScaling;
	}
	/**
	 * @return the spinnerClumping
	 */
	public JSpinner getSpinnerClumping() {
		return spinnerClumping;
	}
	/**
	 * @param spinnerClumping the spinnerClumping to set
	 */
	public void setSpinnerClumping(JSpinner spinnerClumping) {
		this.spinnerClumping = spinnerClumping;
	}
	/**
	 * @return the spinnerLowFreq
	 */
	public JSpinner getSpinnerLowFreq() {
		return spinnerLowFreq;
	}
	/**
	 * @param spinnerLowFreq the spinnerLowFreq to set
	 */
	public void setSpinnerLowFreq(JSpinner spinnerLowFreq) {
		this.spinnerLowFreq = spinnerLowFreq;
	}
}
