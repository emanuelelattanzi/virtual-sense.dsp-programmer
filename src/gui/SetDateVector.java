package gui;
import java.util.Vector;


public class SetDateVector {
private Vector<SetDate> vector;
	
	SetDateVector(){
		vector = new Vector<SetDate> ();
	}
	
	public boolean insertSetDate(SetDate setDate){
		boolean b = false;
		// x test
		System.out.println(setDate.toString());
		b = vector.add(setDate);
		return b;
	}
	
	public void printAllElements(){
		for(int i = 0; i < vector.size(); i++)
			System.out.println(vector.get(i));
	}

	/**
	 * @return the vector
	 */
	public Vector<SetDate> getVector() {
		return vector;
	}

	/**
	 * @param vector the vector to set
	 */
	public void setVector(Vector<SetDate> vector) {
		this.vector = vector;
	}

}
