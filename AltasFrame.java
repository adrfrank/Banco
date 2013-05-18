/**
 * @(#)AltasFrame.java
 *
 *
 * @author 
 * @version 1.00 2013/5/18
 */
import java.awt.*;
import java.awt.event.*;

public class AltasFrame extends Frame implements WindowListener {
	
	AdministradorCuentas admCuentas;
	Panel controls;
	
	//Labels
	Label lblTipo, lblNombre, lblNumeroCuenta, lblSaldoActual, lblCheques, lblPlazo;
	
	//TextFields
	TextField txtNombre, txtNumeroCuenta, txtSaldoActual, txtCheques, txtPlazo;
	
	//Checboxes
	CheckboxGroup cbg;
	Checkbox cbCheques, cbInversion;
	
	
    public AltasFrame(AdministradorCuentas c) {
    	initControls();
   		this.addWindowListener(this);
    	admCuentas =c;
    	setTitle("Banco - Altas");
    	this.setSize(400,300);
    	this.setResizable(false);
    	
    }
    
    public void initControls(){
    	controls = new Panel();
    	cbg = new CheckboxGroup();
    	cbCheques = new Checkbox("Cuenta de cheques",cbg,false);
    	cbInversion = new Checkbox("Cuenta de inversion",cbg,false);
    	
    	lblNombre = new Label("Nombre del propietario: ");
    	lblNumeroCuenta = new Label("Numero de cuenta: ");
    	lblSaldoActual =  new Label("Saldo actual: ");
    	lblCheques = new Label("Numero de cheques: ");
    	lblPlazo = new Label("Plazo: ");
    	
    	txtNombre = new TextField();
    	txtNumeroCuenta = new TextField();
    	txtSaldoActual = new TextField();
    	txtCheques = new TextField();
    	txtPlazo =  new TextField();
    	
    	controls.setLayout(new GridLayout(6,2));
    	controls.add(cbCheques);
    	controls.add(cbInversion);
    	controls.add(lblNumeroCuenta);
    	controls.add(txtNumeroCuenta);
    	controls.add(lblNombre);
    	controls.add(txtNombre);
    	controls.add(lblSaldoActual);
    	controls.add(txtSaldoActual);
    	controls.add(lblCheques);
    	controls.add(txtCheques);
    	this.add(controls,BorderLayout.CENTER);
    	
    	
    }
    
    //método que se ejecuta al momento de darse un evento
    public void windowClosing(WindowEvent we){
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
    public void windowDeactivated(WindowEvent we){}    
    
    
}