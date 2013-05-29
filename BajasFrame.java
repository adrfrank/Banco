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
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
    public void windowDeactivated(WindowEvent we){}
    
    
}