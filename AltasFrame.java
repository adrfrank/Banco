/**
 * @(#)AltasFrame.java
 *
 *
 * @author 
 * @version 1.00 2013/5/18
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AltasFrame extends JFrame implements WindowListener, ActionListener, ItemListener, IBorrable {
	
	AdministradorCuentas admCuentas;
	Panel controls;
	
	//Labels
	Label lblTipo, lblNombre, lblNumeroCuenta, lblSaldoActual, lblCheques, lblPlazo, lblMensaje;
	
	//TextFields
	TextField txtNombre, txtNumeroCuenta, txtSaldoActual, txtCheques, txtPlazo;
	
	//Checboxes
	CheckboxGroup cbg;
	Checkbox cbCheques, cbInversion;
	
	JButton btnAgregar;	
		
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
    	cbCheques = new Checkbox("Cuenta de cheques",cbg,true);
    	cbInversion = new Checkbox("Cuenta de inversion",cbg,false);
    	cbCheques.addItemListener(this);
    	cbInversion.addItemListener(this);
    	lblNombre = new Label("Nombre del propietario: ");
    	lblNumeroCuenta = new Label("Numero de cuenta: ");
    	lblSaldoActual =  new Label("Saldo actual: ");
    	lblCheques = new Label("Numero de cheques: ");
    	lblPlazo = new Label("Plazo: ");    	
    	btnAgregar = new JButton("Agregar"); 
    	btnAgregar.addActionListener(this)   	;
    	txtNombre = new TextField();
    	txtNumeroCuenta = new TextField();
    	txtSaldoActual = new TextField();
    	txtCheques = new TextField();
    	txtPlazo =  new TextField();
    	txtPlazo.setEnabled(false);    	
    	controls.setLayout(new GridLayout(7,2));
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
    	controls.add(lblPlazo);
    	controls.add(txtPlazo);
    	controls.add(btnAgregar);
    	this.add(controls,BorderLayout.CENTER);	
    
    }
    
    public void itemStateChanged(ItemEvent ie){
    	if(((Checkbox)ie.getSource()).getLabel() == "Cuenta de cheques")
    	{
    		txtPlazo.setEnabled(false);
    		txtCheques.setEnabled(true);
    		
    	}
    	else{
    		txtPlazo.setEnabled(true);
    		txtCheques.setEnabled(false);
    	}
    }
    
    public void BorrarCampos(){
    	txtNumeroCuenta.setText("");
    	txtSaldoActual.setText("");
    	txtNombre.setText("");
    	txtPlazo.setText("");
    	txtCheques.setText("");
    }
    
    public void actionPerformed(ActionEvent ae){
    	CuentaBancaria c;
    	try{
    		if(txtPlazo.isEnabled()){
				c = new CuentaDeInversion(Integer.parseInt(txtNumeroCuenta.getText()), Double.parseDouble(txtSaldoActual.getText()), txtNombre.getText(), txtPlazo.getText());
			}else
			{
				c = new CuentaDeCheques(Integer.parseInt(txtNumeroCuenta.getText()), Double.parseDouble(txtSaldoActual.getText()), txtNombre.getText(), Integer.parseInt(txtCheques.getText()));	
			}
			admCuentas.agregarCuenta(c);
			BorrarCampos();
			System.out.println("La cuenta se agrego correctamente");
			JOptionPane.showMessageDialog(null,"La cuenta se agrego correctamente")	;
			
    		
	    }
    	catch(Exception ex){
    		System.out.println("Error: "+ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage())	;    		
    	}
		
    }
    
    //metodo que se ejecuta al momento de darse un evento
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