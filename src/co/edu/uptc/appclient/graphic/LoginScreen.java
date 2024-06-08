package co.edu.uptc.appclient.graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel nameUser;
	private JLabel password;
	private JTextField name;
	private JPasswordField pass;
	private JButton bLogin;
	
	public LoginScreen() {
		this.configureScreen();
		this.buildComponenets();
		this.addComponents();
		
	}
	
	private void configureScreen() {
		setTitle("Login");
		setSize(600, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
	}
	
	private void buildComponenets() {
		this.nameUser = new JLabel("Nombre de cliente");
		this.password = new JLabel("Contraseña");
		this.name = new JTextField();
		this.pass = new JPasswordField();
		this.bLogin = new JButton("Ingresar");
	}
	
	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.nameUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.name, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.password, gbc);
	}

}
