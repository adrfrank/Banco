/**
 * @(#)MainFrame.java
 *
 *
 * @author 
 * @version 1.00 2013/5/18
 */
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame implements  ActionListener, WindowListener {
	AdministradorCuentas admCuentas;
	Panel pnlButtons;
	Panel pnlCenter;
	//Buttons
	Button btnAltas, btnBajas, btnConsultas,  btnBuscar;
	TextField txtBuscar;
	//Labels
	Label lblBuscar;
	
	///Forms
	AltasFrame frmAltas;
	BajasFrame frmBajas;
	
    public MainFrame() {
    	init();
    	
    }
    
    public void init(){
    	admCuentas = new AdministradorCuentas();
    	frmAltas = new AltasFrame(admCuentas);
    	frmBajas = new BajasFrame(admCuentas);
    	this.setTitle("Banco - Inicio");
    	this.setSize(400,300);
    	this.setResizable(false);
    	this.addWindowListener(this);
    	initButtons();
    	initCenter();
    }
    
    public void initCenter(){
    	pnlCenter = new Panel();
    	pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER,30,50));
    	lblBuscar =  new Label("Numero de cuentea: ");
    	txtBuscar =  new TextField();
    	btnBuscar = new Button("Buscar");
    	btnBuscar.addActionListener(this);
    	pnlCenter.add(lblBuscar);
    	pnlCenter.add(txtBuscar);
    	pnlCenter.add(btnBuscar);
    	this.add(pnlCenter,BorderLayout.CENTER);
    }
    
    public void initButtons(){
    	pnlButtons = new Panel();
    	btnAltas =  new Button("Altas");
    	btnBajas =  new Button("Bajas");
    	btnConsultas = new Button("Consultas");
    	btnAltas.addActionListener(this);
    	btnBajas.addActionListener(this);
    	btnConsultas.addActionListener(this);
    	pnlButtons.add(btnAltas);
    	pnlButtons.add(btnBajas);
    	pnlButtons.add(btnConsultas);
    	this.add(pnlButtons,BorderLayout.NORTH);
    }
    
    //método que se ejecuta al momento de darse un evento
    public void actionPerformed(ActionEvent ae){
    	//Aqui se ejecutan las opciens de los botones del menú
    	String op =  ((Button)ae.getSource()).getLabel();
    	switch(op){
    		case "Altas":
    			showAltasForm();
    			break;
    		case "Bajas":
    			showBajasForm();
    			break;
    		case "Consultas": 
    			break;
    		case "Buscar":
    			break;
    	}
    	
    }
    
    void showAltasForm(){
    	frmAltas.setVisible(true);
    }
    
    void showBajasForm()
    {
    	frmBajas.setVisible(true);
   	}
    
    
    //método que se ejecuta al momento de darse un evento
    public void windowClosing(WindowEvent we){
    	System.exit(0);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
    public void windowDeactivated(WindowEvent we){}    
    
    
    public static void main(String args[]){
    	MainFrame frmMain = new MainFrame();
    	frmMain.setVisible(true);
    }
    
}