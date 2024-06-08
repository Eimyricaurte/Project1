package co.edu.uptc.appclient.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import co.edu.uptc.appclient.constants.Constants;
import co.edu.uptc.appclient.enums.ETypeFile;
import co.edu.uptc.appclient.interfaces.IActionFile;
import co.edu.uptc.appclient.model.Client;
import co.edu.uptc.appclient.persistence.FilePlain;

public class ManagementClient extends FilePlain implements IActionFile {
	private final String NAME_TAG_CLIENT = "client";
	private List<Client> listClient;
	
	public ManagementClient() {
		this.listClient = new ArrayList<>();
	}
	
	public void addClient(Client client) {
		listClient.add(client);
	}
	
	public Client findClientByName(String name) {
		for(Client client: this.listClient) {
			if(client.getName().equals(name)) {
				return client;
			}
		}
		return null;
	}
	
	public void deleteClientByName(String name) {
		if(!Objects.isNull(findClientByName(name))) {
			this.listClient.remove(findClientByName(name));
		}
	}	
	
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.dumpFilePlain(confValue.getPath().concat(confValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.dumpFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.dumpFileCSV(confValue.getPath().concat(confValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.dumpFileSerializate();
		}
	}

	public void loadClient(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.loadFilePlain(confValue.getPath().concat(confValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.loadFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.loadFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.loadFileCSV(confValue.getPath().concat(confValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.loadFileSerializate();
		}
	}
	
	private void dumpFilePlain(String filePath) {
		List<String> records = new ArrayList<>();
		 for(Client client : listClient){
			 StringBuilder contentClient = new StringBuilder();
			 contentClient.append(client.getId()).append(Constants.SEMI_COLON);
			 contentClient.append(client.getName()).append(Constants.SEMI_COLON);
			 contentClient.append(client.getSubscriptionDate()).append(Constants.SEMI_COLON);
			 contentClient.append(client.getPhoneNumber()).append(Constants.SEMI_COLON);
			 contentClient.append(client.getEmail()).append(Constants.SEMI_COLON);
			 contentClient.append(client.getFee());
			 records.add(contentClient.toString());
		 }
		 this.writer(filePath, records);
	}
	
	private void loadFilePlain(String nameFilePath) {
		List<String> contentInLine = this.reader(nameFilePath);
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, Constants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String id = tokens.nextToken();
				String name = tokens.nextToken();
				String subscriptionDate = tokens.nextToken();
				String phoneNumber = tokens.nextToken();
				String email = tokens.nextToken();
				String fee = tokens.nextToken();
				listClient.add(new Client(id, name, subscriptionDate, phoneNumber, email, fee));
			}
		});
	}
	
	private void dumpFileCSV(String filePath) {
		this.dumpFilePlain(filePath);
	}
	
	private void loadFileCSV(String filePath) {
		this.loadFilePlain(filePath);
	}
	
	private void dumpFileXML() {
		String filePath = confValue.getPath().concat(confValue.getNameFileXML());
		StringBuilder lines = new StringBuilder();
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Client client : this.listClient) {
			lines.append("<client>\n");
			lines.append("<id>"+client.getId()+"</id>\n");
			lines.append("<name>"+client.getName()+"</name>\n");
			lines.append("<subscriptionDate>"+client.getSubscriptionDate()+"</subscriptionDate>\n");
			lines.append("<phoneNumber>"+client.getPhoneNumber()+"</phoneNumber>\n");
			lines.append("<email>"+client.getEmail()+"</email>\n");
			lines.append("<fee>"+client.getFee()+"</fee>\n");
			lines.append("</client>\n");
		}
		lines.append("</XML>");
		this.writeFile(filePath, lines.toString());
	}
	
	private void loadFileXML() {
		try {
			File file = new File(confValue.getPath().concat(confValue.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(NAME_TAG_CLIENT);
			for (int i = 0; i < list.getLength(); i++) {
				String id = document.getElementsByTagName("id").item(i).getTextContent();
				String name = document.getElementsByTagName("name").item(i).getTextContent();
				String subscriptionDate = document.getElementsByTagName("subscriptionDate").item(i).getTextContent();
				String phoneNumber = document.getElementsByTagName("phoneNumber").item(i).getTextContent();
				String email = document.getElementsByTagName("email").item(i).getTextContent();
				String fee = document.getElementsByTagName("fee").item(i).getTextContent();
				this.listClient.add(new Client(id, name, subscriptionDate, phoneNumber, email, fee));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
	}
	
	private void dumpFileJSON() {
		String filePath = confValue.getPath().concat(confValue.getNameFileJSON());
		StringBuilder stringJSON = new StringBuilder();
		stringJSON.append("[\n");
		for(int i=0; i<this.listClient.size(); i++) {
			stringJSON.append("{\n");
			stringJSON.append("\"id\":\"").append(listClient.get(i).getId())
			.append("\",\n");
			stringJSON.append("\"name\":\"").append(listClient.get(i).getName())
				.append("\",\n");
			stringJSON.append("\"subscriptionDate\":\"").append(listClient.get(i).getSubscriptionDate())
				.append("\",\n");
			stringJSON.append("\"phoneNumber\":\"").append(listClient.get(i)
					.getPhoneNumber()).append("\",\n");
			stringJSON.append("\"email\":\"").append(listClient.get(i).getEmail())
				.append("\",\n");
			stringJSON.append("\"fee\":\"").append(listClient.get(i)
					.getFee()).append("\"\n");
			stringJSON.append("}");
			if(i < this.listClient.size() - 1) {
				stringJSON.append(", \n");
			}else {
				stringJSON.append("\n");
			}
		}
		stringJSON.append("]");
		this.writeFile(filePath, stringJSON.toString());
	}
	
	private void loadFileJSON() {
		StringBuilder fileName = new StringBuilder();
		fileName.append(this.confValue.getPath());
		fileName.append(this.confValue.getNameFileJSON());
		String content = this.readFile(fileName.toString());
		content = content.trim();
		
        if (content.startsWith("[") && content.endsWith("]")) {
        	content = content.substring(1, content.length() - 1);
        }
        
        String[] objects = content.split("\\}, \n\\{");
        for (String obj : objects) {
            obj = obj.replace("{", "").replace("}", "");
            String[] fields = obj.split(",");
            String id = "", name = "", subscriptionDate = "", phoneNumber = "", email = "", fee = "";
            for(String field: fields) {
            	String[] keyValue = field.split(":");
            	String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                switch(key) {
	                case "id":
	                	id = value;
                	break;
	                case "name":
	                	name = value;
	                	break;
	                case "subscriptionDate":
	                	subscriptionDate = value;
	                	break;
	                case "phoneNumber":
	                	phoneNumber = value;
	                	break;
	                case "email":
	                	email = value;
	                	break;
	                case "fee":
	                	fee = value;
	                	break;
                }
            }
            this.listClient.add(new Client(id, name, subscriptionDate, phoneNumber, email, fee));
        }
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.confValue.getPath()
				.concat(this.confValue.getNameFileSer()));
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(this.listClient);
	    } catch (IOException i) {
	    	i.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.confValue.getPath()
				.concat(this.confValue.getNameFileSer()));
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            this.listClient = (List<Client>) in.readObject();
	        } catch (IOException i) {
	            i.printStackTrace();
	        } catch (ClassNotFoundException c) {
	            c.printStackTrace();
	        }
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	@Override
	public void loadClients(ETypeFile eTypeFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadServices(ETypeFile eTypeFile) {
		// TODO Auto-generated method stub
		
	}

}
