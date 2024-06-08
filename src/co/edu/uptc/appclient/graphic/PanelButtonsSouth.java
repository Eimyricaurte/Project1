package co.edu.uptc.appclient.graphic;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelButtonsSouth extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton addClient;
	private JButton deleteClient;

	public PanelButtonsSouth() {
		this.buildComponents();
		this.addComponents();
	}

	private void buildComponents() {
		this.addClient = new JButton("Agregar");
		this.deleteClient = new JButton("Eliminar");
		
	}
	
	private void addComponents() {
		this.add(this.addClient);
		this.add(this.deleteClient);
		
	}
}
