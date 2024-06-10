package co.edu.uptc.appclient.graphic;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PrincipalScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JMenuExtensions jme;
	private PanelButtonsSouth pbs;
	private PanelClient pc;

	public PrincipalScreen() {
		this.setUpScreen();
		this.buildComponents();
		this.addComponents();
	}

	public void setUpScreen() {
		setSize(900, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}
	
	public void buildComponents() {
		this.jme = new JMenuExtensions(this);
		this.pbs = new PanelButtonsSouth(this);
		this.pc = new PanelClient();
		
	}
	
	public void addComponents() {
		setJMenuBar(jme);
		add(this.pbs, BorderLayout.SOUTH);
		add(this.pc, BorderLayout.CENTER);
	}
	
	public static void main(String [] args) {
		PrincipalScreen ps = new PrincipalScreen();
		ps.setVisible(Boolean.TRUE);
	}

	public JMenuExtensions getJme() {
		return jme;
	}

	public void setJme(JMenuExtensions jme) {
		this.jme = jme;
	}

	public PanelButtonsSouth getPbs() {
		return pbs;
	}

	public void setPbs(PanelButtonsSouth pbs) {
		this.pbs = pbs;
	}

	public PanelClient getPc() {
		return pc;
	}

	public void setPc(PanelClient pc) {
		this.pc = pc;
	}
	

}
