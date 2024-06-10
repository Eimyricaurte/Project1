package co.edu.uptc.appclient.graphic;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import co.edu.uptc.appclient.persistence.ManagementEvents;

public class JMenuExtensions extends JMenuBar {

	private static final long SerialVersionUID = 1L;
	private JMenu menuUser;
	private JMenuItem menuItemAddUser;
	private JMenuItem menuItemDeleteUser;
	
	private JMenu menuService;
	private JMenuItem menuItemAddService;
	private JMenuItem menuItemDeleteservice;
	
	private JMenu loadData;
	private JMenuItem client;
	private JMenuItem service;
	
	private JMenu menuLoadData;
	private JMenuItem client1;
	private JMenuItem service1;
	
	private JMenu csvData;
	private JMenuItem client2;
	private JMenuItem service2;
	
	private JMenu jsonData;
	private JMenuItem client3;
	private JMenuItem service3;
	
	private JMenu serData;
	private JMenuItem client4;
	private JMenuItem service4;
	
	private JMenu xmlData;
	
	
	private ManagementEvents me;
	
	
	
	public JMenuExtensions(PrincipalScreen ps) {
		this.buildComponents(ps);
		this.addComponents();
	}



	public void buildComponents(PrincipalScreen ps) {
		this.menuUser = new JMenu("Clientes");
		this.menuItemAddUser = new JMenuItem("Agregar cliente");
		this.menuItemDeleteUser = new JMenuItem("Eliminar cliente");
		
		this.menuService = new JMenu("Servicios");
		this.menuItemAddService = new JMenuItem("Agregar servicio");
		this.menuItemDeleteservice = new JMenuItem("Eliminar servicio");
		
		this.loadData = new JMenu("Cargar info.");
		this.menuLoadData = new JMenu("Archivo plano");
		this.csvData = new JMenu("CSV");
		this.jsonData = new JMenu("JSON");
		this.serData = new JMenu("Serializate");
		this.xmlData = new JMenu("XML");
		this.client = new JMenuItem("Cliente");
		this.service = new JMenuItem("Servicio");
		this.client1 = new JMenuItem("Cliente");
		this.service1 = new JMenuItem("Servicio");
		this.client2 = new JMenuItem("Cliente");
		this.service2 = new JMenuItem("Servicio");
		this.client3 = new JMenuItem("Cliente");
		this.service3 = new JMenuItem("Servicio");
		this.client4 = new JMenuItem("Cliente");
		this.service4 = new JMenuItem("Servicio");
		this.me = new ManagementEvents(ps);
	}
	
	public void addComponents() {
		this.menuItemAddUser.setActionCommand(me.ADD_CLIENT);
		this.menuItemAddUser.addActionListener(me);
		
		this.menuItemDeleteUser.setActionCommand(me.DELETE_CLIENT);
		this.menuItemDeleteUser.addActionListener(me);
		
		this.menuItemAddService.setActionCommand(me.ADD_SERVICE);
		this.menuItemAddService.addActionListener(me);
		
		this.client.setActionCommand(me.LOAD_CLIENT_FILE_PLAIN);
		this.client.addActionListener(this.me);
		
		this.service.setActionCommand(me.LOAD_SERVICE_FILE_PLAIN);
		this.service.addActionListener(this.me);
		
		this.client1.setActionCommand(me.LOAD_CLIENT_FILE_CSV);
		this.client1.addActionListener(this.me);
		
		this.service1.setActionCommand(me.LOAD_SERVICE_FILE_CSV);
		this.service1.addActionListener(this.me);
		
		this.client2.setActionCommand(me.LOAD_CLIENT_FILE_JSON);
		this.client2.addActionListener(this.me);
		
		this.service2.setActionCommand(me.LOAD_SERVICE_FILE_JSON);
		this.service2.addActionListener(this.me);
		
		this.client3.setActionCommand(me.LOAD_CLIENT_FILE_SER);
		this.client3.addActionListener(this.me);
		
		this.service3.setActionCommand(me.LOAD_SERVICE_FILE_SER);
		this.service3.addActionListener(this.me);
		
		this.client4.setActionCommand(me.LOAD_CLIENT_FILE_XML);
		this.client4.addActionListener(this.me);
		
		this.service4.setActionCommand(me.LOAD_SERVICE_FILE_XML);
		this.service4.addActionListener(this.me);
		
		this.menuUser.add(this.menuItemAddUser);
		this.menuUser.add(this.menuItemDeleteUser);
		this.add(this.menuUser);
		
		this.menuService.add(this.menuItemAddService);
		this.menuService.add(this.menuItemDeleteservice);
		this.add(this.menuService);
		
		this.menuLoadData.add(this.client);
		this.menuLoadData.add(this.service);
		this.loadData.add(this.menuLoadData);
		
		this.csvData.add(this.client1);
		this.csvData.add(this.service1);
		this.loadData.add(this.csvData);
		
		this.jsonData.add(this.client2);
		this.jsonData.add(this.service2);
		this.loadData.add(this.jsonData);
		
		this.serData.add(this.client3);
		this.serData.add(this.service3);
		this.loadData.add(this.serData);
		
		this.xmlData.add(this.client4);
		this.xmlData.add(this.service4);
		this.loadData.add(this.xmlData);
		this.add(this.loadData);
	}
}
