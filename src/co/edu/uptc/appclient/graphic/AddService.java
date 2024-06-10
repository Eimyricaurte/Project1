package co.edu.uptc.appclient.graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.uptc.appclient.persistence.ManagementEventsPS;

public class AddService extends JFrame {
	
	private ManagementEventsPS meps;
	
	private AddClient addClient;

	private static final long serialVersionUID = 1L;
	private JScrollPane area;
	private JLabel idClient;
	public JTextField iIdClient;
	private JLabel id;
	public JTextField iId;
	private JLabel name;
	public JTextField iName;
	private JLabel price;
	public JTextField iPrice;
	private JButton cancel;
	private JButton send;
	
	public AddService(PScreen psc) {
		this.configureScreen();
		this.buildComponenets(psc);
		this.addComponents();
		
	}
	
	private void configureScreen() {
		setTitle("Login");
		setSize(900, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
	}
	
	private void buildComponenets(PScreen psc) {
		this.area = new JScrollPane();
		this.idClient = new JLabel("Id del cliente");
		this.iIdClient = new JTextField();
		this.id = new JLabel("Id");
		this.iId = new JTextField();
		this.name = new JLabel("Nombre");
		this.iName = new JTextField();
		this.price = new JLabel("Precio");
		this.iPrice = new JTextField();
		this.cancel = new JButton("Cancelar");
		this.send = new JButton("Agregar");
		
		this.meps = new ManagementEventsPS(psc, addClient, this);
	}
	
	private void addComponents() {
		
		this.send.setActionCommand(meps.ADD_SERVICE);
		this.send.addActionListener(meps);
		
		this.cancel.setActionCommand(meps.CANCEL);
		this.cancel.addActionListener(meps);
		
		this.add(area);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.idClient, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.iIdClient, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.id, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(this.iId, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.name, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.iName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.price, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(this.iPrice, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(this.cancel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.add(this.send, gbc);
	}

}
