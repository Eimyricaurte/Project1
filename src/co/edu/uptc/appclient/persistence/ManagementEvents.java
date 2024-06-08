package co.edu.uptc.appclient.persistence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import co.edu.uptc.appclient.enums.ETypeFile;
import co.edu.uptc.appclient.graphic.PrincipalScreen;
import co.edu.uptc.appclient.model.Client;
import co.edu.uptc.appclient.model.Service;

public class ManagementEvents implements ActionListener {
	
	public static final String LOAD_CLIENT_FILE_PLAIN = "LOAD_CLIENT_FILE_PLAIN";
	public static final String LOAD_SERVICE_FILE_PLAIN = "LOAD_SERVICE_FILE_PLAIN";
	
	public static final String LOAD_CLIENT_FILE_CSV = "LOAD_CLIENT_FILE_CSV";
	public static final String LOAD_SERVICE_FILE_CSV = "LOAD_SERVICE_FILE_CSV";
	
	public static final String LOAD_CLIENT_FILE_JSON = "LOAD_CLIENT_FILE_JSON";
	public static final String LOAD_SERVICE_FILE_JSON = "LOAD_SERVICE_FILE_JSON";
	
	public static final String LOAD_CLIENT_FILE_SER = "LOAD_CLIENT_FILE_SER";
	public static final String LOAD_SERVICE_FILE_SER = "LOAD_SERVICE_FILE_SER";
	
	public static final String LOAD_CLIENT_FILE_XML = "LOAD_CLIENT_FILE_XML";
	public static final String LOAD_SERVICE_FILE_XML = "LOAD_SERVICE_FILE_XML";
	private ManagementClient management;
	private ManagementService mService = new ManagementService();
	private PrincipalScreen ps;
	
	
	public ManagementEvents(PrincipalScreen ps) {
		this.management = new ManagementClient();
		this.ps = ps;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String[] titlesService= {"Codigo de cliente", "Codgo", "Nombre", "Precio"};
		switch(e.getActionCommand()) {
		case LOAD_CLIENT_FILE_PLAIN:
			this.management.setListClient(new ArrayList<>());
			this.management.loadClient(ETypeFile.TXT);
			this.clearTable();
			this.management.getListClient().forEach(client -> {
				Object[] row = new Object[] {client.getName(), client.getId(), client.getSubscriptionDate(), client.getPhoneNumber(), client.getEmail(), client.getFee()};
						this.ps.getPc().addRow(row);
				});
			break;
		case LOAD_SERVICE_FILE_PLAIN:
			this.mService.setListService(new ArrayList<>());
			this.ps.getPc().setDefaultTableModel(titlesService);
			String idClient = JOptionPane.showInputDialog("Digite el id del cliente");
			this.mService.loadService(ETypeFile.TXT);
			List<Service> listServiceAux= this.mService.getListService();
			this.clearTable();
			listServiceAux = listServiceAux.stream().filter(service -> service.getIdClient().equalsIgnoreCase(idClient)).collect(Collectors.toList());
			listServiceAux.forEach(service -> {
				Object[] row = new Object[] {service.getIdClient()};
				this.ps.getPc().addRow(row);
				
			});;
			break;
		case LOAD_CLIENT_FILE_CSV:
			this.management.setListClient(new ArrayList<>());
			this.management.loadClient(ETypeFile.CSV);
			this.clearTable();
			this.management.getListClient().forEach(client -> {
				Object[] row = new Object[] {client.getName(), client.getId(), client.getSubscriptionDate(), client.getPhoneNumber(), client.getEmail(), client.getFee()};
						this.ps.getPc().addRow(row);
				});
			break;
		case LOAD_SERVICE_FILE_CSV:
			this.mService.setListService(new ArrayList<>());
			this.ps.getPc().setDefaultTableModel(titlesService);
			idClient = JOptionPane.showInputDialog("Digite el id del cliente");
			this.mService.loadService(ETypeFile.CSV);
			listServiceAux= this.mService.getListService();
			this.clearTable();
			listServiceAux = listServiceAux.stream().filter(service -> service.getIdClient().equalsIgnoreCase(idClient)).collect(Collectors.toList());
			listServiceAux.forEach(service -> {
				Object[] row = new Object[] {service.getIdClient()};
				this.ps.getPc().addRow(row);
				
			});;
			break;
		case LOAD_CLIENT_FILE_JSON:
			this.management.setListClient(new ArrayList<>());
			this.management.loadClient(ETypeFile.JSON);
			this.clearTable();
			this.management.getListClient().forEach(client -> {
				Object[] row = new Object[] {client.getName(), client.getId(), client.getSubscriptionDate(), client.getPhoneNumber(), client.getEmail(), client.getFee()};
						this.ps.getPc().addRow(row);
				});
			break;
		case LOAD_SERVICE_FILE_JSON:
			this.mService.setListService(new ArrayList<>());
			this.ps.getPc().setDefaultTableModel(titlesService);
			idClient = JOptionPane.showInputDialog("Digite el id del cliente");
			this.mService.loadService(ETypeFile.JSON);
			listServiceAux= this.mService.getListService();
			this.clearTable();
			listServiceAux = listServiceAux.stream().filter(service -> service.getIdClient().equalsIgnoreCase(idClient)).collect(Collectors.toList());
			listServiceAux.forEach(service -> {
				Object[] row = new Object[] {service.getIdClient()};
				this.ps.getPc().addRow(row);
				
			});;
			break;
		case LOAD_CLIENT_FILE_SER:
			this.management.setListClient(new ArrayList<>());
			this.management.loadClient(ETypeFile.SERIALIZATE);
			this.clearTable();
			this.management.getListClient().forEach(client -> {
				Object[] row = new Object[] {client.getName(), client.getId(), client.getSubscriptionDate(), client.getPhoneNumber(), client.getEmail(), client.getFee()};
						this.ps.getPc().addRow(row);
				});
			break;
		case LOAD_SERVICE_FILE_SER:
			this.mService.setListService(new ArrayList<>());
			this.ps.getPc().setDefaultTableModel(titlesService);
			idClient = JOptionPane.showInputDialog("Digite el id del cliente");
			this.mService.loadService(ETypeFile.SERIALIZATE);
			listServiceAux= this.mService.getListService();
			this.clearTable();
			listServiceAux = listServiceAux.stream().filter(service -> service.getIdClient().equalsIgnoreCase(idClient)).collect(Collectors.toList());
			listServiceAux.forEach(service -> {
				Object[] row = new Object[] {service.getIdClient()};
				this.ps.getPc().addRow(row);
				
			});;
			break;
		case LOAD_CLIENT_FILE_XML:
			this.management.setListClient(new ArrayList<>());
			this.management.loadClient(ETypeFile.XML);
			this.clearTable();
			this.management.getListClient().forEach(client -> {
				Object[] row = new Object[] {client.getName(), client.getId(), client.getSubscriptionDate(), client.getPhoneNumber(), client.getEmail(), client.getFee()};
						this.ps.getPc().addRow(row);
				});
			break;
		case LOAD_SERVICE_FILE_XML:
			this.mService.setListService(new ArrayList<>());
			this.ps.getPc().setDefaultTableModel(titlesService);
			idClient = JOptionPane.showInputDialog("Digite el id del cliente");
			this.mService.loadService(ETypeFile.XML);
			listServiceAux= this.mService.getListService();
			this.clearTable();
			listServiceAux = listServiceAux.stream().filter(service -> service.getIdClient().equalsIgnoreCase(idClient)).collect(Collectors.toList());
			listServiceAux.forEach(service -> {
				Object[] row = new Object[] {service.getIdClient()};
				this.ps.getPc().addRow(row);
				
			});;
			break;
		}
		
	}
	
	private void clearTable() {
		for (int i = (this.ps.getPc().getDtm().getRowCount() - 1); i >= 0;i--) {
			this.ps.getPc().getDtm().removeRow(i);
		}
	}

}
