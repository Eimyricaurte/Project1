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
import co.edu.uptc.appclient.model.Service;

public class ManagementService  extends FilePlain implements IActionFile {
	private final String NAME_TAG_SERVICE = "service";
	private List<Service> listService;
	
	public ManagementService() {
		this.listService = new ArrayList<>();
	}
	
	public void addService(Service service) {
		listService.add(service);
	}
	
	public Service findServiceById(String id) {
		for(Service service: this.listService) {
			if(service.getName().equals(id)) {
				return service;
			}
		}
		return null;
	}
	
	public void deleteServiceById(String id) {
		if(!Objects.isNull(findServiceById(id))) {
			this.listService.remove(findServiceById(id));
		}
	}	
	
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.dumpFilePlain(cValue.getPath().concat(cValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.dumpFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.dumpFileCSV(cValue.getPath().concat(cValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.dumpFileSerializate();
		}
	}

	public void loadService(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.loadFilePlain(cValue.getPath().concat(cValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.loadFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.loadFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.loadFileCSV(cValue.getPath().concat(cValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.loadFileSerializate();
		}
	}
	
	private void dumpFilePlain(String filePath) {
		List<String> records = new ArrayList<>();
		 for(Service service : listService){
			 StringBuilder contentService = new StringBuilder();
			 contentService.append(service.getIdClient()).append(Constants.SEMI_COLON);
			 contentService.append(service.getId()).append(Constants.SEMI_COLON);
			 contentService.append(service.getName()).append(Constants.SEMI_COLON);
			 contentService.append(service.getPrice());
			 records.add(contentService.toString());
		 }
		 this.writer(filePath, records);
	}
	
	private void loadFilePlain(String nameFilePath) {
		List<String> contentInLine = this.reader(nameFilePath);
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, Constants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String idClient = tokens.nextToken();
				String id = tokens.nextToken();
				String name = tokens.nextToken();
				String price = tokens.nextToken();
				listService.add(new Service(idClient, id, name, price));
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
		String filePath = cValue.getPath().concat(cValue.getNameFileXML());
		StringBuilder lines = new StringBuilder();
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Service service : this.listService) {
			lines.append("<service>\n");
			lines.append("<idClient>"+service.getIdClient()+"</idClien>\n");
			lines.append("<id>"+service.getId()+"</id>\n");
			lines.append("<name>"+service.getName()+"</name>\n");
			lines.append("<price>"+service.getPrice()+"</price>\n");
			lines.append("</service>\n");
		}
		lines.append("</XML>");
		this.writeFile(filePath, lines.toString());
	}
	
	private void loadFileXML() {
		try {
			File file = new File(cValue.getPath().concat(cValue.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(NAME_TAG_SERVICE);
			for (int i = 0; i < list.getLength(); i++) {
				String idClient = document.getElementsByTagName("idClient").item(i).getTextContent();
				String id = document.getElementsByTagName("id").item(i).getTextContent();
				String name = document.getElementsByTagName("name").item(i).getTextContent();
				String price = document.getElementsByTagName("price").item(i).getTextContent();
				this.listService.add(new Service(idClient, id, name, price));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
	}
	
	private void dumpFileJSON() {
		String filePath = cValue.getPath().concat(cValue.getNameFileJSON());
		StringBuilder stringJSON = new StringBuilder();
		stringJSON.append("[\n");
		for(int i=0; i<this.listService.size(); i++) {
			stringJSON.append("{\n");
			stringJSON.append("\"idClient\":\"").append(listService.get(i).getIdClient())
			.append("\",\n");
			stringJSON.append("\"id\":\"").append(listService.get(i).getId())
			.append("\",\n");
			stringJSON.append("\"name\":\"").append(listService.get(i).getName())
				.append("\",\n");
			stringJSON.append("\"price\":\"").append(listService.get(i)
					.getPrice()).append("\"\n");
			stringJSON.append("}");
			if(i < this.listService.size() - 1) {
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
		fileName.append(this.cValue.getPath());
		fileName.append(this.cValue.getNameFileJSON());
		String content = this.readFile(fileName.toString());
		content = content.trim();
		
        if (content.startsWith("[") && content.endsWith("]")) {
        	content = content.substring(1, content.length() - 1);
        }
        
        String[] objects = content.split("\\}, \n\\{");
        for (String obj : objects) {
            obj = obj.replace("{", "").replace("}", "");
            String[] fields = obj.split(",");
            String idClient ="", id = "", name = "", price = "";
            for(String field: fields) {
            	String[] keyValue = field.split(":");
            	String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                switch(key) {
	                case "idClient":
	                	idClient = value;
	            	break;
	                case "id":
	                	id = value;
                	break;
	                case "name":
	                	name = value;
	                	break;
	                case "subscriptionDate":
	                	price = value;
	                	break;
                }
            }
            this.listService.add(new Service(idClient, id, name, price));
        }
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.cValue.getPath()
				.concat(this.cValue.getNameFileSer()));
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
				out.writeObject(this.listService);
	    } catch (IOException i) {
	    	i.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.cValue.getPath()
				.concat(this.cValue.getNameFileSer()));
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            this.listService = (List<Service>) in.readObject();
	        } catch (IOException i) {
	            i.printStackTrace();
	        } catch (ClassNotFoundException c) {
	            c.printStackTrace();
	        }
	}

	public List<Service> getListService() {
		return listService;
	}

	public void setListService(List<Service> listService) {
		this.listService = listService;
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
