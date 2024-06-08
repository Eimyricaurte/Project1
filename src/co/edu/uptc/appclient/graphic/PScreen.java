package co.edu.uptc.appclient.graphic;

import javax.swing.JFrame;

public class PScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Chat ch;
	
	public PScreen() {
		this.ch = new Chat();
	}

	public Chat getCh() {
		return ch;
	}

	public void setCh(Chat ch) {
		this.ch = ch;
	}



}
