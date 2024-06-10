package co.edu.uptc.appclient.graphic;

import javax.swing.JFrame;

public class PScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AddClient ac;
	private AddService as;
	
	public PScreen() {
		this.ac = new AddClient(this);
		this.as = new AddService(this);
	}

	public AddService getAs() {
		return as;
	}

	public void setAs(AddService as) {
		this.as = as;
	}

	public AddClient getAc() {
		return ac;
	}

	public void setAc(AddClient ac) {
		this.ac = ac;
	}



}
