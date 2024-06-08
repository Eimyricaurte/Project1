package co.edu.uptc.appclient.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigSer {

	private static ConfigSer configSer;
	
	private Properties propiedades;
	
	private String path;
	
	private String nameFileTXT;
	
	private String nameFileXML;
	
	private String nameFileJSON;
	
	private String nameFileCSV;
	
	private String nameFileSer;
	
	private String principalColorR;
	
	private String principalColorG;
	
	private String principalColorB;
	
	private ConfigSer() {
		this.propiedades= new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/conf/serviceconfig.properties")) {
            propiedades.load(entrada);
            this.path = propiedades.getProperty("app.file.path.txt");
            this.nameFileTXT =  propiedades.getProperty("app.file.name.txt");
            this.nameFileXML = propiedades.getProperty("app.file.name.xml");
            this.nameFileJSON = propiedades.getProperty("app.file.name.json");
            this.nameFileCSV = propiedades.getProperty("app.file.name.csv");
            this.nameFileSer = propiedades.getProperty("app.file.name.ser");
            this.principalColorR = propiedades.getProperty("gui.principal.color.r");
            this.principalColorG = propiedades.getProperty("gui.principal.color.g");
            this.principalColorB = propiedades.getProperty("gui.principal.color.b");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
        }
	}
	
	public static ConfigSer getInstance() {
		if(configSer == null) {
			configSer = new ConfigSer();
		}
		return configSer;
	}

	public Properties getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNameFileTXT() {
		return nameFileTXT;
	}

	public void setNameFileTXT(String nameFileTXT) {
		this.nameFileTXT = nameFileTXT;
	}

	public String getNameFileXML() {
		return nameFileXML;
	}

	public void setNameFileXML(String nameFileXML) {
		this.nameFileXML = nameFileXML;
	}

	public String getNameFileJSON() {
		return nameFileJSON;
	}

	public void setNameFileJSON(String nameFileJSON) {
		this.nameFileJSON = nameFileJSON;
	}

	public String getNameFileCSV() {
		return nameFileCSV;
	}

	public void setNameFileCSV(String nameFileCSV) {
		this.nameFileCSV = nameFileCSV;
	}

	public String getNameFileSer() {
		return nameFileSer;
	}

	public void setNameFileSer(String nameFileSer) {
		this.nameFileSer = nameFileSer;
	}

	public String getPrincipalColorR() {
		return principalColorR;
	}

	public void setPrincipalColorR(String principalColorR) {
		this.principalColorR = principalColorR;
	}

	public String getPrincipalColorG() {
		return principalColorG;
	}

	public void setPrincipalColorG(String principalColorG) {
		this.principalColorG = principalColorG;
	}

	public String getPrincipalColorB() {
		return principalColorB;
	}

	public void setPrincipalColorB(String principalColorB) {
		this.principalColorB = principalColorB;
	}
}
