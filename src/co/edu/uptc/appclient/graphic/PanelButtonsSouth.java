package co.edu.uptc.appclient.graphic;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.appclient.persistence.ManagementEvents;

public class PanelButtonsSouth extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ManagementEvents me;
	
	private JButton addClient;
	private JButton deleteClient;

	public PanelButtonsSouth(PrincipalScreen ps) {
	    this.me = new ManagementEvents(ps);
	    this.buildComponents();
	    this.addComponents();
	}

	private void buildComponents() {
		this.addClient = new JButton("Agregar");
		this.deleteClient = new JButton("Eliminar");
		
	}
	
	private void addComponents() {
		this.addClient.setActionCommand(me.ADD_CLIENT);
		this.addClient.addActionListener(me);
		
		this.add(this.addClient);
		this.add(this.deleteClient);
		
	}
}
