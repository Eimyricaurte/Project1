package co.edu.uptc.appclient.interfaces;

import co.edu.uptc.appclient.enums.ETypeFile;

public interface IActionFile {
	public void dumpFile(ETypeFile eTypeFile);
	public void loadClients(ETypeFile eTypeFile);
	public void loadServices(ETypeFile eTypeFile);
}