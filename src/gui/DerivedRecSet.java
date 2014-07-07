package gui;

public class DerivedRecSet {
	private MyTime start, stop; 
	private long id;
	
	public DerivedRecSet(long id, MyTime start, MyTime stop){
		this.id = id;
		this.start = start;
		this.stop = stop;
	}
	
	public String toString(){
		return(this.start.toString() + " " + this.stop.toString()+" id: "+ id);
	}

	/**
	 * @return the start
	 */
	public MyTime getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(MyTime start) {
		this.start = start;
	}

	/**
	 * @return the stop
	 */
	public MyTime getStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	public void setStop(MyTime stop) {
		this.stop = stop;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
