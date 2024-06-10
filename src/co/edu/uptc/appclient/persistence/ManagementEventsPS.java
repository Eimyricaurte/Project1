package co.edu.uptc.appclient.persistence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.appclient.enums.ETypeFile;
import co.edu.uptc.appclient.graphic.AddClient;
import co.edu.uptc.appclient.graphic.AddService;
import co.edu.uptc.appclient.graphic.PScreen;
import co.edu.uptc.appclient.graphic.PrincipalScreen;
import co.edu.uptc.appclient.model.Client;
import co.edu.uptc.appclient.model.Service;

public class ManagementEventsPS implements ActionListener {

		public static final String CANCEL = "CANCEL";
		public static final String ADD_CLIENT = "ADD_CLIENT";
		public static final String ADD_SERVICE = "ADD-SERVICE";
		
		ManagementClient mc = new ManagementClient();
		
		ManagementService ms = new ManagementService();
		
		private AddClient addClient;
		
		private AddService addS;
		
		private PScreen ps;
		
		
		public ManagementEventsPS(PScreen ps, AddClient addClient, AddService addS) {
			this.ps = ps;
			this.addClient = addClient;
			this.addS = addS;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			PrincipalScreen psc = new PrincipalScreen();
			switch(e.getActionCommand()) {
			case CANCEL:
				psc.setVisible(true);
				break;
			case ADD_CLIENT:
				String id = addClient.iId.getText();
				String name = addClient.iName.getText();
				String date = addClient.iSDate.getText();
				String phone = addClient.iPhone.getText();
				String email = addClient.iEmail.getText();
				Client client = new Client(id, name, date, phone, email);
				mc.addClient(client);
				mc.dumpFile(ETypeFile.TXT);
				mc.dumpFile(ETypeFile.CSV);
				mc.dumpFile(ETypeFile.JSON);
				mc.dumpFile(ETypeFile.SERIALIZATE);
				mc.dumpFile(ETypeFile.XML);
				psc.setVisible(true);
				break;
			case ADD_SERVICE:
				String idClient = addS.iIdClient.getText();
				String idSer = addS.iId.getText();
				String sName = addS.iName.getText();
				String price = addS.iPrice.getText();
				Service service = new Service(idClient, idSer, sName, price);
				ms.addService(service);
				ms.dumpFile(ETypeFile.TXT);
				ms.dumpFile(ETypeFile.CSV);
				ms.dumpFile(ETypeFile.JSON);
				ms.dumpFile(ETypeFile.SERIALIZATE);
				ms.dumpFile(ETypeFile.XML);
				psc.setVisible(true);
				break;
			}
			
		}
}
