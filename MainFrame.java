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
	Panel pnlSouth;
	//Buttons
<<<<<<< HEAD
	Button btnAltas, btnBajas, btnConsultas,  btnBuscar;
=======
	Button btnAltas, btnBajas, btnConsultas, btnModificaciones, btnBuscar, btnSalir;
>>>>>>> cf3c5647756604d1830557b1a1f4c91e13873b65
	TextField txtBuscar;
	//Labels
	Label lblBuscar;
	
	///Forms
	AltasFrame frmAltas;
<<<<<<< HEAD
	BajasFrame frmBajas;
	
    public MainFrame() {
    	init();
    	
=======
	ConsultasFrame frmConsultas;
	
    public MainFrame() {
    	init();
    	admCuentas = new AdministradorCuentas();
    	frmAltas = new AltasFrame(admCuentas);
		frmConsultas = new ConsultasFrame(admCuentas);
    	this.setTitle("Banco - Inicio");
>>>>>>> cf3c5647756604d1830557b1a1f4c91e13873b65
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
		//initSouth();
    }
    
		
    public void initCenter(){
    	pnlCenter = new Panel();
    	pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
    	lblBuscar =  new Label("Numero de cuenta: ");
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
    
    //metodo que se ejecuta al momento de darse un evento
    public void actionPerformed(ActionEvent ae){
    	//Aqui se ejecutan las opciens de los botones del menu
    	String op =  ((Button)ae.getSource()).getLabel();//regresar a String
    	switch(op){
    		case "Altas":
    			showAltasForm();
    			break;
<<<<<<< HEAD
    		case "Bajas":
    			showBajasForm();
    			break;
    		case "Consultas": 
    			break;
    		case "Buscar":
    			break;
=======
			
			case "Consultas":
				showConsultasForm();
				break;
	
>>>>>>> cf3c5647756604d1830557b1a1f4c91e13873b65
    	}
    	
    }
    
    void showAltasForm(){
    	frmAltas.setVisible(true);
    }
    
<<<<<<< HEAD
    void showBajasForm()
    {
    	frmBajas.setVisible(true);
   	}
    
=======
	void showConsultasForm()
	{
		frmConsultas.setVisible(true);
	}
>>>>>>> cf3c5647756604d1830557b1a1f4c91e13873b65
    
    //metodo que se ejecuta al momento de darse un evento
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