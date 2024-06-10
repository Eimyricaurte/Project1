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

import co.edu.uptc.appclient.persistence.ManagementEvents;
import co.edu.uptc.appclient.persistence.ManagementEventsPS;

public class AddClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ManagementEventsPS meps;
	private AddService as;
	
	private JScrollPane area;
	private JLabel id;
	public JTextField iId;
	private JLabel name;
	public JTextField iName;
	private JLabel sDate;
	public JTextField iSDate;
	private JLabel phone;
	public JTextField iPhone;
	private JLabel email;
	public JTextField iEmail;
	private JButton cancel;
	private JButton send;

	public AddClient(PScreen psc) {
		this.configureScreen();
		this.buildComponenets(psc);
		this.addComponents();
	}
	
	private void configureScreen() {
		setTitle("add");
		setSize(900, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
	}
	
	private void buildComponenets(PScreen psc) {
		this.area = new JScrollPane();
		this.id = new JLabel("Id");
		this.iId = new JTextField();
		this.name = new JLabel("Nombre");
		this.iName = new JTextField();
		this.sDate = new JLabel("Fecha de suscripcion");
		this.iSDate = new JTextField();
		this.phone = new JLabel("Numero de telefono");
		this.iPhone = new JTextField();
		this.email = new JLabel("Correo electronico");
		this.iEmail = new JTextField();
		this.cancel = new JButton("Cancelar");
		this.send = new JButton("Agregar");
		this.meps = new ManagementEventsPS(psc, this,as );
	}
	
	private void addComponents() {
		this.add(area);
		
		this.send.setActionCommand(meps.ADD_CLIENT);
		this.send.addActionListener(meps);
		
		this.cancel.setActionCommand(meps.CANCEL);
		this.cancel.addActionListener(meps);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		    
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.id, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.iId, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.name, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(this.iName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.sDate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.iSDate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.phone, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(this.iPhone, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(this.email, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(this.iEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(this.cancel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(this.send, gbc);
	}
}