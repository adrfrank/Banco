<<<<<<< HEAD
import java.awt.*;
import java.awt.event.*;

public class BajasFrame extends Frame implements WindowListener
{
	AdministradorCuentas admCuentas;
	
	Panel pnlControls;
	
	Label lblNumCuenta;
	
	TextField txtNumCuenta;
	
	Button btnEliminar;
	
	public BajasFrame(AdministradorCuentas c)
	{
		initControls();
		this.addWindowListener(this);
		admCuentas=c;
		setTitle("Banco - Bajas");
		this.setSize(400,300);
		this.setResizable(false);
	}
	
	public void initControls()
	{
		pnlControls = new Panel();
		
		lblNumCuenta = new Label("Numero de cuenta: ");
		btnEliminar=new Button("Eliminar");
		txtNumCuenta= new TextField("Ingrese No.de cuenta a eliminar", 20);
		
		pnlControls.setLayout(new GridLayout(4,2));
		pnlControls.add(lblNumCuenta);
		pnlControls.add(txtNumCuenta);
		pnlControls.add(btnEliminar);
		this.add(pnlControls,BorderLayout.CENTER);
	}
	
	public void windowClosing(WindowEvent we){
=======
/**
 * @(#)BajasForm.java
 *
 *
 * @author 
 * @version 1.00 2013/5/19
 */

import java.awt.*;
import java.awt.event.*;

public class BajasFrame extends Frame implements WindowListener,ActionListener {
	AdministradorCuentas admCuentas;
	
	
    public BajasFrame(AdministradorCuentas c) {
    	admCuentas = c;
    	init();	
    }
    
    void init(){
    	this.addWindowListener(this);
    	this.setTitle("Banco - Bajas");
    	this.setSize(300,200);
    }
    
    public void actionPerformed(ActionEvent ae){
    		
   	}
    
    //método que se ejecuta al momento de darse un evento
    public void windowClosing(WindowEvent we){
>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
<<<<<<< HEAD
    public void windowDeactivated(WindowEvent we){}    
	
}//Fin de la clase
=======
    public void windowDeactivated(WindowEvent we){}
    
    
}
>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
