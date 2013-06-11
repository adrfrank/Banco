/**
 * @(#)CuentaFrame.java
 *
 *
 * @author 
 * @version 1.00 2013/6/6
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CuentaFrame extends JFrame implements WindowListener, ActionListener, IBorrable {
	
	CuentaBancaria cuenta;
	AdministradorCuentas admCuentas;
	
	Boolean enEdicion;
	
	//textfields
	TextField txtNumeroCuenta, txtNombrePropietario, txtSaldoActual, txtPlazo, txtCheques, txtTipoDeCuenta;
	//Labels
	Label lblNumeroCuenta, lblNombrePropietario, lblSaldoActual, lblPlazo, lblCheques, lblTipoDeCuenta;
	
	JButton	btnModificar, btnEliminar, btnRetirar, btnDepositar, btnCancelar;
	
	JPanel pnlCuenta;
	
    public CuentaFrame(CuentaBancaria c, AdministradorCuentas admCuentas) {
		cuenta = c;
		enEdicion = false;
		this.admCuentas = admCuentas;    	    
		pnlCuenta = new JPanel();
		pnlCuenta.setLayout(new GridLayout(6,2));
		initControles();
		this.setSize(400,400);
		this.setVisible(true);
		this.add(pnlCuenta,BorderLayout.CENTER);
		cargarDatos();
    }
    
    void initControles(){
    	btnModificar = new JButton("Modificar");
    	btnEliminar = new JButton("Eliminar");
    	btnRetirar = new JButton("Retirar");
    	btnDepositar = new JButton("Depositar");
    	btnCancelar = new JButton("Cancelar");
    	btnModificar.addActionListener(this);
    	btnEliminar.addActionListener(this);
    	btnRetirar.addActionListener(this);
    	btnDepositar.addActionListener(this);
    	
    	lblNumeroCuenta = new Label("Numero de cuenta: ");
    	lblNombrePropietario = new Label("Nombre del propietario: ");
    	lblSaldoActual = new Label("Saldo actual: ");
    	lblPlazo= new Label("Plazo: ");
    	lblCheques = new Label("Cheques: ");
    	
    	txtNumeroCuenta = new TextField();
    	txtNombrePropietario =  new TextField();
    	txtSaldoActual =  new TextField();
    	txtPlazo =  new TextField();
    	txtCheques =  new TextField();
    	
    	pnlCuenta.add(lblNumeroCuenta);
    	pnlCuenta.add(txtNumeroCuenta);
    	pnlCuenta.add(lblNombrePropietario);
    	pnlCuenta.add(txtNombrePropietario);
    	pnlCuenta.add(lblSaldoActual);
    	pnlCuenta.add(txtSaldoActual);
    	if(cuenta instanceof CuentaDeInversion){
    		pnlCuenta.add(lblPlazo);
    		pnlCuenta.add(txtPlazo);
    	}else{    	
    		pnlCuenta.add(lblCheques);
    		pnlCuenta.add(txtCheques);
    	}
    	pnlCuenta.add(btnModificar);
    	pnlCuenta.add(btnEliminar);
    	pnlCuenta.add(btnRetirar);
    	pnlCuenta.add(btnDepositar);
    	txtNumeroCuenta.setEnabled(false);
    	txtNumeroCuenta.setEnabled(false);
    	txtSaldoActual.setEnabled(false);
    	txtPlazo.setEnabled(false);
    	txtCheques.setEnabled(false);
    }
    
    void cargarDatos(){
    	txtNombrePropietario.setText(cuenta.regresarNombrePropietario());
    	txtNumeroCuenta.setText(""+cuenta.regresarNumCuenta());
    	txtSaldoActual.setText(""+cuenta.regrearSaldoActual());
    	if(cuenta instanceof CuentaDeCheques){
    		txtCheques.setText(""+((CuentaDeCheques)cuenta).regresarNumCheques());    		
    	}
    	else{
    		txtPlazo.setText(""+((CuentaDeInversion)cuenta).regresarPlazo());
    	}
    	
    }
    
  	void modificarCuenta(){
  		if(enEdicion){
  			cuenta.cambiarNombrePropietario(txtNombrePropietario.getText());
  			if(cuenta instanceof CuentaDeCheques)
  				((CuentaDeCheques)cuenta).cambiarNumCheques(Integer.parseInt(txtCheques.getText()));
  			else
  				((CuentaDeInversion)cuenta).cambiarPlazo(txtPlazo.getText());
  			txtNombrePropietario.setEnabled(false);
    		txtPlazo.setEnabled(false);
    		txtCheques.setEnabled(false);
    		btnEliminar.setLabel("Eliminar");
    		JOptionPane.showMessageDialog(null,"La cuenta se guardó correctamente.");
    		enEdicion = false;
  		} else{
  			txtNombrePropietario.setEnabled(true);
  			if(cuenta instanceof CuentaDeCheques)
  				txtPlazo.setEnabled(true);
  			else
  				txtCheques.setEnabled(true);;
  			enEdicion =true;
  			btnEliminar.setLabel("Cancelar");
  		}
  		
  	}
  	
  	void cancelar(){
  		if(enEdicion){
  			txtNombrePropietario.setEnabled(false);
    		txtPlazo.setEnabled(false);
    		txtCheques.setEnabled(false);
    		enEdicion = false;
    		btnEliminar.setText("Eliminar");
  		}
  	}
    
    void eliminarCuenta(){
    	int resp=JOptionPane.showConfirmDialog (null, "¿Esta seguro que desea eliminar la cuenta?");
    	if(resp==JOptionPane.YES_OPTION){
    		try{
    			admCuentas.bajaCuenta(cuenta.regresarNumCuenta());
    			JOptionPane.showMessageDialog(this,"La cuenta se ha eliminado correctamente")	;
    			this.setVisible(false);
    			
    		}
    		catch(Exception ex)
    		{
    			JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage())	;
    		}
    		
    		
    	}
    }
    
    
    public void BorrarCampos(){
    	//Borrar campos aqui.
    	txtNumeroCuenta.setText("");
    	txtNombrePropietario.setText("");
    	txtSaldoActual.setText("");
    	txtPlazo.setText("");
    	txtCheques.setText("");
    }    
    	
    public void actionPerformed(ActionEvent ae){
    	String comando =  ((JButton)ae.getSource()).getLabel();
    	switch(comando){
    		case "Modificar":
    			modificarCuenta();
    			break;
    		case "Eliminar":
    			eliminarCuenta();
    			break;
    		case "Depositar":
    			break;
    		case "Retirar":
    			break;
    		case "Cancelar": 
    			cancelar();
    			break;
    		
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