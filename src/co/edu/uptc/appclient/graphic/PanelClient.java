package co.edu.uptc.appclient.graphic;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelClient extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel dtm;
	private JTable table;

	public PanelClient() {
		setLayout(new GridLayout(1,1));
		this.buildComponents();
		this.addComponents();
	}
	
	private void buildComponents() {
		String [] titles = {"Nombre", "Codigo", "Fecha de suscripcion", "Numero de telefono", "Email"};
		this.dtm = new DefaultTableModel(titles, 0);
		table = new JTable(dtm);
	}
	
	public void setDefaultTableModel(String[] titles) {
		dtm = new DefaultTableModel(titles, 0);
		this.table.setModel(dtm);
	}
	
	public void addRow(Object[] row) {
		dtm.addRow(row);
	}
	
	private void addComponents() {
		this.add(new JScrollPane(table));
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	
}
