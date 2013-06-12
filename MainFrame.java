/**
 * @(#)MainFrame.java
 *
 *
 * @author 
 * @version 1.00 2013/5/18
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements  ActionListener, WindowListener {
	AdministradorCuentas admCuentas;
	Panel pnlButtons;
	Panel pnlCenter;
	
	//Buttons
	JButton btnAltas, btnConsultas, btnModificaciones, btnBuscar, btnSalir;
	TextField txtBuscar;
	//Labels
	Label lblBuscar;
	
	///Forms
	AltasFrame frmAltas;
//<<<<<<< HEAD
	//ConsultasFrame frmConsultas;
	BajasFrame frmBajas;
//=======
	CuentaFrame frmCuentas;
	ConsultasFrame frmConsultas;    
//>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
	
    public MainFrame() {
    	init();
    	frmAltas = new AltasFrame(admCuentas);
		frmConsultas = new ConsultasFrame(admCuentas);
		frmBajas = new BajasFrame(admCuentas);
    	this.setTitle("Banco - Inicio");
    }
    
    public void init(){
    	admCuentas = new AdministradorCuentas();
    	this.setTitle("Banco - Inicio");
    	this.setSize(400,300);
    	this.setResizable(false);
    	this.addWindowListener(this);
    	initButtons();
    	initCenter();
//<<<<<<< HEAD
//=======
		//initSouth();
//>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
		
    }
    
		
    public void initCenter(){
    	pnlCenter = new Panel();
    	pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
    	lblBuscar =  new Label("Numero de cuenta: ");
    	txtBuscar =  new TextField();
    	btnBuscar = new JButton("Buscar");
    	btnBuscar.addActionListener(this);
    	pnlCenter.add(lblBuscar);
    	pnlCenter.add(txtBuscar);
    	pnlCenter.add(btnBuscar);
    	this.add(pnlCenter,BorderLayout.CENTER);
    }
		    
    public void initButtons(){
    	pnlButtons = new Panel();
    	btnAltas =  new JButton("Altas");

    	btnConsultas = new JButton("Consultas");
    	btnAltas.addActionListener(this);
    	btnConsultas.addActionListener(this);
    	pnlButtons.add(btnAltas);
    	pnlButtons.add(btnConsultas);
    	this.add(pnlButtons,BorderLayout.NORTH);
    	
    }
    
    //metodo que se ejecuta al momento de darse un evento
    public void actionPerformed(ActionEvent ae){
    	//Aqui se ejecutan las opciens de los botones del menu
    	String op =  ((JButton)ae.getSource()).getLabel();//regresar a String
    	switch(op){
    		case "Altas":
    			showAltasForm();
    			break;
    		case "Buscar":
    			buscarCuenta();
    			break;
			case "Consultas":
				showConsultasForm();
				break;
//<<<<<<< HEAD
				
			case "Bajas":
				showBajasForm();
				break;	
	
//=======
//>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
    	}
    	
    }
    
    void showAltasForm(){
    	frmAltas.setVisible(true);
    }
    
	void buscarCuenta(){
		int ncuenta =  Integer.parseInt(txtBuscar.getText())		;
		CuentaBancaria c = admCuentas.existeCuenta(ncuenta);
		if(c==null)
		{
			JOptionPane.showMessageDialog(null,"Error: No existe la cuenta")	;    			
		}
		else{
			frmCuentas =  new CuentaFrame(c,admCuentas);
		}
	}
    
    
	void showConsultasForm()
	{
		frmConsultas.setVisible(true);
	}

    
	void showBajasForm()
	{
		frmBajas.setVisible(true);
	}
	
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