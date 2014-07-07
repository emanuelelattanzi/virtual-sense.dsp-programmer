package gui;
import java.util.Vector;


public class SettingDateVector {
	private Vector<SettingDate> vector;
	
	SettingDateVector(){
		vector = new Vector<SettingDate> ();
	}
	
	public boolean insertSettingDate(SettingDate settingDate){
		boolean b = false;
		// x test
		System.out.println(settingDate.toString());
		b = vector.add(settingDate);
		return b;
	}
	
	public void printAllElements(){
		for(int i = 0; i < vector.size(); i++)
			System.out.println(vector.get(i));
	}

	/**
	 * @return the vector
	 */
	public Vector<SettingDate> getVector() {
		return vector;
	}

	/**
	 * @param vector the vector to set
	 */
	public void setVector(Vector<SettingDate> vector) {
		this.vector = vector;
	}
}
