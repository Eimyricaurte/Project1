package co.edu.uptc.appclient.graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane area;
	private JTextArea txtArea;
	private JTextField txtInput;
	private JButton send;

	public Chat() {
		this.configureScreen();
		this.buildComponenets();
		this.addComponents();
	}
	
	private void configureScreen() {
		setTitle("add");
		setSize(600, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
	}
	
	private void buildComponenets() {
		this.area = new JScrollPane();
		this.txtArea = new JTextArea("Nombre");
		
	}
	
	private void addComponents() {
		
	}
}
