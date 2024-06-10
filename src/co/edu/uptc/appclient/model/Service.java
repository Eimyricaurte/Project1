package co.edu.uptc.appclient.model;

import java.io.*;

public class Service implements Serializable{
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String price;
	
	private String idClient;

	public Service(String idClient, String id, String name, String price) {
		super();
		this.idClient= idClient;
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Service() {
		super();
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public String getIdClient() {
		return idClient;
	}

	
	

}
