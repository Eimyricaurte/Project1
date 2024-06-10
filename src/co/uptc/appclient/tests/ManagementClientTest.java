package co.uptc.appclient.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import co.edu.uptc.appclient.persistence.*;
import co.edu.uptc.appclient.enums.ETypeFile;
import co.edu.uptc.appclient.model.*;

class ManagementClientTest {


	private ManagementClient managementClient = new ManagementClient();
	
	private void escenarieOne() {
		managementClient.addClient(new Client("12345648", "Carlos Rios", "2018/03/05", "3214931736", "carlos.rios@uptc.edu.co"));
		managementClient.addClient(new Client("12345649", "Regina Ariza", "2009/11/20", "3215578942", "regina.ariza@uptc.edu.co"));
		managementClient.addClient(new Client("12345650", "Astrid Ortega", "2020/07/01", "3215537238", "astris.ortega@uptc.edu.co"));
		managementClient.addClient(new Client("12345651", "Camilo Macias", "1993/04/28", "3215122222", "camilo.maciass@uptc.edu.co"));
		managementClient.addClient(new Client("12345652", "Diana Rojas", "2023/12/06", "3215578156", "diana.rojas@uptc.edu.co"));
		managementClient.dumpFile(ETypeFile.XML);
	}
	
	private void escenarieTwo() {
		managementClient.setListClient(new ArrayList<>());
		managementClient.loadClient(ETypeFile.XML);
	}
	
	private void escenarieThree() {
		managementClient.addClient(new Client("12345648", "Carlos Rios", "2018/03/05", "3214931736", "carlos.rios@uptc.edu.co"));
		managementClient.addClient(new Client("12345649", "Regina Ariza", "2009/11/20", "3215578942", "regina.ariza@uptc.edu.co"));
		managementClient.addClient(new Client("12345650", "Astrid Ortega", "2020/07/01", "3215537238", "astris.ortega@uptc.edu.co"));
		managementClient.addClient(new Client("12345651", "Camilo Macias", "1993/04/28", "3215122222", "camilo.maciass@uptc.edu.co"));
		managementClient.addClient(new Client("12345652", "Diana Rojas", "2023/12/06", "3215578156", "diana.rojas@uptc.edu.co"));

		managementClient.dumpFile(ETypeFile.SERIALIZATE);
		managementClient.setListClient(new ArrayList<>());
	}
	
	private void escenarieFour() {
		managementClient.loadClient(ETypeFile.SERIALIZATE);
	}
	
	private void escenarieFive() {
		this.escenarieThree();
		this.escenarieFour();
		managementClient.deleteClientById("12345652");
		managementClient.dumpFile(ETypeFile.SERIALIZATE);
	}
	
	private void escenarieSix() {
		managementClient.setListClient(new ArrayList<>());
		managementClient.loadClient(ETypeFile.SERIALIZATE);
	}
	
	private void escenarieSeven() {
		managementClient.addClient(new Client("12345648", "Carlos Rios", "2018/03/05", "3214931736", "carlos.rios@uptc.edu.co"));
		managementClient.addClient(new Client("12345649", "Regina Ariza", "2009/11/20", "3215578942", "regina.ariza@uptc.edu.co"));
		managementClient.addClient(new Client("12345650", "Astrid Ortega", "2020/07/01", "3215537238", "astris.ortega@uptc.edu.co"));
		managementClient.addClient(new Client("12345651", "Camilo Macias", "1993/04/28", "3215122222", "camilo.maciass@uptc.edu.co"));
		managementClient.addClient(new Client("12345652", "Diana Rojas", "2023/12/06", "3215578156", "diana.rojas@uptc.edu.co"));

		managementClient.dumpFile(ETypeFile.CSV);
		managementClient.setListClient(new ArrayList<>());
	}
	
	private void escenarieEight() {
		managementClient.loadClient(ETypeFile.CSV);
	}
	
	private void escenarieNine() {
		managementClient.addClient(new Client("12345648", "Carlos Rios", "2018/03/05", "3214931736", "carlos.rios@uptc.edu.co"));
		managementClient.addClient(new Client("12345649", "Regina Ariza", "2009/11/20", "3215578942", "regina.ariza@uptc.edu.co"));
		managementClient.addClient(new Client("12345650", "Astrid Ortega", "2020/07/01", "3215537238", "astris.ortega@uptc.edu.co"));
		managementClient.addClient(new Client("12345651", "Camilo Macias", "1993/04/28", "3215122222", "camilo.maciass@uptc.edu.co"));
		managementClient.addClient(new Client("12345652", "Diana Rojas", "2023/12/06", "3215578156", "diana.rojas@uptc.edu.co"));

		managementClient.dumpFile(ETypeFile.JSON);
		managementClient.setListClient(new ArrayList<>());
	}
	
	private void escenarieTen() {
		managementClient.loadClient(ETypeFile.JSON);
	}
	
	private void escenarieE() {
		managementClient.addClient(new Client("12345648", "Carlos Rios", "2018/03/05", "3214931736", "carlos.rios@uptc.edu.co"));
		managementClient.addClient(new Client("12345649", "Regina Ariza", "2009/11/20", "3215578942", "regina.ariza@uptc.edu.co"));
		managementClient.addClient(new Client("12345650", "Astrid Ortega", "2020/07/01", "3215537238", "astris.ortega@uptc.edu.co"));
		managementClient.addClient(new Client("12345651", "Camilo Macias", "1993/04/28", "3215122222", "camilo.maciass@uptc.edu.co"));
		managementClient.addClient(new Client("12345652", "Diana Rojas", "2023/12/06", "3215578156", "diana.rojas@uptc.edu.co"));
		managementClient.dumpFile(ETypeFile.TXT);
	}
	
	private void escenarieT() {
		managementClient.setListClient(new ArrayList<>());
		managementClient.loadClient(ETypeFile.TXT);
	}
	
	@Test
	void testPersistenceXML() {
		this.escenarieOne();
		this.escenarieTwo();
		List<Client> listClient= managementClient.getListClient();
		assertNotNull(listClient);
		assertEquals(5, listClient.size());
	}
	
	@Test
	void testPersistenceSerializate() {
		this.escenarieThree();
		this.escenarieFour();
		assertEquals(5, managementClient.getListClient().size());
	}
	
	@Test
	void testPersistenceJSON() {
		this.escenarieNine();
		this.escenarieTen();
		assertEquals(5, managementClient.getListClient().size());
	}
	
	@Test
	void testPersistenceCSV() {
		this.escenarieSeven();
		this.escenarieEight();
		assertEquals(5, managementClient.getListClient().size());
	}
	
	@Test
	void testPersistenceTxt() {
		this.escenarieE();
		this.escenarieT();
		assertEquals(5, managementClient.getListClient().size());
	}
	
	@Test
	void testDeleteObject() {
		this.escenarieFive();
		this.escenarieSix();
		assertEquals(5, managementClient.getListClient().size());
		Client contacto = managementClient.findClientById("12345678");
		assertNull(contacto);
	}
}
